package com.lyf.androiddemo.eventdispatch;

import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.LinearLayout;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

public class MyLinearLayout extends LinearLayout {
    public MyLinearLayout(Context context) {
        super(context);
    }

    public MyLinearLayout(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public MyLinearLayout(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public MyLinearLayout(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        System.out.println("ViewGroup 的 dispatchTouchEvent "  + ev.getAction());
        return super.dispatchTouchEvent(ev);
//        return true;
//        return false;
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        System.out.println("ViewGroup 的 onInterceptTouchEvent "  + ev.getAction());
//        return super.onInterceptTouchEvent(ev);
        return true;
//        return false;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        System.out.println("ViewGroup 的 onTouchEvent "  + event.getAction());
//        return super.onTouchEvent(event);
        return true;
//        return false;
    }
}
