package com.wushanfei.stepapp.utils;

import android.os.Environment;
import android.util.Log;

import com.wushanfei.stepapp.BuildConfig;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/*
 *Create by wushanfei
 *on 2020/12/23
 */
public class LogUtil {
    private final static String LOG_FILE_NAME = "step_log.txt";
    private final static String TAG = "stepApp_";

    private static boolean isDebug(){
        return BuildConfig.DEBUG;
    }

    public static void writeToFile(String tag,String message){
        if(!isDebug()){
            return;
        }
        String needWriteMessage = tag + " : "+message;
        String fileName = Environment.getExternalStorageDirectory().getPath() + "/" + LOG_FILE_NAME;
        File file = new File(fileName);
        try {
            FileWriter fileWriter = new FileWriter(file,true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(needWriteMessage);
            bufferedWriter.newLine();
            bufferedWriter.close();
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void d(String tag,String message){
        if (!isDebug()){
            return;
        }
        Log.d(TAG+tag,message);
    }

    public static void i(String tag,String message){
        if (!isDebug()){
            return;
        }
        Log.i(TAG+tag,message);
    }

    public static void w(String tag,String message){
        if (!isDebug()){
            return;
        }
        Log.w(TAG+tag,message);
    }

    public static void v(String tag,String message){
        if (!isDebug()){
            return;
        }
        Log.v(TAG+tag,message);
    }

}
