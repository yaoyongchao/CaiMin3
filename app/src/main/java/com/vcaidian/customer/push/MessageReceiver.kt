/*
package com.vcaidian.customer.push

import android.content.Context
import com.tencent.android.tpush.*
import com.vcaidian.baselib.utils.L
import com.vcaidian.customer.utils.JumpUtil
import com.vcaidian.customer.utils.RouteUtils

*/
/**
 * Created by Administrator on 2018/12/11.
 *//*


class MessageReceiver : XGPushBaseReceiver() {
    */
/**
     * 注册回调
     * @param context
     * @param i
     * @param xgPushRegisterResult
     *//*

    override fun onRegisterResult(context: Context, i: Int, xgPushRegisterResult: XGPushRegisterResult) {
        L.i("onRegisterResult")
    }

    */
/**
     * 反注册回调
     * @param context
     * @param i
     *//*

    override fun onUnregisterResult(context: Context, i: Int) {
        L.i("onUnregisterResult")
    }

    */
/**
     * 设置标签回调
     * @param context
     * @param i
     * @param s
     *//*

    override fun onSetTagResult(context: Context, i: Int, s: String) {
        L.i("onSetTagResult")
    }

    */
/**
     * 删除标签回调
     * @param context
     * @param i
     * @param s
     *//*

    override fun onDeleteTagResult(context: Context, i: Int, s: String) {
        L.i("onDeleteTagResult")
    }

    */
/**
     * 应用内消息的回调
     * @param context
     * @param xgPushTextMessage
     *//*

    override fun onTextMessage(context: Context, xgPushTextMessage: XGPushTextMessage) {
        L.i("onTextMessage" + xgPushTextMessage.content)
        JumpUtil.jumpActivityWithString(RouteUtils.ProgramDetailsActivity, xgPushTextMessage.content!!)
    }

    */
/**
     * 通知被点击触发的回调
     * @param context
     * @param xgPushClickedResult
     *//*

    override fun onNotifactionClickedResult(context: Context, xgPushClickedResult: XGPushClickedResult) {
        L.i("onNotifactionClickedResult" + xgPushClickedResult.content)
    }

    */
/**
     * 通知被展示触发的回调，可以在此保存APP收到的通知
     * @param context
     * @param xgPushShowedResult
     *//*

    override fun onNotifactionShowedResult(context: Context, xgPushShowedResult: XGPushShowedResult) {
        L.i("onNotifactionShowedResult" + xgPushShowedResult.content)
    }
}
*/
