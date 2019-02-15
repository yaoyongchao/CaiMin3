package com.vcaidian.baselib.mvp

import java.lang.ref.WeakReference

public abstract class BasePresenter1<M : Comparable<BaseModel>, V: BaseView> {
    lateinit var mModel: M
    private var mViewRef: WeakReference<V>? = null
    private var attach = false
    val view: V?
        get() = if (isAttach()) {
            mViewRef!!.get()
        } else {
            null
        }


    fun attachView(pView: V) {
        mViewRef = WeakReference(pView)
    }

    fun isAttach(): Boolean {
        return mViewRef != null && mViewRef!!.get() != null
    }

    fun dettachView() {
        if (null != mViewRef) {
            mViewRef!!.clear()
            mViewRef = null
        }
    }
}