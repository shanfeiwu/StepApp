package com.wushanfei.stepapp.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.util.Log;
import android.view.View;

/*
 *Create by wushanfei
 *on 2020/12/11
 */
public class WidgetButtonIntentReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        Cursor c = null;

        View view = null;
        view.setVisibility(View.GONE);
        Log.i("wushanfei","NotifyAgentBroadcastReceiver");
        Log.i("wushanfei","action: "+action);
    }
}
