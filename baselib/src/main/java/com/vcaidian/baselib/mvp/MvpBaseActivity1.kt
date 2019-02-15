package com.vcaidian.baselib.mvp

import android.os.Bundle
import android.util.Log
import com.vcaidian.baselib.base.BaseActivity
import com.vcaidian.baselib.utils.CreatUtil

abstract class MvpBaseActivity1<P : BasePresenter<*, *>>: BaseActivity(){
    var mPresenter: P? =null//可空类型

    override fun onCreate(savedInstanceState: Bundle?) {
//        mPresenter = CreatUtilOne.getT(this,0)
        mPresenter = CreatUtil.getT(this,0)
        super.onCreate(savedInstanceState)
        Log.e("aa", "mPresenter: $mPresenter")
//        mPresenter?.attachView(this)
//        mPresenter?.attachView(this)
    }

    override fun initView() {
    }

    override fun initData() {
    }

    override fun onDestroy() {
        super.onDestroy()
//        mPresenter?.dettachView()
    }
}