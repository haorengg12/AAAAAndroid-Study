package com.haorengg12.kkcc.zuoye2;

import android.app.Application;

/**
 * Created by 黄黄k on 2017-10-30.
 * 方便非活动类
 * 调用系统服务(会出现未知错误，未debug)
 */

public class MyApplication extends Application {
    private static MyApplication instance;

    @Override
    public void onCreate() {
        // TODO Auto-generated method stub
        super.onCreate();

        instance = this;
    }

    public static MyApplication getInstance() {
        // TODO Auto-generated method stub
        return instance;
    }
}
