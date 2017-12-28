package com.skyward.android.shareimagestowechat;

import android.Manifest;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.skyward.android.shareimagestowechat.adapter.FriendAdapter;
import com.skyward.android.shareimagestowechat.bean.FriendBean;
import com.skyward.android.shareimagestowechat.utils.PermissionUtils;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView mFriendRecycleView;
    private final int PERMISSION_REQUEST_CODE = 1;
    private final String[] permissionManifest = {
            Manifest.permission.WRITE_EXTERNAL_STORAGE,
            Manifest.permission.READ_EXTERNAL_STORAGE,

    };


    private FriendAdapter mFriendAdapter;

    private String headImage1="http://img1.imgtn.bdimg.com/it/u=1312054506,3670712663&fm=27&gp=0.jpg";
    private String headImage2="http://img0.imgtn.bdimg.com/it/u=511139256,2968373034&fm=27&gp=0.jpg";
    private String headImage3="http://img4.imgtn.bdimg.com/it/u=128308122,770382628&fm=27&gp=0.jpg";

    private String image1="http://img.ivsky.com/img/tupian/pre/201708/31/haianxiandemeilifengjingtupian.jpg";
    private String image2="http://img.ivsky.com/img/tupian/pre/201708/31/haianxiandemeilifengjingtupian-001.jpg";
    private String image3="http://img.ivsky.com/img/tupian/pre/201708/31/haianxiandemeilifengjingtupian-002.jpg";
    private String image4="http://img.ivsky.com/img/tupian/pre/201708/31/haianxiandemeilifengjingtupian-006.jpg";
    private String videoUrl ="http://jzvd.nathen.cn/342a5f7ef6124a4a8faf00e738b8bee4/cf6d9db0bd4d41f59d09ea0a81e918fd-5287d2089db37e62345123a1be272f8b.mp4";
    private String preimage="http://sjbz.fd.zol-img.com.cn/t_s208x312c5/g5/M00/02/05/ChMkJlhss52INU8SAAUKNLpFdWoAAZFyAMI7WMABQpM523.jpg";
    private List<FriendBean> mFriendBeanList;
    private List<String> imageListO1 = new ArrayList<>();
    private List<String> imageListO2 = new ArrayList<>();
    private List<String> imageListO3 = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if(PermissionUtils.hasAlwaysDeniedPermission(this,permissionManifest)){
            PermissionUtils.requestPermissions(this, PERMISSION_REQUEST_CODE, permissionManifest, new PermissionUtils.OnPermissionListener() {
                @Override
                public void onPermissionGranted() {
                    Log.i("myLog","onPermissionGranted");
                }

                @Override
                public void onPermissionDenied(String[] deniedPermissions) {
                    Log.i("myLog","onPermissionDenied"+deniedPermissions.toString());
                }
            });
        }
        initImage();
        initView();

    }

    private void initImage() {

        imageListO1.add(image1);
        imageListO1.add(image2);
        imageListO1.add(image3);

        imageListO2.add(image1);
        imageListO2.add(image2);

        imageListO3.add(image1);
        imageListO3.add(image2);
        imageListO3.add(image3);
        imageListO3.add(image4);
        imageListO3.add(image1);
        imageListO3.add(image2);
        imageListO3.add(image3);
        imageListO3.add(image4);


    }

    private void initView() {
        mFriendBeanList = new ArrayList<>();


        mFriendRecycleView = findViewById(R.id.friend_recycleView);

        mFriendRecycleView.setLayoutManager(new LinearLayoutManager(this));

        mFriendBeanList.add(new FriendBean("第一",imageListO1,headImage1));
        mFriendBeanList.add(new FriendBean("第二",imageListO2,headImage2));
        mFriendBeanList.add(new FriendBean("第三",imageListO3,headImage3));

        for (int i = 0; i < imageListO1.size(); i++) {
            Log.i("myLog","imageListO1: "+imageListO1.get(i));
        }

        mFriendAdapter = new FriendAdapter(R.layout.friend_item,mFriendBeanList,this,MainActivity.this);
        mFriendAdapter.notifyDataSetChanged();
        mFriendRecycleView.setAdapter(mFriendAdapter);
    }


}
