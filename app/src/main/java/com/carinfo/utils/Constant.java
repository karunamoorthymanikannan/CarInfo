package com.carinfo.utils;

/**
 * Created by karunamoorthy on 31/5/16.
 */

public class Constant {
    //https://api.edmunds.com/api/vehicle/v2/honda/models?view=full&fmt=json&api_key=2rmvycu3kw4yzbcq5r4pnn8x
    public static final String APP_KEY = "2rmvycu3kw4yzbcq5r4pnn8x";
    public static final String API_HOST_URL = "http://api.edmunds.com/api/vehicle/v2/";
    //https://api.edmunds.com/api/vehicle/v2/honda/accord/years?view=full&fmt=json&api_key=2rmvycu3kw4yzbcq5r4pnn8x
    //https://api.edmunds.com/v1/api/vehiclephoto/service/findphotosbystyleid?styleId=8769&fmt=json&api_key=2rmvycu3kw4yzbcq5r4pnn8x
    public static final String API_HOST_URL_SECURE = "https://api.edmunds.com/api/vehicle/v2/";
    public static final String MEDIA_HOST_URL = "http://media.ed.edmunds-media.com";
    public static final String GET_ALL_MAKE_DETAILS = API_HOST_URL + "makes?view=full&fmt=json&api_key=" + APP_KEY;
    public static final String FIND_PHOTOS_BY_STYLE_ID = API_HOST_URL + "makes?view=full&fmt=json&api_key=" + APP_KEY;
    private static String getStyleID = API_HOST_URL_SECURE + "/%s/%s/years?view=full&fmt=json&api_key=" + APP_KEY;
    private static String getModel = API_HOST_URL_SECURE + "/%s/models?view=full&fmt=json&api_key=" + APP_KEY;
    private static String getImage = "https://api.edmunds.com/v1/api/vehiclephoto/service/findphotosbystyleid?styleId=%s&fmt=json&api_key=" + APP_KEY;
//    https://api.edmunds.com/api/vehicle/v2/styles/200487199?view=full&fmt=json&api_key=2rmvycu3kw4yzbcq5r4pnn8x
    private static String getCarDetail=API_HOST_URL_SECURE+"styles/%s?view=full&fmt=json&api_key="+APP_KEY;
    private static String getCarRatings=API_HOST_URL_SECURE+"styles/%s/grade?fmt=json&api_key="+APP_KEY;
    public static String getStyleIDUrl(String makeNiceName, String modelNiceName) {
        return String.format(getStyleID, makeNiceName, modelNiceName);
    }
    public static String getCarRatings(String styleID) {
        return String.format(getCarRatings, styleID);
    }public static String getCarDetail(String styleID) {
        return String.format(getCarDetail, styleID);
    }
    public static String getAllModels(String makeNiceName) {
        return String.format(getModel, makeNiceName);
    }

    public static String getImageUrl(String styleId) {
        return String.format(getImage, styleId);
    }

    public static final String BUNDLE_MAKE = "make";
    public static final String BUNDLE_MODEL = "model";
    public static final String BUNDLE_YEAR = "year";
}
