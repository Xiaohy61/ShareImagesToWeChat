package com.skyward.android.shareimagestowechat.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;
import com.skyward.android.shareimagestowechat.App;
import com.skyward.android.shareimagestowechat.R;
import com.skyward.android.shareimagestowechat.customview.SquareImageView;

import java.util.List;

/**
 * @author: skyward
 * date: 2017/11/17 0017
 * desc:
 */
public class FriendImageAdapter extends CommonBaseAdapter<String> {

    public static RequestOptions optionsFitCenter;

    public FriendImageAdapter(Context context, List<String> Data) {
        super(context, Data);
        optionsFitCenter = new RequestOptions()
                .priority(Priority.HIGH)
                .diskCacheStrategy(DiskCacheStrategy.ALL);
    }


    @Override
    public View getView(final int i, View view, ViewGroup viewGroup) {
        ViewHolder holder = ViewHolder.get(mContext, view,viewGroup, R.layout.friend_image_item,i);

        ImageView imageView = holder.getView(R.id.image);
        SquareImageView image_list = holder.getView(R.id.image_list);

        if(mData.size() > 1){
            image_list.setVisibility(View.VISIBLE);
            imageView.setVisibility(View.GONE);
            Glide.with(App.getContext())
                    .load(mData.get(i))
                    .apply(optionsFitCenter)
                    .into(image_list);

        }else {
            image_list.setVisibility(View.GONE);
            imageView.setVisibility(View.VISIBLE);
            Glide.with(App.getContext())
                    .load(mData.get(i))
                    .apply(optionsFitCenter)
                    .into(imageView);
        }



        holder.getmConcertView().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent intent  = new Intent(mContext, FriendPhotoPagerActivity.class);
//                intent.putExtra("image", (Serializable) mData);
//                intent.putExtra("position",i);
//                mContext.startActivity(intent);
            }
        });


        return holder.getmConcertView();
    }
}
