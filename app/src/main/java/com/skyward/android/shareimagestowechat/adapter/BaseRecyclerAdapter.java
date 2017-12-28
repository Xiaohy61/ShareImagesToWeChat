package com.skyward.android.shareimagestowechat.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by skyward on 2017/3/30.
 * email:
 */

public abstract class BaseRecyclerAdapter<D,VH extends RecyclerView.ViewHolder> extends RecyclerView.Adapter<VH> implements View.OnClickListener, View.OnLongClickListener{

    /**
     * 数据源
     */
    private List<D> data;

    /**
     * 布局资源id
     */
    private int layoutResId;

    /**
     * Item点击事件
     */
    private onItemClickListener clickListener;

    /**
     * Item长按事件
     */
    private onItemLongClickListener longListener;

    public BaseRecyclerAdapter(int layoutResId,List<D> data){
        this.data = data == null ? new ArrayList<D>() :data;
        if(layoutResId !=0 ){
            this.layoutResId = layoutResId;
        }else {
            throw new NullPointerException("请设置Item资源id");
        }
    }

    @Override
    public VH onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(layoutResId,parent,false);
        return (VH) new BaseRecyclerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(VH holder, int position) {


        //设置Item的点击事件
        holder.itemView.setOnClickListener(this);
        //设置Item的长按事件
        holder.itemView.setOnLongClickListener(this);
        holder.itemView.setTag(position);
        bindTheData(holder, data.get(position), position);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    /**
     * 清除数据
     */
    public void clearData() {
        if (data != null && data.size() > 0) {
            data.clear();
        }
        notifyDataSetChanged();
    }

    /**
     * 绑定数据
     *
     * @param holder 视图管理者
     * @param data   数据源
     */
    protected abstract void bindTheData(VH holder, D data, int position);

    @Override
    public void onClick(View v) {
        //点击回调
        if (clickListener != null) {
            clickListener.onItemClick((Integer) v.getTag(), v);
        }
    }

    @Override
    public boolean onLongClick(View v) {
        //长按回调
        return longListener != null && longListener.onItemLonClick((Integer) v.getTag(), v);
    }

    /**
     * 设置点击监听
     *
     * @param clickListener 监听器
     */
    public void setClickListener(onItemClickListener clickListener) {
        this.clickListener = clickListener;
    }

    /**
     * 设置长按监听
     *
     * @param longListener 监听器
     */
    public void setLongListener(onItemLongClickListener longListener) {
        this.longListener = longListener;
    }

    public interface onItemClickListener {
        void onItemClick(int position, View v);
    }

    public   interface onItemLongClickListener {
        boolean onItemLonClick(int position, View v);
    }

}
