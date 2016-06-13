package com.carinfo.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.NetworkImageView;
import com.carinfo.R;
import com.carinfo.helper.VolleyHelper;
import com.carinfo.realm.CarModel;

import java.util.ArrayList;

/**
 * Created by karunamoorthy on 31/5/16.
 */

public class ModelList extends RecyclerView.Adapter {
    private ArrayList<CarModel> mHomeListData;
    private ImageLoader mImageLoader;

    public ModelList(ArrayList<CarModel> homeListData) {
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
        CarModel model = mHomeListData.get(position);
        if (model != null) {
            makeListHolder.makeName.setText(model.getName());
            makeListHolder.makeImage.setDefaultImageResId(R.drawable.image_loading);
            makeListHolder.makeImage.setErrorImageResId(R.drawable.image_loading);
            makeListHolder.makeImage.setImageUrl(model.getPath(), mImageLoader);
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
