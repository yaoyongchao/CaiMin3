package com.vcaidian.httplib.config
import com.vcaidian.baselib.http.BaseApi
import com.vcaidian.wclib.config.DebugConfig

object WcConfig {
    //微信参数配置
//    val appIdDebug = "wx528834982667ff04"
    val appIdDebug = "wx1e2beec58a4090c0"
    val appIdProduct = "wx1e2beec58a4090c0"
    val appId = if (DebugConfig.DEBUG) appIdDebug else appIdProduct
    val fileUrlDebug = "http://121.42.197.2:5000/api/file/"
    val fileUrlProduct = "http://118.190.97.44:5000/api/file/"
    val fileUrl = if (DebugConfig.DEBUG) fileUrlDebug else fileUrlProduct

    val BUGLY_ID_DEBUG = "ecec7f7fb4"
    val BUGLY_ID_PRODUCT = "b4041da449"
    val BUGLY_ID = if (DebugConfig.DEBUG) BUGLY_ID_DEBUG else BUGLY_ID_PRODUCT

    val ENWS_LOGO = BaseApi.URL_DOMAIN + "logos/football/"
}