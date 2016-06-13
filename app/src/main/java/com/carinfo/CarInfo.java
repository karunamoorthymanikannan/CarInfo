package com.carinfo;

import android.app.Application;
import android.content.Context;

/**
 * Created by  on 9/3/15.
 */
public class CarInfo extends Application {
    private static Context sContext;
    private static CarInfo sInstance;

    public void onCreate() {
        super.onCreate();
        sInstance = this;
        sContext = getApplicationContext();
    }

    public static Context getAppContext() {
        return CarInfo.sContext;
    }

    public static synchronized CarInfo getInstance() {
        return sInstance;
    }
}
