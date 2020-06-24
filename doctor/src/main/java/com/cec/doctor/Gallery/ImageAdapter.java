package com.cec.doctor.Gallery;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

import com.cec.doctor.R;

public class ImageAdapter extends BaseAdapter {
    private Context mContext;

    // Keep all Images in array
    Integer[] mThumbIds;
    // Constructor
    ImageAdapter(Context c) {
        mContext = c;
        mThumbIds = new Integer[]{
                R.drawable.pic_1, R.drawable.pic_2,
                R.drawable.pic_3, R.drawable.pic_4,
                R.drawable.pic_5, R.drawable.pic_6,
                R.drawable.pic_7, R.drawable.pic_8,
                R.drawable.pic_9, R.drawable.pic_10,
                R.drawable.pic_11, R.drawable.pic_12,
                R.drawable.pic_13, R.drawable.pic_14,
                R.drawable.pic_15
        };
    }

    @Override
    public int getCount() {
        return mThumbIds.length;
    }

    @Override
    public Object getItem(int position) {
        return mThumbIds[position];
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position,View convertView,ViewGroup parent) {
        ImageView imageView;
        if (convertView ==null) {
            imageView = new ImageView(mContext);
            imageView.setImageResource(mThumbIds[position]);
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            imageView.setPadding(8,8,8,8);
            imageView.setLayoutParams(new GridView.LayoutParams(120,120));


        } else {
            imageView = (ImageView) convertView;
        }
        imageView.setImageResource(mThumbIds[position]);
        return imageView;
    }
}


