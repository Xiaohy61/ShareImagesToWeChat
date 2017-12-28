package com.skyward.android.shareimagestowechat;

import android.app.Application;

import com.bumptech.glide.Priority;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;

/**
 * @author: skyward
 * date: 2017/12/27 0027
 * desc:
 */
public class App extends Application {

    public static App myContext;
    public static RequestOptions optionsCenterCrop;

    public static Application getContext(){
        return myContext;
    }


    @Override
    public void onCreate() {
        super.onCreate();
        myContext = this;
        optionsCenterCrop = new RequestOptions()
                .centerCrop()
                .priority(Priority.HIGH)
                .diskCacheStrategy(DiskCacheStrategy.ALL);
    }
}
