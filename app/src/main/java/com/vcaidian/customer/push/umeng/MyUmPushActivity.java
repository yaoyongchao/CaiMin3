package com.vcaidian.customer.push.umeng;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.umeng.message.UmengNotifyClickActivity;
import com.vcaidian.customer.R;

import org.android.agoo.common.AgooConstants;

/**
 * Created by chao on 19-1-2.
 */

public class MyUmPushActivity extends UmengNotifyClickActivity{

    @Override
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_um_push);

    }

    @Override
    public void onMessage(Intent intent) {
        super.onMessage(intent);
        String body = intent.getStringExtra(AgooConstants.MESSAGE_BODY);
        log(body);
    }


    private void log(String str) {
        Log.e("aa",str);
    }
}
