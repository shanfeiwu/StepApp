package com.wushanfei.stepapp.views;

import android.content.Context;
import android.content.res.TypedArray;
import android.database.Cursor;
import android.graphics.Canvas;
import android.os.Binder;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ScrollView;

import com.wushanfei.stepapp.R;

/*
 *Create by wushanfei
 *on 2020/11/7
 */
public class MyScrollView extends ScrollView {
    public MyScrollView(Context context) {
        super(context);
    }

    public MyScrollView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MyScrollView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        TypedArray array=context.obtainStyledAttributes(attrs, R.styleable.MyScrollView);
        array.getBoolean(R.styleable.MyScrollView_showVolteOverlap,false);
        View view = null;
        if(view instanceof MyScrollView){
        }
    }

    public MyScrollView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    public  void scrolltoCenter(int postionX,int postionY){
        scrollTo(postionX,postionY);
        Cursor c = null;
        final long origId = Binder.clearCallingIdentity();
        c.setNotificationUri(getContext().getContentResolver(), null);
        Binder.restoreCallingIdentity(origId);
        postDelayed(mFinishAnimationRunnable,2000);
        removeCallbacks(mFinishAnimationRunnable);
    }

    private boolean mFinishAnimationDelay = false;
    public boolean ismFinishAnimationDelay() {
        return mFinishAnimationDelay;
    }
    Runnable mFinishAnimationRunnable = new Runnable() {
        @Override
        public void run() {

        }
    };

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }
}
