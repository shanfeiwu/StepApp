package com.wushanfei.stepapp;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

/*
 *Create by wushanfei
 *on 2020/9/11
 */
public class TestServices extends Service {
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.i("wushanfei","onCreate");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.i("wushanfei","onStartCommand");

        final NotificationManager manager = (NotificationManager) this.getSystemService(NOTIFICATION_SERVICE);

        NotificationChannel notificationChannel = new NotificationChannel("test111","通知",NotificationManager.IMPORTANCE_DEFAULT);
        notificationChannel.enableVibration(true);
        manager.createNotificationChannel(notificationChannel);

        Notification.Builder builder = new Notification.Builder
                (this, "TestServices_notification");
        builder.setContentTitle("TestTitle").setContentText("this is a test");
        builder.setChannelId("test111");

        final Notification status = builder.build();
        //status.flags |= Notification.FLAG_ONGOING_EVENT;
        status.icon = R.drawable.ic_launcher_foreground;
        startForeground(1,status);
        stopForeground(false);

        new Thread(){
            @Override
            public void run() {
                try {
                    sleep(10000);
                    //manager.notify(1,status);
//                    stopForeground(false);
                    startForeground(1,status);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }.start();
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onStart(Intent intent, int startId) {
        Log.i("wushanfei","onStart");
        super.onStart(intent, startId);
    }

    @Override
    public void onDestroy() {
        Log.i("wushanfei","onDestroy");
        super.onDestroy();
    }

}
