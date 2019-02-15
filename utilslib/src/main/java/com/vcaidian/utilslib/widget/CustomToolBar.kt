package com.vcaidian.utilslib.widget
import android.content.Context
import android.support.annotation.DrawableRes
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.widget.LinearLayout
import com.vcaidian.utilslib.R
import kotlinx.android.synthetic.main.custom_toolbar_layout.view.*

/**
 * Author: Austin
 * Date: 2018/10/8
 * Description: 自定义ToolBar.
 */
class CustomToolBar: LinearLayout{
    lateinit var onClickLeftListener: OnClickLeftListener
    lateinit var onClickRightListener: OnClickRightListener

    constructor(context: Context?) : this(context,null)
    constructor(context: Context?, attrs: AttributeSet?) : this(context, attrs, 0)
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {
        initViews()
    }

    private fun initViews() {
        var view: View = LayoutInflater.from(context).inflate(R.layout.custom_toolbar_layout,this ,true)
        img_title_right.setOnClickListener{
            if (onClickRightListener != null)
                onClickRightListener.onClickRight(it)
        }
        img_title_left.setOnClickListener {
            if (onClickLeftListener != null)
                onClickLeftListener.onClickLeft(it)
        }
    }

    public fun setOnClickLeftListener (listener: OnClickListener) {
        img_title_left.setOnClickListener(listener)
    }

    public fun setOnClickRightListener (listener: OnClickListener) {
        img_title_right.setOnClickListener(listener)
    }

    fun setTitle(title: String) {
        tv_title.text = title
    }

    fun setTitle(title: Int) {
        tv_title.text = context.resources.getString(title)
    }

    fun setLeftIcon(@DrawableRes resId: Int) {
        img_title_left.setImageResource(resId)
    }

    fun setRightIcon(@DrawableRes resId: Int) {
        img_title_right.setImageResource(resId)
    }

    fun showLeftIcon(visibility: Int){
        img_title_left?.visibility = visibility
    }

    fun showRightIcon(visibility: Int) {
        img_title_right?.visibility = visibility
    }

    override fun setBackgroundColor(color: Int) {
        super.setBackgroundColor(color)
        toolbar.setBackgroundColor(color)
    }
    /**
     * 左侧按钮点击事件接口
     */
    interface OnClickLeftListener {
        fun onClickLeft(view: View)
    }

    /**
     * 右侧按钮点击事件接口
     */
    interface OnClickRightListener {
        fun onClickRight(view: View)
    }

}