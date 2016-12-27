package com.codyy.lib.utils;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.support.annotation.DrawableRes;
import android.support.v4.content.ContextCompat;

/**
 * CompoundDrawablesUtil
 * Created by eachann on 2016/6/14.
 */
public class CompoundDrawablesUtil {
    public static Drawable getCompoundDrawables( @DrawableRes int id, float dpVal) {
        Drawable drawable = ContextCompat.getDrawable(Utils.getContext(), id);
        // 这一步必须要做,否则不会显示.
        int right =ConvertUtils.dp2px( dpVal);
        if (drawable != null) {
            drawable.setBounds(0, 0, right, right);
        }
        return drawable;
    }

    public static Drawable getCompoundDrawables(@DrawableRes int id, float width, float height) {
        Drawable drawable = ContextCompat.getDrawable(Utils.getContext(), id);
        // 这一步必须要做,否则不会显示.
        int right = ConvertUtils.dp2px( width);
        int bottom = ConvertUtils.dp2px( height);
        if (drawable != null) {
            drawable.setBounds(0, 0, right, bottom);
        }
        return drawable;
    }

    public static Drawable getCompoundDrawables() {
        Drawable drawable = new ColorDrawable(Color.TRANSPARENT);
        // 这一步必须要做,否则不会显示.
        int right = ConvertUtils.dp2px(20f);
        if (drawable != null) {
            drawable.setBounds(0, 0, right, right);
        }
        return drawable;
    }
}
