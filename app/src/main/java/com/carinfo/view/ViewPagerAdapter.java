package com.carinfo.view;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.NetworkImageView;
import com.carinfo.R;
import com.carinfo.helper.VolleyHelper;
import com.carinfo.realm.CustomString;

import io.realm.RealmList;

/**
 * Created by karunamoorthy on 9/6/16.
 */
public class ViewPagerAdapter extends PagerAdapter {

    private Context mContext;
    private RealmList<CustomString> mListData;
    private ImageLoader mImageLoader;

    public ViewPagerAdapter(Context mContext, RealmList<CustomString> listData) {
        this.mContext = mContext;
        mListData = listData;
        mImageLoader = VolleyHelper.getInstance().getImageLoader();
    }

    @Override
    public int getCount() {
        return mListData.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == ((LinearLayout) object);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        View itemView = LayoutInflater.from(mContext).inflate(R.layout.pager_item, container, false);
        NetworkImageView networkImageView = (NetworkImageView) itemView.findViewById(R.id.img_pager_item);
        CustomString customString = mListData.get(position);
        if (customString != null) {
            networkImageView.setDefaultImageResId(R.drawable.image_loading);
            networkImageView.setErrorImageResId(R.drawable.image_loading);
            networkImageView.setImageUrl(customString.getPath(), mImageLoader);
        }
        container.addView(itemView);
        return itemView;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((LinearLayout) object);
    }
}
