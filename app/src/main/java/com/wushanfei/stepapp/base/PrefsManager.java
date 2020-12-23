package com.wushanfei.stepapp.base;

import android.content.Context;

/*
 *Create by wushanfei
 *on 2020/9/2
 */
public class PrefsManager {
    public final  static  String PREFS_NAME = "prefs_step";
    public static void clear(Context context){
        context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE).edit().clear().commit();
    }
    public static boolean contains(Context context){
        return context.getSharedPreferences(PREFS_NAME,Context.MODE_PRIVATE).contains(PREFS_NAME);
    }
    public static boolean getBoolean(Context context,String key,boolean defautValue){
        return context.getSharedPreferences(PREFS_NAME,Context.MODE_PRIVATE).getBoolean(key,defautValue);
    }
    public static void putBoolean(Context context,String key,boolean value){
        context.getSharedPreferences(PREFS_NAME,Context.MODE_PRIVATE).edit().putBoolean(key,value).commit();
    }
    public static String getString(Context context,String key,String defautValue){
        return context.getSharedPreferences(PREFS_NAME,Context.MODE_PRIVATE).getString(key,defautValue);
    }
    public static void putString(Context context,String key,String value){
        context.getSharedPreferences(PREFS_NAME,Context.MODE_PRIVATE).edit().putString(key,value).commit();
    }

    public static int getInt(Context context,String key,int defautValue){
        return context.getSharedPreferences(PREFS_NAME,Context.MODE_PRIVATE).getInt(key,defautValue);
    }
    public static void putInt(Context context,String key,int value){
        context.getSharedPreferences(PREFS_NAME,Context.MODE_PRIVATE).edit().putInt(key,value).commit();
    }
}
