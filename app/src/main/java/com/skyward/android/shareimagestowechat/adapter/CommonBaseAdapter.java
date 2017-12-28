package com.skyward.android.shareimagestowechat.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.List;

/**
 * Created by skyward on 2016/3/26.
 *
 */
public abstract class CommonBaseAdapter<T> extends BaseAdapter {
    protected final Context mContext;
    protected final List<T> mData;
    protected final LayoutInflater inflater;

    public CommonBaseAdapter(Context context, List<T> Data) {
        this.mContext = context;
        inflater = LayoutInflater.from(context);
        this.mData = Data;
    }

    @Override
    public int getCount() {
        return mData.size();
    }

    @Override
    public Object getItem(int i) {
        return mData.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public abstract View getView(int i, View view, ViewGroup viewGroup);
}
