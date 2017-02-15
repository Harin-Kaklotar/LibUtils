package com.codyy.lib.utils;

import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import static android.widget.Toast.LENGTH_SHORT;


/**
 * created by lijian 2016/12/26
 */
public class ToastUtil {
    private static Toast toast;

    public static void show(String text) {
        show(text, LENGTH_SHORT);
    }

    public static void show(final String text, int length) {
        if (Utils.getContext() == null) return;
        if (toast == null) {
            toast = new Toast(Utils.getContext().getApplicationContext());
            View view = LayoutInflater.from(Utils.getContext()).inflate(R.layout.toast_layout, null);
            TextView textView = (TextView) view.findViewById(R.id.toast_text);
            textView.setText(text);
            toast.setGravity(Gravity.CENTER, 0, 0);
            toast.setDuration(length);
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
