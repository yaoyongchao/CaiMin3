package com.vcaidian.baselib.mvp

import android.os.Bundle
import com.vcaidian.baselib.base.BaseActivity
import com.vcaidian.baselib.utils.CreatUtil
import com.vcaidian.baselib.utils.L
import com.vcaidian.baselib.widget.LoadingDialog

abstract class MvpBaseActivity<V: BaseView,P : BasePresenter<V,*> >: BaseActivity(){
    var mPresenter: P? =null//可空类型
    var loadingDialog: LoadingDialog? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        mPresenter = CreatUtil.getT(this,1)
        super.onCreate(savedInstanceState)
        L.e( "mPresenter: $mPresenter")
        mPresenter?.bindView(this as V)
        loadingDialog = LoadingDialog(mContext)
    }

    /*override fun initView() {

    }*/

    open fun showDialog() {
        if (loadingDialog != null && !loadingDialog?.isShowing!!)
            loadingDialog?.show()
    }

    open fun dismissDialog() {
        if (loadingDialog?.isShowing!!)
            loadingDialog?.dismiss()
    }

    override fun initData() {
    }

    override fun setListener() {
    }

    override fun onDestroy() {
        super.onDestroy()
        mPresenter?.unBindView()
    }
}
