package com.carinfo.adapter;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.NetworkImageView;
import com.carinfo.R;
import com.carinfo.helper.VolleyHelper;
import com.carinfo.realm.CarStyles;

import java.util.ArrayList;

/**
 * Created by karunamoorthy on 31/5/16.
 */

public class StyleList extends RecyclerView.Adapter {
    private ArrayList<CarStyles> mHomeListData;
    private ImageLoader mImageLoader;

    public StyleList(ArrayList<CarStyles> homeListData) {
        mHomeListData = homeListData;
        mImageLoader = VolleyHelper.getInstance().getImageLoader();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.view_make_all_list, parent, false);

        return new MakeListHolder(itemView);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        MakeListHolder makeListHolder = (MakeListHolder) holder;
        CarStyles make = mHomeListData.get(position);
        if (make != null) {
            makeListHolder.makeName.setText(make.getName() + "");
            makeListHolder.makeImage.setDefaultImageResId(R.drawable.image_loading);
            makeListHolder.makeImage.setErrorImageResId(R.drawable.image_loading);
            makeListHolder.makeImage.setImageUrl(make.getPath(), mImageLoader);
            Log.e("Path = ", make.getPath() + " =  ");
        }
    }

    @Override
    public int getItemCount() {
        return mHomeListData.size();
    }

    public class MakeListHolder extends RecyclerView.ViewHolder {
        public TextView makeName;
        public NetworkImageView makeImage;

        public MakeListHolder(View view) {
            super(view);
            makeName = (TextView) view.findViewById(R.id.make_name);
            makeImage = (NetworkImageView) view.findViewById(R.id.make_image);
        }
    }

}
