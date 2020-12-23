package com.wushanfei.stepapp;

import android.animation.Animator;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.database.ContentObserver;
import android.database.Cursor;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.provider.MediaStore;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.Display;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowInsets;
import android.view.WindowInsetsController;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.SimpleCursorTreeAdapter;

import com.wushanfei.stepapp.receiver.WidgetButtonIntentReceiver;
import com.wushanfei.stepapp.views.MarqueeAlwaysTextView;
import com.wushanfei.stepapp.views.MyEditText;
import com.wushanfei.stepapp.views.OverLapVolteIconContainer;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, View.OnLongClickListener{
    private Button mBtnTest;
    private LinearLayout mLinarLayout;
    private LinearLayout mLinarLayoutContainer;
    private MyEditText mEditText ;

    MarqueeAlwaysTextView  mMarqueeAlwaysTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
            final WindowInsetsController insetsController = getWindow().getInsetsController();
            if (insetsController != null) {
                insetsController.hide(WindowInsets.Type.statusBars());
            }
        } else {
            getWindow().setFlags(
                    WindowManager.LayoutParams.FLAG_FULLSCREEN,
                    WindowManager.LayoutParams.FLAG_FULLSCREEN
            );
        }

        mBtnTest = findViewById(R.id.btn_test);
        mBtnTest.setOnClickListener(this);

        mEditText = findViewById(R.id.my_main_et);

        mLinarLayout = findViewById(R.id.linerlayout_test);
        mLinarLayout.setGravity(Gravity.CENTER_VERTICAL | Gravity.START);

        mLinarLayoutContainer = findViewById(R.id.linearLayout_container);
        OverLapVolteIconContainer volteIconLinearlayout = OverLapVolteIconContainer.fromContext(this);
        mLinarLayoutContainer.removeView(volteIconLinearlayout);
        mLinarLayoutContainer.addView(volteIconLinearlayout,1);
        //mLinarLayoutContainer.addView(volteIconLinearlayout);


        mMarqueeAlwaysTextView = findViewById(R.id.line1);
        mMarqueeAlwaysTextView.setOnLongClickListener(this);

        mBtnTest.setEllipsize(TextUtils.TruncateAt.START);
        final WindowInsetsController insetsController = getWindow().getInsetsController();
        Log.i("wushanfei","onCreate-insetsController: "+insetsController);

        AppWidgetManager appWidgetManager = AppWidgetManager.getInstance(MainActivity.this);
        int[] appWidgetIds = appWidgetManager.getAppWidgetIds(new ComponentName(MainActivity.this,WidgetButtonIntentReceiver.class));

        Canvas canvas = null;
        canvas.isHardwareAccelerated()
    }

    @Override
    protected void onResume() {
        super.onResume();
        final WindowInsetsController insetsController = getWindow().getInsetsController();
        Log.i("wushanfei","onResume-insetsController: "+insetsController);
        int[] location = new int[2] ;
        mMarqueeAlwaysTextView.getLocationInWindow(location);
    }

    @Override
    protected void onPause() {
        super.onPause();
        int[] location = new int[2] ;
        mMarqueeAlwaysTextView.getLocationInWindow(location);
        mMarqueeAlwaysTextView.getLocationOnScreen(location);

        Rect rect =new Rect();
        mMarqueeAlwaysTextView.getGlobalVisibleRect(rect);

        Log.i("wushanfei","top: "+mMarqueeAlwaysTextView.getTop());
        Log.i("wushanfei","X: "+mMarqueeAlwaysTextView.getX());
        Log.i("wushanfei","Y: "+mMarqueeAlwaysTextView.getY());
        Log.i("wushanfei","X1: "+location[0]);
        Log.i("wushanfei","Y1: "+location[1]);
        final WindowInsetsController insetsController = getWindow().getInsetsController();
        Log.i("wushanfei","onPause-insetsController: "+insetsController);
    }


    protected LinearLayout.LayoutParams onCreateLayoutParams() {
        return new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, 160);
    }

    @Override
    public void onClick(View v) {
        int[] location = new int[2] ;

        v.getLocationInWindow(location);
        Log.i("wushanfei","onclickX: "+location[0]);
        Log.i("wushanfei","onclickY: "+location[1]);
        getResources().getString(R.string.app_name);
        switch (v.getId()){
            case R.id.btn_test:
                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this,R.style.SettingsFragmentAlertDialog)
                        .setTitle("Restore defaults")
                        .setMessage("Are you sure to restore the default settings?")
                        .setPositiveButton("positive", new DialogInterface.OnClickListener() {

                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                            }
                        })
                        .setNegativeButton("nagative", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                            }
                        });
                        AlertDialog alertDialog = alertDialogBuilder.create();
                        alertDialog.show();
                        Window window = alertDialog.getWindow();
                        Display display =getWindowManager().getDefaultDisplay();
                        WindowManager.LayoutParams params = window.getAttributes() ;
                        params.width =(int) (display.getWidth()*0.94);
                        window.setAttributes(params);
                break;
            default:
                break;
        }
    }

    @Override
    public boolean onLongClick(View v) {
        Log.i("wushanfei","onLongClick");
        PendingIntent.getBroadcast(this,0,new Intent("sd"),PendingIntent.FLAG_UPDATE_CURRENT);
        Intent intent = null;
        intent.setPackage("com.android.music.WidgetButtonIntentReceiver");
        new ComponentName(this,MainActivity.class);
        return false;
    }

    interface FooterMobileCallBack{
        void addMobileIconBySlot(String slot);
        void onSetMobileIcon(String slot);
        interface test{}
    }
    private FooterMobileCallBack  mFooterMobileCallBack;

    @RequiresApi(api = 29)
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        int[] location = new int[2] ;
        mMarqueeAlwaysTextView.getLocationInWindow(location);
        Log.i("wushanfei","keyCode11: "+keyCode);
        Log.i("wushanfei","top: "+mMarqueeAlwaysTextView.getTop());
        Log.i("wushanfei","X: "+mMarqueeAlwaysTextView.getX());
        Log.i("wushanfei","Y: "+mMarqueeAlwaysTextView.getY());
        Log.i("wushanfei","X1: "+location[0]);
        Log.i("wushanfei","Y1: "+new String[]{"ts"});

        return super.onKeyDown(keyCode, event);
    }

    /*
    * animator
    * */
    Animator animator ;

    public interface VolteContainerVisityCallback{
        void setVolteContainerVisibility();

    }

    public final static int MSG_HIDE_SOFTBOARD = 1;

    private Handler mHandler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            Log.i("wushanfei","msg: "+msg.what);
            switch (msg.what){
                case MSG_HIDE_SOFTBOARD:
                    if(!mEditText.isShowingSoftKeyboard()){
                        hideSoftKeyboard(MainActivity.this);
                    }
                    break;
            }
        }
    };
    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        Log.i("wushanfei","dispatchTouchEvent");
        mEditText.setShowingSoftKeyboard(false);
        mHandler.sendEmptyMessageDelayed(MSG_HIDE_SOFTBOARD,300);
        Uri uri = MediaStore.Audio.Playlists.Members.getContentUri("external",
                114)
                .buildUpon()
                .appendEncodedPath(String.valueOf(10))
                .appendQueryParameter("move", "true")
                .build();
        return super.dispatchTouchEvent(ev);
    }


    public void hideSoftKeyboard(Activity activity) {
        View view = activity.getCurrentFocus();
        if (view != null) {
            InputMethodManager inputMethodManager = (InputMethodManager) activity.getSystemService(Activity.INPUT_METHOD_SERVICE);
            inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
        }
    }

}
