package com.wushanfei.stepapp;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.media.MediaRecorder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.Display;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.LinearLayout;

import com.wushanfei.stepapp.views.MarqueeAlwaysTextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, View.OnLongClickListener {
    private Button mBtnTest;
    private LinearLayout mLinarLayout;

    MarqueeAlwaysTextView  mMarqueeAlwaysTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mBtnTest = findViewById(R.id.btn_test);
        mBtnTest.setOnClickListener(this);

        mLinarLayout = findViewById(R.id.linerlayout_test);
        mLinarLayout.setGravity(Gravity.CENTER_VERTICAL | Gravity.START);

        mMarqueeAlwaysTextView = findViewById(R.id.line1);
        mMarqueeAlwaysTextView.setOnLongClickListener(this);

        mBtnTest.setEllipsize(TextUtils.TruncateAt.START);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        final int action = event.getAction();
        switch (action) {
            case MotionEvent.ACTION_DOWN:
                break;
            case MotionEvent.ACTION_UP:
            case MotionEvent.ACTION_CANCEL:
                break;
            default:
                break;
        }
        return super.onTouchEvent(event);
    }

    @Override
    public void onClick(View v) {
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
        return false;
    }

    interface FooterMobileCallBack{
        void addMobileIconBySlot(String slot);
        void onSetMobileIcon(String slot);
        interface test{}
    }
    private FooterMobileCallBack  mFooterMobileCallBack;

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        int[] location = new int[2] ;
        mMarqueeAlwaysTextView.getLocationInWindow(location);
        Log.i("wushanfei","keyCode11: "+keyCode);
        Log.i("wushanfei","top: "+mMarqueeAlwaysTextView.getTop());
        Log.i("wushanfei","X: "+mMarqueeAlwaysTextView.getX());
        Log.i("wushanfei","Y: "+mMarqueeAlwaysTextView.getY());
        Log.i("wushanfei","X1: "+location[0]);
        Log.i("wushanfei","Y1: "+location[1]);
        MediaRecorder recorder = null;
        recorder.stop();
        return super.onKeyDown(keyCode, event);
    }

    @Override
    public boolean dispatchKeyEvent(KeyEvent event) {
        Log.i("wushanfei","super.dispatchKeyEvent(event): "+super.dispatchKeyEvent(event));

        return super.dispatchKeyEvent(event);
    }
    /*
    * animator
    * */
    Animator animator ;
}
