package com.vcaidian.baselib.utils

import android.annotation.SuppressLint
import android.content.Context
import android.widget.Toast

/**
 * Author: Austin
 * Date: 2018/10/9
 * Description:
 */
class ToastUtil {
    companion object {
        @SuppressLint("StaticFieldLeak")
        public fun show(mContext: Context,msg: String) {
            Toast.makeText(mContext,msg,Toast.LENGTH_SHORT).show()
        }

        public fun showLong(mContext: Context,msg: String) {
            Toast.makeText(mContext,msg,Toast.LENGTH_LONG).show()
        }
    }
}