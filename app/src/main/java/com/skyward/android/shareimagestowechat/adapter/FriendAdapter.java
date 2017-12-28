package com.skyward.android.shareimagestowechat.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.SimpleTarget;
import com.bumptech.glide.request.transition.Transition;
import com.skyward.android.shareimagestowechat.App;
import com.skyward.android.shareimagestowechat.MainActivity;
import com.skyward.android.shareimagestowechat.R;
import com.skyward.android.shareimagestowechat.bean.FriendBean;
import com.skyward.android.shareimagestowechat.customview.myGridView;
import com.skyward.android.shareimagestowechat.utils.ShareMultiImageToWeChatUtil;

import java.util.ArrayList;
import java.util.List;


/**
 * @author: skyward
 * date: 2017/11/17 0017
 * desc:
 */

public class FriendAdapter extends BaseRecyclerAdapter<FriendBean, BaseRecyclerViewHolder> {

    private Context mContext;
    private FriendImageAdapter mFriendImageAdapter;
    private List<String> mList;
    private MainActivity mFriendActivity;
    private ArrayList<Uri> imageList;

    public FriendAdapter(int layoutResId, List<FriendBean> data, Context context, MainActivity friendActivity) {
        super(layoutResId, data);
        this.mContext = context;
        this.mFriendActivity = friendActivity;
    }

    @Override
    protected void bindTheData(BaseRecyclerViewHolder holder, final FriendBean data, int position) {

        ImageView profile_image = holder.findViewById(R.id.profile_image);
        TextView name = holder.findViewById(R.id.name);
        TextView desc_text = holder.findViewById(R.id.desc_text);
        myGridView friend_item_gridView = holder.findViewById(R.id.friend_item_gridView);
        final Button btn_operation = holder.findViewById(R.id.btn_operation);

        desc_text.setText(data.getTitle());
        Glide.with(App.getContext())
                .load(data.getHeaderUrl())
                .apply(App.optionsCenterCrop)
                .into(profile_image);

        mList = new ArrayList<>();
        mList.addAll(data.getImageUrlList());
        mFriendImageAdapter = new FriendImageAdapter(mContext, mList);
        friend_item_gridView.setAdapter(mFriendImageAdapter);
        mFriendImageAdapter.notifyDataSetChanged();

        btn_operation.setText("分享到朋友圈");

        btn_operation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                operation(data);


            }
        });

    }


    private void operation(final FriendBean bean) {
        imageList = new ArrayList<Uri>();
        if (!ShareMultiImageToWeChatUtil.isInstallWeChart(mContext)) {
            Toast.makeText(App.getContext(), "您没有安装微信", Toast.LENGTH_SHORT).show();
            return;
        }
        for (int j = 0; j < bean.getImageUrlList().size(); j++) {

            Glide.with(mContext).asBitmap().load(bean.getImageUrlList().get(j)).into(new SimpleTarget<Bitmap>() {
                @Override
                public void onResourceReady(final Bitmap resource, Transition<? super Bitmap> transition) {

                    Uri uri = ShareMultiImageToWeChatUtil.saveImageToGallery(mFriendActivity, resource);
                    imageList.add(uri);
                    if (imageList.size() == bean.getImageUrlList().size()) {

                        ShareMultiImageToWeChatUtil.shareWithImage(mContext, bean.getTitle(), imageList);
                    }

                }
            });


        }
    }


}
