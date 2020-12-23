package com.wushanfei.stepapp.views;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.EditText;

/*
 *Create by wushanfei
 *on 2020/12/4
 */
@SuppressLint("AppCompatCustomView")
public class MyEditText extends EditText {

    private boolean showingSoftKeyboard = false;

    public boolean isShowingSoftKeyboard() {
        return showingSoftKeyboard;
    }

    public void setShowingSoftKeyboard(boolean showingSoftKeyboard) {
        this.showingSoftKeyboard = showingSoftKeyboard;
    }

    public MyEditText(Context context) {
        super(context);
    }

    public MyEditText(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MyEditText(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public MyEditText(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        Log.i("wushanfei","dispatchTouchEvent-sub");
        showingSoftKeyboard = true;
        return super.dispatchTouchEvent(ev);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Log.i("wushanfei","onTouchEvent-sub");
        return super.onTouchEvent(event);
    }


}
