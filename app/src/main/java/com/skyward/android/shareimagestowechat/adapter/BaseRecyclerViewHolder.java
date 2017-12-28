package com.skyward.android.shareimagestowechat.adapter;

import android.support.annotation.DrawableRes;
import android.support.v7.widget.RecyclerView;
import android.util.SparseArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by skyward on 2017/3/30.
 * email:
 */

public class BaseRecyclerViewHolder extends RecyclerView.ViewHolder {
    private SparseArray<View> mViews;

    public BaseRecyclerViewHolder(View itemView) {
        super(itemView);
        mViews = new SparseArray<>();
    }

    public <T extends View> T findViewById(int viewId) {
        View view = mViews.get(viewId);
        if (view == null) {
            view = itemView.findViewById(viewId);
            mViews.put(viewId, view);
        }
        return (T) view;
    }

    /**
     * 设置文本资源
     *
     * @param viewId view id
     * @param s      字符
     */

    public TextView setText(int viewId, CharSequence s) {
        TextView view = findViewById(viewId);
        view.setText(s);
        return view;
    }

    /**
     * 设置图片资源
     *
     * @param viewId     view id
     * @param imageResId 图片资源id
     */

    public ImageView setImageResource(int viewId, @DrawableRes int imageResId) {
        ImageView view = findViewById(viewId);
        view.setImageResource(imageResId);
        return view;
    }



}
