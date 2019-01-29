/*
package com.vcaidian.baselib.base*//*

package com.vcaidian.wclib.base

import android.app.ActivityManager
import android.content.Context
import android.icu.lang.UCharacter.GraphemeClusterBreak.L
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.LinearLayout
import com.githang.statusbar.StatusBarCompat
import com.umeng.analytics.MobclickAgent
import com.umeng.message.PushAgent
import com.vcaidian.baselib.R
import com.vcaidian.baselib.utils.L
import com.vcaidian.wclib.R
import com.vcaidian.wclib.utils.ActivityManager
import com.vcaidian.wclib.utils.ActivityUtil
import com.vcaidian.wclib.widget.CustomToolBar

*/
/*

*//*

*/
/**
 * Author: Austin
 * Date: 2018/10/8
 * Description: Activity基类
 *//*
*/
/*
*//*

*/
/*

abstract class BaseActivity : AppCompatActivity(), View.OnClickListener , CustomToolBar.OnClickLeftListener, CustomToolBar.OnClickRightListener {
    private val BASE_VIEW_ID: Int = R.layout.activity_base
    lateinit var mContext: Context
    lateinit var customToolBar: CustomToolBar
    var fullScreen = false


    override fun onCreate(savedInstanceState: Bundle?) {
        mContext = this
        if (isFullScreen()) {
            ActivityUtil.transparentStatusBar(window)
        } else {
            StatusBarCompat.setStatusBarColor(this, resources.getColor(R.color.bg_toolbar))
        }
        super.onCreate(savedInstanceState)
        setContentView(initRootView())
        ActivityManager.instance.addActivity(this)

        initView()
        initData()
        setListener()
        PushAgent.getInstance(this).onAppStart()

//DaggerActivityComponent.builder().applicationComponent(application as BaseApplication.ApplicationComponent)
    }

    override fun onResume() {
        super.onResume()
        //Umeng
        MobclickAgent.onResume(this)
    }

    private fun initRootView(): View {
        var baseView: LinearLayout = layoutInflater.inflate(BASE_VIEW_ID,null) as LinearLayout
        customToolBar = CustomToolBar(this)
        customToolBar.onClickLeftListener = this
        customToolBar.onClickRightListener = this
        baseView.addView(customToolBar)
        if (layoutId() != 0) {
            var subView: View = getLayoutInflater().inflate(layoutId(), null)
            var params: LinearLayout.LayoutParams = LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,
                    LinearLayout.LayoutParams.MATCH_PARENT, 1.0f)
            subView.setLayoutParams(params)
            baseView.addView(subView)
        }
        return baseView
    }

    open fun isFullScreen(): Boolean {
        return fullScreen
    }

    *//*
*/
/*

*//*

*/
/**
     * 加载布局
     *//*
*/
/*
*//*

*/
/*

    abstract fun layoutId(): Int

    *//*
*/
/*

*//*

*/
/**
     * 初始化数据
     *//*
*/
/*
*//*

*/
/*

    abstract fun initData()

    *//*
*/
/*

*//*

*/
/**
     * 初始化 View
     *//*
*/
/*
*//*

*/
/*

    abstract fun initView()
    abstract fun setListener()

    fun setToolbarTitle(title: String) {
            customToolBar.setTitle(title)
    }

    fun setToolbarTitle(title: Int) {
            customToolBar.setTitle(title)
    }

    fun showToolbar(visibility: Int) {
        customToolBar.visibility = visibility
    }

    override fun onClick(v: View?) {
        when(v?.id) {

        }
    }

    override fun onClickLeft(view: View) {
        finish()
    }

    override fun onClickRight(view: View) {

    }

    fun addFragmetn(viewId: Int,fragment: Fragment) {
        var fragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.replace(viewId,fragment)
        fragmentTransaction.commit()
    }

    fun replaceFragment(viewId: Int,fragment: Fragment) {
        var fragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.replace(viewId,fragment)
        fragmentTransaction.commit()
    }

    override fun onPause() {
        super.onPause()
        MobclickAgent.onPause(this)
    }

    *//*
*/
/*

*//*

*/
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
    }*//*
*/
/*
*//*

*/
/*


    override fun onDestroy() {
        super.onDestroy()
        L.i("onDestroy")
        //关闭ARouter
//        ARouter.getInstance().destroy()

        ActivityManager.instance.removeActivity(this)
    }


}
*//*
*/
/*

*/
