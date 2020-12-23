package com.wushanfei.stepapp.views;

import android.content.Context;
import android.graphics.Rect;
import android.text.InputType;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.SearchView;

/*
 *Create by wushanfei
 *on 2020/12/3
 */
public class ActionSearchViw extends SearchView implements SearchView.OnSuggestionListener, View.OnClickListener {
    public ActionSearchViw(Context context) {
        super(context);
        setOnSuggestionListener(this);
        setOnSearchClickListener(this);
        Log.i("wushanfei","ActionSearchViw11");
    }

    public ActionSearchViw(Context context, AttributeSet attrs) {
        super(context, attrs);
        setOnSuggestionListener(this);
        setOnSearchClickListener(this);
        Log.i("wushanfei","ActionSearchViw22");
    }

    public ActionSearchViw(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setOnSuggestionListener(this);
        setOnSearchClickListener(this);
        Log.i("wushanfei","ActionSearchViw33");
    }

    public ActionSearchViw(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        setOnSuggestionListener(this);
        setOnSearchClickListener(this);
        Log.i("wushanfei","ActionSearchViw44");
    }

    @Override
    public void onWindowFocusChanged(boolean hasWindowFocus) {
        super.onWindowFocusChanged(hasWindowFocus);
        Log.i("wushanfei","onWindowFocusChanged");
        Log.i("wushanfei","getLocalVisibleRect(): ");
    }

    @Override
    protected void onFocusChanged(boolean gainFocus, int direction, Rect previouslyFocusedRect) {
        super.onFocusChanged(gainFocus, direction, previouslyFocusedRect);
        Log.i("wushanfei","" +
                "");
    }


    @Override
    public boolean onSuggestionSelect(int position) {
        return false;
    }

    @Override
    public boolean onSuggestionClick(int position) {
        Log.i("wushanfei","onFocusChanged");
        setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_NORMAL);
        return false;
    }

    @Override
    public void onClick(View v) {
        Log.i("wushanfei","onClick");
    }
}
