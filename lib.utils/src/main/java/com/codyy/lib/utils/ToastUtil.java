package com.codyy.lib.utils;

import android.content.Context;
import android.graphics.PixelFormat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;


/**
 * created by lijian 2016/12/26
 */
public class ToastUtil {
    public static final int LENGTH_SHORT = 0;
    public static final int LENGTH_LONG = 1;
    private static final int LONG_DELAY = 3500;
    private static final int SHORT_DELAY = 2000;
    private static WindowManager sWindowManager;
    static View view = null;
    static TextView textView = null;

    static void init() {
        sWindowManager = (WindowManager) Utils.getContext().getApplicationContext().getSystemService(Context.WINDOW_SERVICE);
        view = LayoutInflater.from(Utils.getContext()).inflate(R.layout.toast_layout, null);
        textView = (TextView) view.findViewById(R.id.toast_text);
    }

    public static void show(String text) {
        if (sWindowManager == null) init();
        show(text, LENGTH_SHORT);
    }

    public static void show(final String text, int length) {
        if (sWindowManager == null) init();
        if (view.getParent() != null) {
            sWindowManager.removeView(view);
        }
        textView.setText(text);
        WindowManager.LayoutParams lp = new WindowManager.LayoutParams();
        lp.type = WindowManager.LayoutParams.TYPE_TOAST;
        lp.flags = WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE | WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE; //设置这个 window 不可点击，不会获取焦点，这样可以不干扰背后的 Activity 的交互。
        lp.width = WindowManager.LayoutParams.WRAP_CONTENT;
        lp.height = WindowManager.LayoutParams.WRAP_CONTENT;
        lp.format = PixelFormat.TRANSLUCENT; //这样可以保证 Window 的背景是透明的，不然背景可能是黑色或者白色。
        lp.windowAnimations = android.R.style.Animation_Toast; //使用官方原生的 Toast 动画效果

        sWindowManager.addView(view, lp);
        view.postDelayed(new Runnable() { // 指定时间后，取消 Toast 显示
            @Override
            public void run() {
                if(view.getParent()!=null) {
                    sWindowManager.removeView(view);
                }
            }
        }, length == LENGTH_SHORT ? SHORT_DELAY : LONG_DELAY);
    }

}
