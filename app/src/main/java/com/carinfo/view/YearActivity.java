package com.carinfo.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.carinfo.R;
import com.carinfo.adapter.YearList;
import com.carinfo.realm.CarYear;
import com.carinfo.utils.Constant;
import com.carinfo.utils.ObjectHandling;
import com.carinfo.utils.RecyclerItemClickListener;

import java.util.ArrayList;


public class YearActivity extends BaseActivity {

    private String makeName, modelName;
    private RecyclerView recyclerView;
    private ArrayList<CarYear> mModelListData = new ArrayList<>();
    private YearList mModelList;

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
     /*makeName = getIntent().getExtras().getString(Constant.BUNDLE_MAKE);
        modelName = getIntent().getExtras().getString(Constant.BUNDLE_MODEL);
     */
        setToolBarTitle(modelName);
        setBackButtonEnabled(true);
        mModelListData.addAll(mApiHelper.getYearListData(makeName, modelName));
        mModelList = new YearList(mModelListData);
        recyclerView.setAdapter(mModelList);
        recyclerView.addOnItemTouchListener(
                new RecyclerItemClickListener(YearActivity.this, new RecyclerItemClickListener.OnItemClickListener() {
                    @Override
                    public void onItemClick(View view, int position) {
                        ObjectHandling.getInstance().setYear(mModelListData.get(position).getYear());
                        Intent intent = new Intent(YearActivity.this, StyleActivity.class);
                        intent.putExtra(Constant.BUNDLE_MODEL, modelName);
                        intent.putExtra(Constant.BUNDLE_MAKE, makeName);
                        intent.putExtra(Constant.BUNDLE_YEAR, mModelListData.get(position).getYear());
                        startActivity(intent);
                    }
                })
        );
    }

    @Override
    public void onTaskSucceeded(int taskID, Object resp) {

    }
}
