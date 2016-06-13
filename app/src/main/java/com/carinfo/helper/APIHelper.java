package com.carinfo.helper;

import android.app.Activity;
import android.content.res.Resources;
import android.os.AsyncTask;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.carinfo.CarInfo;
import com.carinfo.R;
import com.carinfo.realm.Car;
import com.carinfo.realm.CarDetails;
import com.carinfo.realm.CarMake;
import com.carinfo.realm.CarModel;
import com.carinfo.realm.CarRatings;
import com.carinfo.realm.CarStyles;
import com.carinfo.realm.CarYear;
import com.carinfo.realm.CustomString;
import com.carinfo.realm.Image;
import com.carinfo.utils.Constant;
import com.carinfo.utils.ServerResult;
import com.carinfo.utils.Utils;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.InputStream;
import java.lang.reflect.Type;
import java.util.ArrayList;

import io.realm.Realm;
import io.realm.RealmConfiguration;
import io.realm.RealmList;
import io.realm.RealmResults;

/**
 * Created by karunamoorthy on 2/6/16.
 */
public class APIHelper {

    private RequestQueue requestQueue;
    private RealmConfiguration realmConfiguration;
    private Realm realm;
    private ServerResult serverResult;
    private Activity activity;
    private Gson mGson;

    public APIHelper(Activity activty1, ServerResult serverResult1) {
        requestQueue = VolleyHelper.getInstance().getRequestQueue();
        realmConfiguration = new RealmConfiguration.Builder(activty1).deleteRealmIfMigrationNeeded().build();
        serverResult = serverResult1;
        activity = activty1;
        mGson = new Gson();
    }

