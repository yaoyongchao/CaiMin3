package com.vcaidian.customer.push.umeng

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Message
import android.util.Log
import android.widget.Toast
import com.umeng.message.UmengNotifyClickActivity
import com.vcaidian.customer.R
import org.android.agoo.common.AgooConstants






class UmPushActivity : UmengNotifyClickActivity() {

   /* private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            String body = (String) msg.obj;
            Gson gson = new GsonBuilder().create();
            PushInfo info = gson.fromJson(body, PushInfo.class);
            String url = info.getExtra().getYourParam();//获取你定义的那个参数
            if (url != null) {//跳转到过度页
                Intent intent = new Intent();
                intent.putExtra(Constants.SHEME_URL, url);
                intent.setClassName(MipushDialogActivity.this, Constants.MIDDLEACTIVITY_CLASSNAME);
                startActivity(intent);
                overridePendingTransition(0, 0);
            }
            finish();
        }
    }*/

    private val handler = object : Handler() {
        override fun handleMessage(msg: Message) {
            var body = msg.obj as String
            toast("onMessage" + body)
            Log.e("aa","push: " + body)


           /*
            String body = (String) msg.obj;
            Gson gson = new GsonBuilder().create();
            PushInfo info = gson.fromJson(body, PushInfo.class);
            String url = info.getExtra().getYourParam();//获取你定义的那个参数
            if (url != null) {//跳转到过度页
                Intent intent = new Intent();
                intent.putExtra(Constants.SHEME_URL, url);
                intent.setClassName(MipushDialogActivity.this, Constants.MIDDLEACTIVITY_CLASSNAME);
                startActivity(intent);
                overridePendingTransition(0, 0);
            }*/
//            finish();
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_um_push)
        toast("我从华为来！")
    }

    override fun onMessage(intent: Intent) {
        super.onMessage(intent)
        val body = intent.getStringExtra(AgooConstants.MESSAGE_BODY)
        log(body)
    }


//    override fun onNewIntent(intent: Intent?) {
//        super.onNewIntent(intent)
//    }

    /**
     * 该方法异步调用，不阻塞主线程。
     */
    /*override fun onMessage(intent: Intent?) {
        super.onMessage(intent)//此方法必须调用，否则无法统计打开数

        *//*val message = intent?.getStringExtra(AgooConstants.MESSAGE_BODY)
        val msg = UMessage(JSONObject(message))
        log("msg" + msg.toString())
        log("99" + msg.custom)
        log("88:" + msg.text)

        val extra = msg.extra
        val intentAct = Intent()
        log("extra:" + extra)
        if (extra != null) {
            var messageType = extra["MT"]
            log("message:" + messageType)
        }*//*


//        val body:String = intent?.getStringExtra(AgooConstants.MESSAGE_BODY)!!
//        val body = intent?.getStringExtra(AgooConstants.MESSAGE_BODY)


//        val body:String = intent?.getStringExtra(AgooConstants.MESSAGE_BODY)!!
//        log( body)
//        val message = Message.obtain()
//        message.obj = body
//        handler.sendMessage(message)

//        toast("onMessage")
//        tv0.text = body *//*+ (body as UMessage).text*//*
//        val message = Message.obtain()
//        message.obj = body
//        handler.sendMessage(message)
//        log("ab" + body)

    }*/


    fun toast(msg : String) {
        Toast.makeText(this,msg,Toast.LENGTH_SHORT).show()

    }
    fun log(str: String) {
        Log.e("abcd",str)
    }
}
