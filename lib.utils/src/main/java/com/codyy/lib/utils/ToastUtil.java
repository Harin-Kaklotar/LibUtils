package com.codyy.lib.utils;

import android.content.Context;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;


/**
 * created by lijian 2016/12/26
 */
public class ToastUtil {
    private static Toast toast;

    public static void showToast(Context context, String text) {
        showToast(context, text, Toast.LENGTH_SHORT);
    }

    public static void showToast(Context context, String text, int duration) {
        if (context == null) return;
        if (toast == null) {
            toast = new Toast(context.getApplicationContext());
            View view = LayoutInflater.from(context).inflate(R.layout.toast_layout, null);
            TextView textView = (TextView) view.findViewById(R.id.toast_text);
            textView.setText(text);
            toast.setGravity(Gravity.CENTER, 0, 0);
            toast.setDuration(duration);
            toast.setView(view);
        } else {
            View view = toast.getView();
            TextView textView = (TextView) view.findViewById(R.id.toast_text);
            textView.setText(text);
            toast.setView(view);
        }
        toast.show();
    }

}
