package com.demo.weex;

import android.app.Application;

import com.demo.weex.ui.adapter.WXHttpAdapter;
import com.demo.weex.ui.adapter.WXImageAdapter;
import com.squareup.okhttp.OkHttpClient;
import com.taobao.weex.InitConfig;
import com.taobao.weex.WXSDKEngine;


/**
 * Created by guoqingliang on 18/7/6.
 */

public class WeexDemo extends Application{
    @Override
    public void onCreate() {
        super.onCreate();
        initWeex();
    }

    private void initWeex(){
        InitConfig config = new InitConfig.Builder()
                .setImgAdapter(new WXImageAdapter())
                .setHttpAdapter(new WXHttpAdapter(new OkHttpClient()))
                .build();
        WXSDKEngine.initialize(this, config);
    }
}
