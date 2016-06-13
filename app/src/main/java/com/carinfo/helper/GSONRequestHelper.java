package com.carinfo.helper;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.NetworkResponse;
import com.android.volley.ParseError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.HttpHeaderParser;
import com.android.volley.toolbox.JsonRequest;
import com.carinfo.realm.RealmString;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;

import org.json.JSONObject;

import java.lang.reflect.Type;

import io.realm.RealmList;


public class GSONRequestHelper<T> extends JsonRequest<T> {
    private final Type mType;
    private final Response.Listener<T> listener;
    private final String TAG = "VOLLEY";
    private final String mRequestURL;
    private String mRequestMethod = "GET";
    private GsonBuilder mBuilder=  new GsonBuilder().registerTypeAdapter(new TypeToken<RealmList<RealmString>>(){}.getType(),
            RealmStringListTypeAdapter.INSTANCE);
    private final Gson mGson = mBuilder.create();

    //Set the default timeout of 1 minute
    private int MY_SOCKET_TIMEOUT_MS = 60000;

    public GSONRequestHelper(String requestURL, Type type,
                             Response.Listener<T> listener, Response.ErrorListener errorListener) {
        this(Request.Method.GET, requestURL, type, null, listener, errorListener);
    }

    public GSONRequestHelper(int requestMethod, String requestURL, Type type,
                             JSONObject jsonRequest,
                             Response.Listener<T> listener, Response.ErrorListener errorListener) {
        super(requestMethod, requestURL, (jsonRequest == null) ? null : jsonRequest.toString(), listener,
                errorListener);
        this.mRequestURL = requestURL;
        this.mType = type;
        this.listener = listener;
        setRequestMethod(requestMethod);
        setRetryPolicy(new DefaultRetryPolicy(
                MY_SOCKET_TIMEOUT_MS,
                DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
                DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
    }

    private void setRequestMethod(int requestType) {
        switch (requestType) {
            case Request.Method.POST:
                mRequestMethod = "POST";
                break;
            case Request.Method.DELETE:
                mRequestMethod = "DELETE";
                break;
            case Method.PUT:
                mRequestMethod = "PUT";
                break;
            default:
                mRequestMethod = "GET";
                break;
        }
    }

    @Override
    protected Response<T> parseNetworkResponse(NetworkResponse response) {
        try {
            return (Response<T>) Response.success(
                    this.mGson.fromJson(new String(response.data), this.mType),
                    HttpHeaderParser.parseCacheHeaders(response));
        } catch (JsonSyntaxException e) {
            return Response.error(new ParseError(e));
        }
    }

    @Override
    protected void deliverResponse(T response) {
        listener.onResponse(response);
    }

    @Override
    public String getBodyContentType() {
        return "application/json; charset=utf-8";
    }

    @Override
    protected VolleyError parseNetworkError(VolleyError volleyError) {
        if (volleyError.networkResponse != null && volleyError.networkResponse.data != null) {
            VolleyError error = new VolleyError(volleyError.networkResponse);
            volleyError = error;
        }
        return volleyError;
    }

}
