package com.vcaidian.utilslib.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.Switch;
import android.widget.TextView;
import com.vcaidian.utilslib.R;


/**
 * Author: Austin
 * Time: 2018/8/24
 * Description:
 */
public class ItemSwitch extends LinearLayout implements CompoundButton.OnCheckedChangeListener {
    private static final String TAG = "ItemSwitch";
    private boolean isLog = true;
    private Context context;
    private TextView tvBorderTop,tvBorderBottom,tvSetValue;
    private Switch mySwitch;
    private View view;
    /*private int llytBackground = R.color.white;
    private int llytBackgroundColor = R.color.white;*/
    private int borderHeight = 2;
    private String setValue = "";
    private int borderColor = R.color.colorBorder;
    private boolean itemChecked = false;
    private float marginLeft = 0.0f;
    private float marginRight = 0.0f;
    private int textColor = R.color.colorTxtDefault;
    private boolean borderTopShow = true;
    private boolean borderBottomShow = true;
    private CompoundButton.OnCheckedChangeListener changeListener;

    public ItemSwitch(Context context) {
        this(context,null);
    }

    public ItemSwitch(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs,0);
    }

    public ItemSwitch(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.context = context;
        initViews(attrs);
    }

    private void initViews(AttributeSet attrs) {
        log("initViews");
        view = LayoutInflater.from(context).inflate(R.layout.layout_item_switch,this,true);
        tvBorderTop = view.findViewById(R.id.tv_top_border);
        tvBorderBottom = view.findViewById(R.id.tv_bottom_border);
        tvSetValue = view.findViewById(R.id.tv_set_value);
        mySwitch = view.findViewById(R.id.myswitch);

        TypedArray attributes = context.obtainStyledAttributes(attrs,R.styleable.ItemSwitch);
        if (attributes != null) {
            borderHeight = attributes.getResourceId(R.styleable.ItemSwitch_item_border_height,borderHeight);
            setValue = attributes.getString(R.styleable.ItemSwitch_item_set_value);
            borderColor = attributes.getResourceId(R.styleable.ItemSwitch_item_border_color,borderColor);
            itemChecked = attributes.getBoolean(R.styleable.ItemSwitch_item_checked,itemChecked);
            marginLeft = attributes.getDimension(R.styleable.ItemSwitch_item_marginBottomLeft,dip2Px(marginLeft));
            marginRight = attributes.getResourceId(R.styleable.ItemSwitch_item_marginBottomRight,dip2Px(marginRight));
            textColor = attributes.getResourceId(R.styleable.ItemSwitch_item_textColor,textColor);
            borderTopShow = attributes.getBoolean(R.styleable.ItemSwitch_item_border_top_visibility,borderTopShow);
            borderBottomShow = attributes.getBoolean(R.styleable.ItemSwitch_item_border_bottom_visibility,borderBottomShow);

            tvBorderTop.setHeight(borderHeight);
            tvBorderBottom.setHeight(borderHeight);

            //外边距
            LayoutParams lpBottom = new LayoutParams(LayoutParams.MATCH_PARENT, borderHeight);
            lpBottom.setMargins((int) marginLeft, 0, (int) marginRight, 0);
            tvBorderBottom.setLayoutParams(lpBottom);

            tvSetValue.setText(setValue);
            mySwitch.setChecked(itemChecked);

            tvBorderTop.setVisibility(borderTopShow ? View.VISIBLE : View.GONE);
            tvBorderBottom.setVisibility(borderBottomShow ? View.VISIBLE : View.GONE);

            attributes.recycle();
        }



    }

    public void setItemChecked(boolean checked) {
        if (mySwitch != null)
            mySwitch.setChecked(checked);

    }

    public void setOnCheckedChanged(CompoundButton.OnCheckedChangeListener listener) {
        if (mySwitch != null)
            mySwitch.setOnCheckedChangeListener(listener);
    }

    public void setItemValue(CharSequence value) {
        if (tvSetValue != null)
            tvSetValue.setText(value);
    }

    public void setItemValue(int strId) {
        if (tvSetValue != null)
            tvSetValue.setText(getResources().getString(strId));
    }

    private void log(String strLog) {
        if (isLog)
            Log.e(TAG,strLog);
    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

    }


    private int dip2Px(float dip) {
        return (int) (dip * getContext().getResources().getDisplayMetrics().density + 0.5f);
    }

    public void setItemBorderTopVisibility( int visibility) {
        if (tvBorderTop != null)
            tvBorderTop.setVisibility(visibility);
    }
    public void setItemBorderButtomVisibility( int visibility) {
        if (tvBorderBottom != null)
            tvBorderBottom.setVisibility(visibility);
    }
}
