package com.skyward.android.shareimagestowechat.bean;

import java.util.List;

/**
 * @author: skyward
 * date: 2017/12/27 0027
 * desc:
 */
public class FriendBean {

    private String title;
    private List<String> imageUrlList;
    private String headerUrl;

    public FriendBean(String title, List<String> imageUrlList, String headerUrl) {
        this.title = title;
        this.imageUrlList = imageUrlList;
        this.headerUrl = headerUrl;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<String> getImageUrlList() {
        return imageUrlList;
    }

    public void setImageUrlList(List<String> imageUrlList) {
        this.imageUrlList = imageUrlList;
    }

    public String getHeaderUrl() {
        return headerUrl;
    }

    public void setHeaderUrl(String headerUrl) {
        this.headerUrl = headerUrl;
    }
}
