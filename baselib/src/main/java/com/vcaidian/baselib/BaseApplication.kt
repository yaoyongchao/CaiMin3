/*
package com.vcaidian.wclib

import android.app.Application
import android.content.Context
import android.content.Intent
import android.util.Log
import com.alibaba.android.arouter.launcher.ARouter
import com.scwang.smartrefresh.layout.SmartRefreshLayout
import com.scwang.smartrefresh.layout.constant.SpinnerStyle
import com.scwang.smartrefresh.layout.footer.ClassicsFooter
import com.scwang.smartrefresh.layout.header.ClassicsHeader
import com.tencent.bugly.crashreport.CrashReport
import com.tencent.mm.opensdk.openapi.IWXAPI
import com.umeng.commonsdk.UMConfigure
import com.umeng.message.IUmengRegisterCallback
import com.umeng.message.PushAgent
import com.umeng.message.UTrack
import com.vcaidian.baselib.BuildConfig
import com.vcaidian.baselib.R
import com.vcaidian.baselib.utils.AppUtil
import com.vcaidian.baselib.utils.L
import com.vcaidian.baselib.utils.SPUtils
import com.vcaidian.wclib.config.DebugConfig
import io.reactivex.Observable
import io.reactivex.ObservableOnSubscribe
import io.reactivex.functions.Consumer
import io.reactivex.schedulers.Schedulers
import org.android.agoo.huawei.HuaWeiRegister
import org.android.agoo.xiaomi.MiPushRegistar


*/
/**
 * Author: Austin
 * Date: 2018/10/8
 * Description:
 *//*

//open class BaseApplication: Application(){
open class BaseApplication: Application() {

    val SP_NAME = "caimin"
    //小米
    private val miAppId = "2882303761517886546"
    private val miAppKey = "5981788668546"


    //个人
    private val umAppKey = "5b97247ef43e483a5d00000e"
    private val umPushSecret = "50aef5351cc9680e5e5b6653cf23aaf8"
    //生产
//    private val umAppKey = "5bada2c3b465f550790000e9"
//    private val umPushSecret = "639682b514a9617883bd7c16d7f91574"



    override fun onCreate() {
        super.onCreate()

        Observable.create(ObservableOnSubscribe<Int> { emitter ->
            emitter.onNext(1)
        }).subscribeOn(Schedulers.newThread())
                .observeOn(Schedulers.newThread())
                .subscribe(Consumer {
                    initViews()
                })
    }

    open fun initViews() {
        appContext = applicationContext
//        instance = this
        L.initLogger()
        SPUtils.getInstance(appContext, SP_NAME)


        //ARouter
        if (BuildConfig.DEBUG) {
            ARouter.openLog()//打开日志
            ARouter.openDebug()//打开调式模式(如果在InstantRun模式下运行，必须开启调试模式！线上版本需要关闭,否则有安全风险)
        }
        ARouter.init(this.application)

        //Bugly
        initBuylg()
        //InitUmeng
        initUment()
        //Init XinGe
//        initXinGe()
    }



    open fun initUment() {
        //推送
        UMConfigure.init(appContext, umAppKey, "weicai2", UMConfigure.DEVICE_TYPE_PHONE, umPushSecret)

        UMConfigure.setLogEnabled(true)

        */
/**
         * 设置日志加密
         * 参数：boolean 默认为false（不加密）
         *//*

//        UMConfigure.setEncryptEnabled(false)
        */
/**
         *  设置场景类型接口
         *  参数：上下文
         *  参数： 模式
         *//*

//        MobclickAgent.setScenarioType(appContext, MobclickAgent.EScenarioType.E_UM_NORMAL)


        mPushAgent = PushAgent.getInstance(this.application!!)
        mPushAgent?.register(object : IUmengRegisterCallback{
            override fun onSuccess(p0: String?) {
                //注册成功会返回Devices Token
                L.e("Umeng注册成功：" + p0)
            }

            override fun onFailure(p0: String?, p1: String?) {
                L.e("Umeng注册失败：" + p0 + "----: " + p1)
            }

        })
        //华为推送
        HuaWeiRegister.register(this.application)
        //小米推送
        MiPushRegistar.register(this.application, miAppId, miAppKey)
    }




    private fun initBuylg() {
        val context = applicationContext
        // 获取当前包名
        val packageName = context.packageName
        // 获取当前进程名
        val processName = AppUtil.getProcessName(android.os.Process.myPid())
        // 设置是否为上报进程
        val strategy = UserStrategy(context)
        strategy.isUploadProcess = processName == null || processName == packageName
        // 初始化Bugly
        CrashReport.initCrashReport(context, WcConfig.BUGLY_ID, DebugConfig.DEBUG, strategy)
//        CrashReport.initCrashReport(applicationContext, "BUGLY_ID", true)
    }


    companion object {
//        lateinit var instance: BaseApplication
        var wxApi: IWXAPI? = null
        lateinit var appContext: Context
        init {//static 代码段可以防止内存泄露
            //设置全局的Header构建器
            SmartRefreshLayout.setDefaultRefreshHeaderCreater { context, layout ->
                layout.setPrimaryColorsId(R.color.bgDefault, R.color.colorTxtDefault)//全局设置主题颜色
                ClassicsHeader(context).setSpinnerStyle(SpinnerStyle.Translate)//指定为经典Header，默认是 贝塞尔雷达Header
            }
            //设置全局的Footer构建器
            SmartRefreshLayout.setDefaultRefreshFooterCreater { context, layout ->
                //指定为经典Footer，默认是 BallPulseFooter
                ClassicsFooter(context).setSpinnerStyle(SpinnerStyle.Translate)
            }
        }

        var mPushAgent : PushAgent? = null
        */
/**
         * 友盟设置别名
         * @param userId
         *//*

        public fun setAlias(userId:String) {
            L.i("userId: $userId")
            mPushAgent?.addAlias(userId,"UMENG_PUSH",object : UTrack.ICallBack{
                override fun onMessage(isSuccess: Boolean, message: String?) {
                    L.i("Umeng别名设置：$isSuccess ----- $message" )
                }
            })
        }
    }

}*/
