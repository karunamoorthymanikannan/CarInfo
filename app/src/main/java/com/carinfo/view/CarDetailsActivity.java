package com.carinfo.view;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.carinfo.R;
import com.carinfo.realm.CarDetails;
import com.carinfo.realm.CustomString;
import com.carinfo.realm.RealmString;
import com.carinfo.utils.ObjectHandling;
import com.carinfo.widget.CarInfoTextView;

import io.realm.RealmList;
import io.realm.RealmResults;

public class CarDetailsActivity extends BaseActivity implements ViewPager.OnPageChangeListener, View.OnClickListener {
    private ViewPager mPathPager;
    private LinearLayout mPagerIndicator;
    private ViewPagerAdapter mAdapter;
    private RealmList<CustomString> mListData = new RealmList<>();
    private ImageView mDotImages[];
    private long mStyleId;
    private int mPosition = 0;
    private String mStyleName;
    private ImageView mLeftIcon, mRightIcon;
    private CarDetails mCarDetails;
    private CarInfoTextView mStyle, mReleseYear, mNoOfDoor, mNoOfWheel, mCarStates, mNoOfSpeed, mTransmison;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_car_details);
        setBackButtonEnabled(true);
        mStyleName = ObjectHandling.getInstance().getStyleName();
        setToolBarTitle(mStyleName);
        initViews();
        mListData.addAll(ObjectHandling.getInstance().getAllPathList());
        mAdapter = new ViewPagerAdapter(CarDetailsActivity.this, mListData);
        mPathPager.setAdapter(mAdapter);
        mPathPager.setCurrentItem(0);
        mPathPager.setOnPageChangeListener(this);
        mStyleId = ObjectHandling.getInstance().getStyleId();
        RealmResults<CarDetails> carDetailses = mApiHelper.getStyleData(mStyleId + "");
        if (carDetailses.size() == 0) {
            mApiHelper.getCarDetail(mStyleId + "");
        } else {
            mCarDetails = carDetailses.first();
            setValues();
        }
        mDotImages = new ImageView[mListData.size()];
        for (int i = 0; i < mListData.size(); i++) {
            mDotImages[i] = new ImageView(this);
            mDotImages[i].setImageDrawable(getResources().getDrawable(R.drawable.non_selected_item_dot));
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
            );
            params.setMargins(8, 0, 8, 0);
            mPagerIndicator.addView(mDotImages[i], params);
        }
        mDotImages[0].setImageDrawable(getResources().getDrawable(R.drawable.selecteditem_dot));
        mLeftIcon.setOnClickListener(this);
        mRightIcon.setOnClickListener(this);
    }

    private void setValues() {
        String data = "";
        for (RealmString customString : mCarDetails.getStates()) {
            data = data + customString.getStringValue();
        }
        mCarStates.setText(data);
        mReleseYear.setText(mCarDetails.getYear().getYear() + "");
        mNoOfDoor.setText(mCarDetails.getNumOfDoors());
        mNoOfWheel.setText(mCarDetails.getDrivenWheels());
        mStyle.setText(mCarDetails.getSubmodel().getBody());
        mNoOfSpeed.setText(mCarDetails.getTransmission().getNumberOfSpeeds());
        mTransmison.setText(mCarDetails.getTransmission().getTransmissionType());
    }

    private void initViews() {
        mStyle = (CarInfoTextView) findViewById(R.id.style);
        mReleseYear = (CarInfoTextView) findViewById(R.id.year);
        mNoOfDoor = (CarInfoTextView) findViewById(R.id.no_of_doors);
        mNoOfSpeed = (CarInfoTextView) findViewById(R.id.no_of_speed);
        mTransmison = (CarInfoTextView) findViewById(R.id.trassmisson_type);
        mNoOfWheel = (CarInfoTextView) findViewById(R.id.wheel_size);
        mCarStates = (CarInfoTextView) findViewById(R.id.states);

        mPathPager = (ViewPager) findViewById(R.id.pager_introduction);
        mPagerIndicator = (LinearLayout) findViewById(R.id.viewPagerCountDots);
        mLeftIcon = (ImageView) findViewById(R.id.left_icon);
        mRightIcon = (ImageView) findViewById(R.id.right_icon);
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        mPosition = position;
        updateArrow();
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

    private void updateArrow() {
        if (mPosition > 0) {
            mLeftIcon.setVisibility(View.VISIBLE);
        } else {
            mLeftIcon.setVisibility(View.GONE);
        }
        if (mPosition == mListData.size() - 1) {
            mRightIcon.setVisibility(View.GONE);
        } else {
            mRightIcon.setVisibility(View.VISIBLE);
        }
        for (int i = 0; i < mDotImages.length; i++) {
            if (mPosition == i) {
                mDotImages[i].setImageDrawable(getResources().getDrawable(R.drawable.selecteditem_dot));
            } else {
                mDotImages[i].setImageDrawable(getResources().getDrawable(R.drawable.non_selected_item_dot));
            }
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.left_icon:
                mPosition = mPosition - 1;
                mPathPager.setCurrentItem(mPosition, true);
                break;
            case R.id.right_icon:
                mPosition = mPosition + 1;
                mPathPager.setCurrentItem(mPosition, true);
                break;

        }
    }
}
