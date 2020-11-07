package com.wushanfei.stepapp.views;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteCantOpenDatabaseException;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.widget.TextView;

/*
 *Create by wushanfei
 *on 2020/10/15
 */
public class MarqueeAlwaysTextView extends TextView {
    public MarqueeAlwaysTextView(Context context) {
        super(context);
    }

    public MarqueeAlwaysTextView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public MarqueeAlwaysTextView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public boolean isFocused() {
        return true;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        final int action = event.getAction();
        switch (action) {
            case MotionEvent.ACTION_DOWN:
                setEllipsize(TextUtils.TruncateAt.MARQUEE);
                break;
            case MotionEvent.ACTION_UP:
            case MotionEvent.ACTION_CANCEL:
                setEllipsize(null);
                break;
            default:
                break;
        }
        //return true;
        return super.onTouchEvent(event);
    }

    long powerKeyDownPreTime = 0;
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        //Log.i("wushanfei","keyCode: "+keyCode);
        if (keyCode == KeyEvent.KEYCODE_POWER){
            powerKeyDownPreTime = event.getDownTime();
            //Log.i("wushanfei","onKeyDown: "+powerKeyDownPreTime);
        }

        return super.onKeyDown(keyCode, event);
    }

    private Cursor getData() {
        try {

        }catch (SQLiteCantOpenDatabaseException exception){
            android.os.Process.killProcess(android.os.Process.myPid());
            System.exit(0);
            exception.printStackTrace();
        }
        Cursor cursor = getContext().getContentResolver().query(null,
                null, null, null,
                null);
        return cursor;
    }
}
