package com.carinfo.helper;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.Volley;
import com.carinfo.CarInfo;

public class VolleyHelper {
    private static VolleyHelper sInstance;
    private RequestQueue mRequestQueue;
    private ImageLoader mImageLoader;

    private VolleyHelper() {
        mRequestQueue = getRequestQueue();
        mImageLoader = new ImageLoader(mRequestQueue, new BitmapLruCache());
        mImageLoader.setBatchedResponseDelay(0);
    }

    public static synchronized VolleyHelper getInstance() {
        if (sInstance == null) {
            sInstance = new VolleyHelper();
        }

        return sInstance;
    }

    public RequestQueue getRequestQueue() {
        if (mRequestQueue == null) {
            mRequestQueue = Volley.newRequestQueue(CarInfo.getAppContext());
        }

        return mRequestQueue;
    }

    public ImageLoader getImageLoader() {
        return mImageLoader;
    }
}
