package com.carinfo.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import com.carinfo.R;
import com.carinfo.adapter.StyleList;
import com.carinfo.realm.CarStyles;
import com.carinfo.utils.ObjectHandling;
import com.carinfo.utils.RecyclerItemClickListener;

import java.util.ArrayList;


public class StyleActivity extends BaseActivity {

    private RecyclerView recyclerView;
    private ArrayList<CarStyles> mModelListData = new ArrayList<>();
    private String makeName, modelName;
    private int year;
    private StyleList mStyleList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        recyclerView = (RecyclerView) findViewById(R.id.home_list);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        makeName = ObjectHandling.getInstance().getMakeName();
        modelName = ObjectHandling.getInstance().getModelName();
        year = ObjectHandling.getInstance().getYear();
       /* makeName = getIntent().getExtras().getString(Constant.BUNDLE_MAKE);
        modelName = getIntent().getExtras().getString(Constant.BUNDLE_MODEL);
        year = getIntent().getExtras().getInt(Constant.BUNDLE_YEAR);
       */
        Log.e("make & model & year", makeName + " & " + modelName + " & " + year);
        setToolBarTitle(year + "");
        setBackButtonEnabled(true);
        mModelListData.addAll(mApiHelper.getYearListData(makeName, modelName, year));
        mStyleList = new StyleList(mModelListData);
        recyclerView.setAdapter(mStyleList);
        recyclerView.addOnItemTouchListener(
                new RecyclerItemClickListener(StyleActivity.this, new RecyclerItemClickListener.OnItemClickListener() {
                    @Override
                    public void onItemClick(View view, int position) {
                        CarStyles carStyles = mModelListData.get(position);
                        ObjectHandling.getInstance().setStyleId(carStyles.getId());
                        ObjectHandling.getInstance().setStyleName(carStyles.getName());
                        ObjectHandling.getInstance().setAllPathList(carStyles.getPathList());
                        Intent carDetail = new Intent(StyleActivity.this, CarDetailsActivity.class);
                        startActivity(carDetail);
                    }
                })
        );
    }

    @Override
    public void onTaskSucceeded(int taskID, Object resp) {
        mStyleList.notifyDataSetChanged();
    }
}
