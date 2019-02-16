package com.vcaidian.customer.ui.login

import android.view.View
import com.vcaidian.baselib.base.BaseActivity
import com.vcaidian.customer.R

class LoginActivity : BaseActivity() {
    override fun setListener() {
    }

    override fun layoutId(): Int {
        return R.layout.activity_login
    }

    override fun initData() {
    }

    override fun initView() {
        showToolbar(View.GONE)
    }

    override fun isFullScreen(): Boolean {
        return true
    }

    /*override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
    }*/
}
