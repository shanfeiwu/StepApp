package com.wushanfei.stepapp.utils;

//import com.mediatek.camera.R;

import android.view.View;

import java.util.HashMap;
import java.util.Map;

/*
 *Create by wushanfei
 *on 2020/11/5
 */
public class CamerUILayoutValuesUtil {
    /*
    public static final int cameraUiRoot = R.id.camera_ui_root;
    public static final int transparentBackgroundView = R.id.transparent_background_view;
    public static final int facebeautyIndicator = R.id.facebeauty_indicator;
    public static final int topBar = R.id.top_bar;
    public static final int effctsBg = R.id.effcts_bg;
    public static Map<Integer, EntryViewPosition> mEntryViewPositionValues = new HashMap<>();

    public static class EntryViewPosition {
        private int positionX = 0;
        private int positionY = 0;
        private int width = 0;
        private int height = 0;
        private int paddingBottom = 0;
        private int paddingTop = 0;

        public EntryViewPosition(int positionX, int positionY, int width, int height) {
            this.positionX = positionX;
            this.positionY = positionY;
            this.width = width;
            this.height = height;
        }

        public EntryViewPosition(int positionX, int positionY, int width, int height, int paddingBottom, int paddingTop) {
            this.positionX = positionX;
            this.positionY = positionY;
            this.width = width;
            this.height = height;
            this.paddingBottom = paddingBottom;
            this.paddingTop = paddingTop;
        }

        public int getPositionX() {
            return positionX;
        }

        public void setPositionX(int positionX) {
            this.positionX = positionX;
        }

        public int getPositionY() {
            return positionY;
        }

        public void setPositionY(int positionY) {
            this.positionY = positionY;
        }

        public int getWidth() {
            return width;
        }

        public void setWidth(int width) {
            this.width = width;
        }

        public int getHeight() {
            return height;
        }

        public void setHeight(int height) {
            this.height = height;
        }

        public int getPaddingBottom() {
            return paddingBottom;
        }

        public void setPaddingBottom(int paddingBottom) {
            this.paddingBottom = paddingBottom;
        }

        public int getPaddingTop() {
            return paddingTop;
        }

        public void setPaddingTop(int paddingTop) {
            this.paddingTop = paddingTop;
        }
    }

    public static void putValue(int key,EntryViewPosition entryViewPosition){
        if(entryViewPosition != null){
            mEntryViewPositionValues.put(key,entryViewPosition);
        }
    }

    public static EntryViewPosition getValue(int key){
        return mEntryViewPositionValues.get(key);
    }
    */

    public static int[] CameraUIRootLocation = new int[2] ;
    public static void setCameraUIRootLocation(View cameraUiRoot) {
        if(cameraUiRoot != null){
            cameraUiRoot.getLocationInWindow(CameraUIRootLocation);
        }
    }
}
