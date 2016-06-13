package com.carinfo.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.TextView;

import com.carinfo.R;
import com.carinfo.helper.APIHelper;
import com.carinfo.utils.ServerResult;

/**
 * Created by karunamoorthy on 8/6/16.
 */

public class BaseActivity extends AppCompatActivity implements ServerResult {

    protected Toolbar mToolbar;
    protected APIHelper mApiHelper;
    private TextView mTitle;

    @Override
    public void setContentView(int layoutResID) {
        super.setContentView(layoutResID);
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        if (mToolbar != null) {
            setSupportActionBar(mToolbar);
            mTitle = (TextView) mToolbar.findViewById(R.id.toolbar_title);
            setTitle("");
        }
    }

    protected void setToolBarTitle(String title) {
        if (title != null && mTitle != null) {
            mTitle.setText(title);
        }
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mApiHelper = new APIHelper(this, this);
    }

    protected void setBackButtonEnabled(boolean enabled) {
        getSupportActionBar().setDisplayHomeAsUpEnabled(enabled);
        getSupportActionBar().setHomeButtonEnabled(enabled);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.back);
    }

    @Override
    public void onTaskSucceeded(int taskID, Object resp) {

    }

    @Override
    public void onTaskFailed(int taskID, Object resp) {

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home: {
                finish();
                return true;
            }
            default: {
                return super.onOptionsItemSelected(item);
            }
        }
    }
}
