

import com.vcaidian.baselib.utils.L
import okhttp3.Interceptor
import okhttp3.Response
import java.io.IOException
//https://blog.csdn.net/bunny1024/article/details/53504556?utm_source=blogxgwz0
class LoggingInterceptor : Interceptor {
    @Throws(IOException::class)
    override fun intercept(chain: Interceptor.Chain): Response {
        //这个chain里面包含了request和response，所以你要什么都可以从这里拿
        val request = chain.request()

        val t1 = System.nanoTime()//请求发起的时间
        //        logger.info(String.format("发送请求 %s on %s%n%s",
        //                request.url(), chain.connection(), request.headers()));

        L.e("http:  " + String.format("发送请求 %s on %s%n%s",
                request.url(),
                chain.connection(),
                request.headers()))

        val response = chain.proceed(request)

        val t2 = System.nanoTime()//收到响应的时间

        //这里不能直接使用response.body().string()的方式输出日志
        //因为response.body().string()之后，response中的流会被关闭，程序会报错，我们需要创建出一
        //个新的response给应用层处理
        val responseBody = response.peekBody((1024 * 1024).toLong())

        //        logger.info(String.format("接收响应: [%s] %n返回json:【%s】 %.1fms%n%s",
        //                response.request().url(),
        //                responseBody.string(),
        //                (t2 - t1) / 1e6d,
        //                response.headers()));

//        var responsebody = Gson().fromJson<BaseResponseBody>(responseBody.string(),BaseResponseBody::class.java)

        L.e("http:  " + String.format("接收响应: [  %s  ] %n返回json: %s %n响应时间: %.1fms%n%s",
                                response.request().url(),
                                responseBody.string(),
//                                    body,
                                (t2 - t1) / 1e6,
                                response.headers()))

        return response
    }
}