    public void getCarDetail(final String styleId) {
        String url = Constant.getCarDetail(styleId);
        GSONRequestHelper modelData = new GSONRequestHelper<CarDetails>(Request.Method
                .GET, url, CarDetails.class, null,
                new Response.Listener<CarDetails>() {
                    @Override
                    public void onResponse(CarDetails response) {
                        if (response != null) {
                            response.setStyleId(styleId);
                            realm = Realm.getInstance(realmConfiguration);
                            realm.beginTransaction();
                            realm.copyToRealm(response);
                            realm.commitTransaction();
                            Log.e("Result = ", "Data Inserted");
                        }
                    }
                }
                , new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("Error ", "Data");
            }
        });

        if (Utils.isNetworkAvailable(CarInfo.getAppContext())) {
            requestQueue.add(modelData);
        }
    }

    public void getCarRating(final String styleId) {
        String url = Constant.getCarRatings(styleId);
        Log.e("Result = ", url);
        GSONRequestHelper modelData = new GSONRequestHelper<CarRatings>(Request.Method
                .GET, url, CarRatings.class, null,
                new Response.Listener<CarRatings>() {
                    @Override
                    public void onResponse(CarRatings response) {
                        if (response != null) {

                            Log.e("Result = ", "Data Inserted" + response.getGrade());
                        }
                    }
                }
                , new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("Error ", "Data");
            }
        });

        if (Utils.isNetworkAvailable(CarInfo.getAppContext())) {
            requestQueue.add(modelData);
        }
    }

    public RealmResults<CarDetails> getStyleData(String styleID) {
        realm = Realm.getInstance(realmConfiguration);
        return realm.where(CarDetails.class).equalTo("styleId", styleID).findAll();
    }

    public RealmResults<CarMake> getMakeData() {
        realm = Realm.getInstance(realmConfiguration);
        return realm.where(CarMake.class).findAll();
    }

    private RealmList<CustomString> carImage(ArrayList<Image> result) {
        String path = "";
        RealmList<CustomString> data = new RealmList<>();
        for (Image image : result) {
            CustomString customString = new CustomString();
            customString.setTitle(image.captionTranscript);
            for (int i = 0; i < image.photoSrcs.size(); i++) {
                path = String.valueOf(image.photoSrcs.get(i));
                if (path.contains("_500")) {
                    Log.e("String = ", Constant.MEDIA_HOST_URL + path);
                    path = Constant.MEDIA_HOST_URL + path;
                    break;
                } else if (path.contains("_400")) {
                    Log.e("String = ", Constant.MEDIA_HOST_URL + path);
                    path = Constant.MEDIA_HOST_URL + path;
                    break;
                }
            }
            customString.setPath(path);
            data.add(customString);
        }
        return data;
    }

    public synchronized void getCarImage(final String id, final String name, final String model, final int year) {
        String url = Constant.getImageUrl(id);
        Log.e("url = ", url);
        final Type type = new TypeToken<ArrayList<Image>>() {
        }.getType();
        final GSONRequestHelper contentDetailsRequest = new GSONRequestHelper<>
                (url, type,
                        new Response.Listener<ArrayList<Image>>() {

                            @Override
                            public void onResponse(ArrayList<Image> response) {
                                Log.e("Path", getPath(response));
                                if (response != null && response.size() > 0) {
                                    CarMake carMake = getModelImages(name);
                                    for (int i = 0; i < carMake.getModels().size(); i++) {
                                        CarModel carModel = carMake.getModels().get(i);
                                        if (carModel.getName().equalsIgnoreCase(model)) {
                                            for (int j = 0; j < carModel.getYears().size(); j++) {
                                                CarYear carYear = carModel.getYears().get(j);
                                                if (carYear.getYear() == year) {
                                                    for (int k = 0; k < carYear.getStyles().size(); k++) {
                                                        CarStyles carStyles = carYear.getStyles().get(k);
                                                        if (String.valueOf(carStyles.getId()).equalsIgnoreCase(id)) {
                                                            realm = Realm.getInstance(realmConfiguration);
                                                            realm.beginTransaction();
                                                            carStyles.setMakeName(name);
                                                            carStyles.setModelName(model);
                                                            carStyles.setYear(year);
                                                            carStyles.setStyleId(id);
                                                            carStyles.getPathList().addAll(carImage(response));
                                                            carStyles.setPath(getPath(response));
                                                            realm.copyToRealm(carMake);
                                                            realm.commitTransaction();
                                                            Log.e("Result = ", "Updated");
                                                            if (serverResult != null) {
                                                                serverResult.onTaskSucceeded(0, null);
                                                            }
                                                            break;
                                                        }
                                                    }
                                                    break;
                                                }
                                            }
                                            break;
                                        }
                                    }
                                }
                            }
                        }, new Response.ErrorListener() {

                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                });
        if (Utils.isNetworkAvailable(CarInfo.getAppContext()))
            requestQueue.add(contentDetailsRequest);

    }

    private String getPath(ArrayList<Image> response) {
        String path = "";
        for (int a = 0; a < response.size(); a++) {
            Image images = response.get(a);
            if (images.subType.equalsIgnoreCase("exterior")) {
                for (int i = 0; i < images.photoSrcs.size(); i++) {
                    path = String.valueOf(images.photoSrcs.get(i));
                    if (path.contains("_500")) {
                        Log.e("String = ", Constant.MEDIA_HOST_URL + path);
                        path = Constant.MEDIA_HOST_URL + path;
                        break;
                    } else if (path.contains("_400")) {
                        Log.e("String = ", Constant.MEDIA_HOST_URL + path);
                        path = Constant.MEDIA_HOST_URL + path;
                        break;
                    }
                }
                break;
            }
        }
        return path;
    }

    public CarMake getModelImages(String name) {
        realm = Realm.getInstance(realmConfiguration);
        RealmResults<CarMake> data = realm.where(CarMake.class).equalTo("name", name).findAll();
        return data.size() > 0 ? data.get(0) : null;
    }

    public ArrayList<CarYear> getYearListData(String name, String model) {
        CarMake carMake = getModelImages(name);
        ArrayList<CarYear> years = new ArrayList<>();
        for (int i = 0; i < carMake.getModels().size(); i++) {
            CarModel carModel = carMake.getModels().get(i);
            if (carModel.getName().equalsIgnoreCase(model)) {
                years.addAll(carModel.getYears());
                break;
            }
        }
        return years;
    }

    public ArrayList<CarStyles> getYearListData(String name, String model, int year) {
        CarMake carMake = getModelImages(name);
        ArrayList<CarStyles> years = new ArrayList<>();
        for (int i = 0; i < carMake.getModels().size(); i++) {
            CarModel carModel = carMake.getModels().get(i);
            if (carModel.getName().equalsIgnoreCase(model)) {
                for (int j = 0; j < carModel.getYears().size(); j++) {
                    CarYear carYear = carModel.getYears().get(j);
                    if (carYear.getYear() == year) {
                        years.addAll(carYear.getStyles());
                        downLoadImage(years, name, model, year);
                        break;
                    }
                }
                break;
            }
        }
        return years;
    }

    private void downLoadImage(ArrayList<CarStyles> carStyles, String name, String model, int year) {
        for (CarStyles carStylesData : carStyles) {
            if (carStylesData.getPath() == null) {
                getCarImage(carStylesData.getId() + "", name, model, year);
            }
        }
    }

    public RealmResults<CarMake> getMakeImageData() {
        realm = Realm.getInstance(realmConfiguration);
        return realm.where(CarMake.class).findAll();
    }

    private void loadMakeData(int id) {
        try {
            Resources res = activity.getResources();
            InputStream inputStream = res.openRawResource(id);

            byte[] b = new byte[inputStream.available()];
            inputStream.read(b);
            Car response = mGson.fromJson(new String(b), Car.class);
            if (response != null) {
                Log.e("Result = ", response.getMakes().size() + "");
                realm = Realm.getInstance(realmConfiguration);
                realm.beginTransaction();
                RealmList<CarMake> carMakeList = response.getMakes();
                for (int i = 0; i < carMakeList.size(); i++) {
                    CarMake carMake = carMakeList.get(i);
                    realm.copyToRealm(carMake);
                }
                realm.commitTransaction();
            }
        } catch (Exception e) {
            Log.e("result", "result" + e.getMessage());
        }
    }

    public void getAllMake() {
        Log.e("result", "result");
        new LoadJsonData().execute();
    }


    private class LoadJsonData extends AsyncTask<String, String, String> {

        @Override
        protected String doInBackground(String... dat) {
            loadMakeData(R.raw.make_first);
            loadMakeData(R.raw.make_second);
            loadMakeData(R.raw.make_third);
            loadMakeData(R.raw.make_four);
            loadMakeData(R.raw.make_five);
            return null;
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            if (serverResult != null) {
                serverResult.onTaskSucceeded(0, null);
            }
        }
    }

    public void closeDB() {
        //  realm.close();
    }
}
