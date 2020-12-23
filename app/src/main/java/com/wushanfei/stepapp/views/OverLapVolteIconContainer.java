package com.wushanfei.stepapp.views;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;

import com.wushanfei.stepapp.MainActivity;
import com.wushanfei.stepapp.R;
import com.wushanfei.stepapp.utils.OverlapViewController;

/*
 *Create by wushanfei
 *on 2020/11/11
 */
public class OverLapVolteIconContainer extends LinearLayout implements MainActivity.VolteContainerVisityCallback {
    public OverLapVolteIconContainer(Context context) {
        super(context);
    }

    public OverLapVolteIconContainer(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public OverLapVolteIconContainer(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public OverLapVolteIconContainer(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    public static OverLapVolteIconContainer fromContext(Context context) {
        LayoutInflater inflater = LayoutInflater.from(context);
        OverLapVolteIconContainer v = (OverLapVolteIconContainer)
                inflater.inflate(R.layout.volte_icon_linearlayout, null);
        return v;
    }

    @Override
    public void setVolteContainerVisibility() {
            setVisibility(View.VISIBLE);
    }
}
