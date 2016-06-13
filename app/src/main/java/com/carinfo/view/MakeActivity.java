package com.carinfo.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.carinfo.R;
import com.carinfo.adapter.MakeList;
import com.carinfo.realm.CarMake;
import com.carinfo.utils.Constant;
import com.carinfo.utils.ObjectHandling;
import com.carinfo.utils.RecyclerItemClickListener;

import io.realm.RealmResults;

public class MakeActivity extends BaseActivity {

    private RecyclerView recyclerView;
    private MakeList mMakeListAdapter;
    private RealmResults<CarMake> mMakeImageLists;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        setBackButtonEnabled(false);
        recyclerView = (RecyclerView) findViewById(R.id.home_list);
        mMakeImageLists = mApiHelper.getMakeImageData();
        mMakeListAdapter = new MakeList(mMakeImageLists);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mMakeListAdapter);
        recyclerView.addOnItemTouchListener(
                new RecyclerItemClickListener(MakeActivity.this, new RecyclerItemClickListener.OnItemClickListener() {
                    @Override
                    public void onItemClick(View view, int position) {
                        ObjectHandling.getInstance().setMakeName(mMakeImageLists.get(position).getName());
                        Intent intent = new Intent(MakeActivity.this, ModelActivity.class);
                        intent.putExtra(Constant.BUNDLE_MAKE, mMakeImageLists.get(position).getName());
                        startActivity(intent);
                    }
                })
        );
    }

    @Override
    public void onTaskSucceeded(int taskID, Object resp) {
    }
}
