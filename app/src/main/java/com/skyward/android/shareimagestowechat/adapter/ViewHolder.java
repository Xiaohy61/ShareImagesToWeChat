package com.skyward.android.shareimagestowechat.adapter;

import android.content.Context;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by skyward on 2016/3/21.
 *
 */
public class ViewHolder {
    private final SparseArray<View> mViews;
    private int mPosition;
    private final View mConcertView;
    public ViewHolder(Context context, ViewGroup parent , int layoutId, int position){
        this.mPosition = position;
        this.mViews    = new SparseArray<>();
        mConcertView = LayoutInflater.from(context).inflate(layoutId,parent,false);
        mConcertView.setTag(this);
    }
    public static ViewHolder get(Context context, View convertView, ViewGroup parent, int layoutId, int position){
        if(convertView == null){
            return new ViewHolder(context,parent,layoutId,position);
        }else {
            ViewHolder holder = (ViewHolder) convertView.getTag();
            holder.mPosition = position;
            return holder;
        }
    }

    /*
    * 通过viewid获取控件
    * */
    public <T extends View> T getView(int viewId){
        View view = mViews.get(viewId);
        if(view == null){
            view = mConcertView.findViewById(viewId);
            mViews.put(viewId,view);
        }
        return (T) view;
    }


    public View getmConcertView() {
        return mConcertView;
    }
}
