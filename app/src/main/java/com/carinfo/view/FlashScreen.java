package com.carinfo.view;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.carinfo.R;
import com.carinfo.helper.APIHelper;
import com.carinfo.realm.CarMake;
import com.carinfo.utils.ServerResult;

import io.realm.RealmResults;

public class FlashScreen extends Activity implements ServerResult {

    private APIHelper mApiHelper;
    private static int SPLASH_TIME_OUT = 3000;
    private ProgressDialog mProgressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flash_screen);
        mApiHelper = new APIHelper(this, this);
        RealmResults<CarMake> homes = mApiHelper.getMakeData();
        if (homes.size() > 0) {
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    startActivity();
                }
            }, SPLASH_TIME_OUT);
        } else {
            mApiHelper.getAllMake();
            mProgressDialog = new ProgressDialog(FlashScreen.this);
            mProgressDialog.setMessage(getString(R.string.loading));
            mProgressDialog.show();
        }
    }

    @Override
    public void onTaskSucceeded(int taskID, Object resp) {
        if (mProgressDialog != null && mProgressDialog.isShowing()) {
            mProgressDialog.dismiss();
        }
        startActivity();
    }

    @Override
    public void onTaskFailed(int taskID, Object resp) {

    }

    private void startActivity() {

        Intent start = new Intent(FlashScreen.this, MakeActivity.class);
        startActivity(start);
        finish();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mApiHelper.closeDB();
    }
}
