package com.vcaidian.httplib.http;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.widget.ImageView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.target.SimpleTarget;
import com.bumptech.glide.request.transition.Transition;
import com.vcaidian.httplib.R;
import com.vcaidian.httplib.config.WcConfig;

/**
 * Author: Austin
 * Time: 2018/8/14
 * Description:
 */
public class ImgUtilWc {
    public static void loadImgFace(Context context, int face_url, final ImageView img) {
        String imgUrl = WcConfig.INSTANCE.getFileUrl()+face_url;
        RequestOptions options = new RequestOptions()
//                .placeholder(dPlaceHolder)
//                .error(dError)
                .fitCenter()
                .diskCacheStrategy(DiskCacheStrategy.NONE);
        Glide.with(context)
                .load(imgUrl)
                .into(new SimpleTarget<Drawable>() {
                    @Override
                    public void onResourceReady(@NonNull Drawable resource, @Nullable Transition<? super Drawable> transition) {
                        img.setImageDrawable(resource);
                    }
                });
    }

    /**
     * @param: [context, imgUrl, img]
     * @return: void
     * @description: 设置加载占位符及加载失败
     */
    public static void loadImgPlaceHolderError(Context context, String imgUrl, ImageView img, int dPlaceHolder, int dError) {
        RequestOptions options = new RequestOptions()
                .placeholder(dPlaceHolder)
                .error(dError)
                .diskCacheStrategy(DiskCacheStrategy.NONE);

        Glide.with(context).load(imgUrl).apply(options).into(img);
    }
    public static void loadImg(Context context, String imgUrl, ImageView img) {
        loadImgPlaceHolderError(context,imgUrl,img, R.drawable.ic_avatar, R.drawable.ic_avatar);
    }

    public static void loadGifImg (Context context, int imgUrl, ImageView img)  {
        Glide.with(context).asGif().load(imgUrl).into(img);
    }
}
