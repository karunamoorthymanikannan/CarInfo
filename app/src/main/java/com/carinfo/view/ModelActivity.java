package com.carinfo.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.carinfo.R;
import com.carinfo.adapter.ModelList;
import com.carinfo.realm.CarMake;
import com.carinfo.realm.CarModel;
import com.carinfo.utils.Constant;
import com.carinfo.utils.ObjectHandling;
import com.carinfo.utils.RecyclerItemClickListener;

import java.util.ArrayList;


public class ModelActivity extends BaseActivity {

    private RecyclerView recyclerView;
    private CarMake mCarMake;
    private ArrayList<CarModel> mModelListData = new ArrayList<>();
    private String makeName;
    private ModelList mModelList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        recyclerView = (RecyclerView) findViewById(R.id.home_list);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
      //  makeName = getIntent().getExtras().getString(Constant.BUNDLE_MAKE);
        makeName = ObjectHandling.getInstance().getMakeName();
        setToolBarTitle(makeName);
        setBackButtonEnabled(true);
        mCarMake = mApiHelper.getModelImages(makeName);
        if (mCarMake == null)
            return;
        mModelListData.addAll(mCarMake.getModels());
        mModelList = new ModelList(mModelListData);
        recyclerView.setAdapter(mModelList);
        recyclerView.addOnItemTouchListener(
                new RecyclerItemClickListener(ModelActivity.this, new RecyclerItemClickListener.OnItemClickListener() {
                    @Override
                    public void onItemClick(View view, int position) {
                        ObjectHandling.getInstance().setModelName(mModelListData.get(position).getName());
                        Intent intent = new Intent(ModelActivity.this, YearActivity.class);
                        intent.putExtra(Constant.BUNDLE_MODEL, mModelListData.get(position).getName());
                        intent.putExtra(Constant.BUNDLE_MAKE, makeName);
                        startActivity(intent);
                    }
                })
        );
    }

    @Override
    public void onTaskSucceeded(int taskID, Object resp) {

    }
}
