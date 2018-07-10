package com.demo.weex.ui.adapter;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.taobao.weex.adapter.IWXImgLoaderAdapter;
import com.taobao.weex.common.WXImageStrategy;
import com.taobao.weex.dom.WXImageQuality;


/**
 * WXImageAdapter
 */
public class WXImageAdapter implements IWXImgLoaderAdapter {
    @Override
    public void setImage(String url, ImageView view, WXImageQuality quality, WXImageStrategy strategy) {

        if (TextUtils.isEmpty(url)) {
            return;
        }
        final Context context = view.getContext();

        if (url.startsWith("mipmap://")) {
            String resIdStr = getResIdStr(url);
            if (TextUtils.isEmpty(resIdStr)) {
                return;
            }
            Log.d("WXImageAdapter", resIdStr);
            int imgId = context.getResources().getIdentifier(resIdStr, "mipmap", context.getPackageName());
            view.setImageResource(imgId);
            return;
        }
        Glide.with(context)
                .load(url)
                .into(view);
    }

    private String getResIdStr(String url) {
        int start = url.lastIndexOf("/") + 1;
        int end = url.indexOf(".");
        if (start > end) {
            return null;
        }
        return url.substring(start, end);
    }
}
