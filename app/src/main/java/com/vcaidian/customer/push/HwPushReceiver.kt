///*
//package com.vcaidian.customer.push
//
//import android.content.Context
//import android.os.Bundle
//import android.os.Environment
//import android.os.Looper
//import android.widget.Toast
//
//import com.huawei.hms.support.api.push.PushReceiver
//
//import java.io.FileWriter
//import java.io.IOException
//
//*/
///**
// * 华为消息receiver
// *//*
//
//
//class HwPushReceiver : PushReceiver() {
//
//    override fun onEvent(context: Context?, arg1: PushReceiver.Event?, arg2: Bundle?) {
//        super.onEvent(context, arg1, arg2)
//
//        showToast("onEvent$arg1 Bundle $arg2", context)
//    }
//
//    override fun onPushMsg(context: Context, arg1: ByteArray, arg2: Bundle): Boolean {
//
//        showToast("onPushMsg" + String(arg1) + " Bundle " + arg2, context)
//        return super.onPushMsg(context, arg1, arg2)
//    }
//
//    override fun onPushMsg(context: Context?, arg1: ByteArray?, arg2: String?) {
//
//        showToast("onPushMsg" + String(arg1!!) + " arg2 " + arg2, context)
//        super.onPushMsg(context, arg1, arg2)
//    }
//
//    override fun onPushState(context: Context?, arg1: Boolean) {
//
//        showToast("onPushState" + arg1, context)
//        super.onPushState(context, arg1)
//    }
//
//    override fun onToken(context: Context, arg1: String, arg2: Bundle?) {
//        super.onToken(context, arg1, arg2)
//
//        showToast(" onToken" + arg1 + "bundke " + arg2, context)
//    }
//
//    override fun onToken(context: Context?, arg1: String?) {
//        super.onToken(context, arg1)
//        showToast(" onToken" + arg1!!, context)
//    }
//
//    fun showToast(toast: String, context: Context?) {
//
//        Thread(Runnable {
//            Looper.prepare()
//            Toast.makeText(context, toast, Toast.LENGTH_SHORT).show()
//            Looper.loop()
//        }).start()
//    }
//
//    private fun writeToFile(conrent: String) {
//        val SDPATH = Environment.getExternalStorageDirectory().toString() + "/huawei.txt"
//        try {
//            val fileWriter = FileWriter(SDPATH, true)
//
//            fileWriter.write(conrent + "\r\n")
//            fileWriter.flush()
//            fileWriter.close()
//        } catch (e: IOException) {
//            // TODO Auto-generated catch block
//            e.printStackTrace()
//        }
//
//    }
//}*/
