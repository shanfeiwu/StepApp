package com.wushanfei.stepapp.utils;

import com.wushanfei.stepapp.R;

import java.util.HashMap;
import java.util.Map;

/*
 *Create by wushanfei
 *on 2020/11/5
 */
public class CamerUILayoutValuesUtil {

    private static final int cameraUiRoot = R.id.center;
    private static final int transparentBackgroundView = R.id.center;
    private static final int facebeautyIndicator = R.id.center;
    private static final int topBar = R.id.center;
    private static Map<Integer, EntryViewPositions> mEntryViewPositionValues = new HashMap<>();

    class EntryViewPositions {
        private int positionX = 0;
        private int positionY = 0;
        private int width = 0;
        private int height = 0;
        private int paddingBottom = 0;
        private int paddingTop = 0;
    }

    public void putValue(int key,EntryViewPositions entryViewPositions){
        if(entryViewPositions != null){
            mEntryViewPositionValues.put(key,entryViewPositions);
        }
    }

    public EntryViewPositions getValue(int key){
        return mEntryViewPositionValues.get(key);
    }
}
