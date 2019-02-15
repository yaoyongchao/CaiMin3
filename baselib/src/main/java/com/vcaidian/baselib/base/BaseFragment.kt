package com.vcaidian.baselib.base

import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.vcaidian.baselib.utils.L

/**
 * Author: Austin
 * Date: 2018/10/8
 * Description: Activity基类
 */
abstract class BaseFragment : Fragment() {
//    private val BASE_VIEW_ID: Int = R.layout.activity_base
    lateinit var mContext: Context
//    lateinit var customToolBar: CustomToolBar


    lateinit var rootView: View

    //是否可见状态
    var lazyVisible: Boolean = false
    //标志位，标志Fragment已经初始化完成。
    private var isPrepared: Boolean = false
    //是否第一次加载完
    private var isFirstLoad = true

    /*override fun onAttach(context: Context?) {
        this.mContext = context?
        super.onAttach(context)
    }*/

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        rootView = inflater.inflate(layoutId(), container, false)
        this.mContext = rootView.context

        initView()
        initData()
        isPrepared = true
        lazyLoad()
        isFirstLoad = true
        return rootView
    }

    /**
     * 加载布局
     */
    abstract fun layoutId(): Int

    /**
     * 初始化数据
     */
    abstract fun initData()

    /**
     * 初始化 View
     */
    abstract fun initView()


    /**
     * 懒加载数据
     */
    public open fun lazyLoadData() {}

    protected fun onVisible() {
        lazyLoad()
    }

    protected fun onInvisible() {}

    protected fun lazyLoad() {
        if (!isPrepared || !isVisible) return
        //        isFirstLoad = false;
        lazyLoadData()
    }

    override fun setUserVisibleHint(isVisibleToUser: Boolean) {
        super.setUserVisibleHint(isVisibleToUser)
        if (userVisibleHint) {
            lazyVisible = true
            onVisible()
        } else {
            lazyVisible = false
            onInvisible()
        }
    }

    override fun onHiddenChanged(hidden: Boolean) {
        super.onHiddenChanged(hidden)
        if (!hidden) {
            lazyVisible = true
            onVisible()
        } else {
            lazyVisible = false
            onInvisible()
        }
    }



    /*override fun onResume() {
        super.onResume()
        L.i("onResume")
    }

    override fun onStart() {
        super.onStart()
        L.i("onStart")
    }

    override fun onPause() {
        super.onPause()
        L.i("onPause")
    }

    override fun onStop() {
        super.onStop()
        L.i("onStop")
    }*/

    override fun onDestroy() {
        super.onDestroy()
        L.i("onDestroy")
        isPrepared = false
    }

    fun addFragmetn(viewId: Int,fragment: Fragment) {

        var fragmentTransaction = childFragmentManager.beginTransaction()
        fragmentTransaction.replace(viewId,fragment)
        fragmentTransaction.commit()
    }


}
