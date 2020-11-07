package com.wushanfei.stepapp.utils;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Matrix;
import android.util.Size;

/*
 *Create by wushanfei
 *on 2020/9/8
 */
public class TestUtils {
    public Matrix calculateSurfaceHolderTransform(int screenWitch,int screenHight,int previewWith,int previewHight) {
        int viewHeight = screenHight;
        int viewWidth = screenWitch;
        int cameraHeight = previewWith;
        int cameraWidth = previewHight;
        float ratioPreview = (float) cameraWidth / cameraHeight;
        float ratioView = (float) viewWidth / viewHeight;
        float scaleX, scaleY;
        if (ratioView < ratioPreview) {
            scaleX = ratioPreview / ratioView;
            scaleY = 1;
        } else {
            scaleX = 1;
            scaleY = ratioView / ratioPreview;
        }
        float scaledWidth = viewWidth * scaleX;
        float scaledHeight = viewHeight * scaleY;
        float dx = (viewWidth - scaledWidth) / 2;
        float dy = (viewHeight - scaledHeight) / 2;
        Matrix matrix = new Matrix();
        matrix.postScale(scaleX, scaleY);
        matrix.postTranslate(dx, dy);

        int realSurfaceWidth = 0;
        int realSurfaceHight = 0;
        if(viewHeight < viewWidth){
            realSurfaceWidth = (int) (1.0 * viewHeight * cameraWidth / cameraHeight);
            realSurfaceHight = viewHeight;
        }else{
            realSurfaceWidth = viewWidth;
            realSurfaceHight = (int) (1.0 * viewWidth * cameraHeight / cameraWidth);
        }

        return matrix;
    }
    class PreviewParam{
        private Matrix mMatrix;
        private Size  mSize;

        public Matrix getMatrix() {
            return mMatrix;
        }

        public void setMatrix(Matrix mMatrix) {
            this.mMatrix = mMatrix;
        }

        public Size getSize() {
            return mSize;
        }

        public void setSize(Size mSize) {
            this.mSize = mSize;
        }
    }

    private int getStatusBarHeight(Context context) {
        Resources resources = context.getResources();
        int resourceId = resources.getIdentifier("status_bar_height", "dimen","android");
        int height = resources.getDimensionPixelSize(resourceId);
        return height;
    }

    private int getNavigationBarHeight(Context context) {
        Resources resources = context.getResources();
        int resourceId = resources.getIdentifier("navigation_bar_height","dimen", "android");
        int height = resources.getDimensionPixelSize(resourceId);
        return height;
    }




}
