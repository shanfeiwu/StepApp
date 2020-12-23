package com.wushanfei.stepapp.utils;


import android.content.Context;
import android.support.annotation.RequiresApi;
import android.telephony.SubscriptionInfo;
import android.telephony.SubscriptionManager;
import android.util.Log;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/*
 *Create by wushanfei
 *on 2020/11/11
 */
public class OverlapViewController {
    public static int mIndex = -1;
    public static int mShowOVolteOverlap = -1;
    public static boolean[] mVolteVisitys = new boolean[]{false,false};
    public static int[] mStatusBarMobileViewIdexes = new int[]{-1 , -1};
    public static List<StatusBarMobileView> mStatusBarMobileView = new ArrayList<>();

    public static boolean getVolteVisityByPhoneId(int phoneId){
        return mVolteVisitys[phoneId];
    }

    public static void setVolteVisitysByPhoneId(int phoneId , boolean visity){
        mVolteVisitys[phoneId] = visity;
    }

    public static int getStatusBarMobileViewIdexesByPhoneId(int phoneId){
        return mStatusBarMobileViewIdexes[phoneId];
    }

    public static void setStatusBarMobileViewIdexesByPhoneId(int phoneId , int index){
        mStatusBarMobileViewIdexes[phoneId] = index;
    }

    public static StatusBarMobileView getStatusBarMobileViewByPhoneId(int phoneId){
        return mStatusBarMobileView.get(phoneId);
    }

    public static void putStatusBarMobileViewByPhoneId(int phoneId,StatusBarMobileView statusBarMobileView){
        mStatusBarMobileView.add(phoneId,statusBarMobileView);
    }

    public static void clearNoSimStatusBarMobileView(){
        //
    }

    public static void updateVolteViewVisity(){
        Log.i("wushanfei","updateVolteViewVisity");
        for (int i = 0;i<mStatusBarMobileView.size();i++){
        }
        for (int i = 0;i<mStatusBarMobileView.size();i++){
            if(mStatusBarMobileView.get(i) != null){
                mStatusBarMobileView.get(i).setVolteViewVisity();
            }
        }
        Map<Integer,StatusBarMobileView> mStatusBarMobileViews = new HashMap<>();
        Iterator<Map.Entry<Integer, StatusBarMobileView>> it = mStatusBarMobileViews.entrySet().iterator();
        while(it.hasNext()){
            Map.Entry<Integer, StatusBarMobileView> entry = it.next();
            StatusBarMobileView StatusBarMobileView = entry.getValue();
        }

    }

    private int mStatusbarMobileViewVolteIndex = -1;

    public int getStatusbarMobileViewVolteIndex() {
        return mStatusbarMobileViewVolteIndex;
    }

    public void setStatusbarMobileViewVolteIndex(int statusbarMobileViewVolteIndex) {
        mStatusbarMobileViewVolteIndex = statusbarMobileViewVolteIndex;
    }

    @RequiresApi(api = 29)
    public static boolean isActiveSubId(Context context, int subId){
        return SubscriptionManager.from(context).isActiveSubscriptionId(subId);
    }
}
