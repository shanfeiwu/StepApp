package com.wushanfei.stepapp.base;

import android.app.Activity;
import android.app.Application;
import android.os.Process;

import java.util.LinkedList;

/*
 *Create by wushanfei
 *on 2020/9/1
 */
public class FrameApplication extends Application {
    private LinkedList<Activity> mListActivity = new LinkedList<>();

    public void addActivityToLinkList(Activity activity) {
        mListActivity.add(activity);
    }

    public void removeActivity(Activity activity) {
        if (mListActivity.contains(activity)) {
            mListActivity.remove(activity);
        }
    }

    public void clearActivity() {
        for (int i = mListActivity.size() - 1; i >= 0; i--) {
            if(mListActivity.get(i) !=null){
                mListActivity.get(i).finish();
            }
        }
    }

    public void exitApplication(){
        try {
            clearActivity();
        }catch (Exception e){
        }finally {
            System.exit(0);
            Process.killProcess(Process.myPid());
        }
    }

}
