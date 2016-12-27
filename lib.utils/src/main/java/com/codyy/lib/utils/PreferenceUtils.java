package com.codyy.lib.utils;

import android.content.Context;
import android.content.SharedPreferences;


/**
 * PreferenceUtils
 * created by eachann on 2015/07/30
 */
public class PreferenceUtils {
    private SharedPreferences sharedPreferences;

    private SharedPreferences.Editor shareEditor;

    private volatile static PreferenceUtils preferenceUtils = null;

    public static final String PERSON_MENU_KEY = "PERSON_MENU_KEY";
    public static final String PREFERENCE_FILE_NAME = "osp.settings";
    public static final String PREFERENCE_IS_FIRST = "osp.is.first";

    private PreferenceUtils(Context context, String name) {
        sharedPreferences = context.getSharedPreferences(name, Context.MODE_PRIVATE);
        shareEditor = sharedPreferences.edit();
    }

    public static PreferenceUtils getInstance(Context context, String name) {
        if (preferenceUtils == null) {
            synchronized (PreferenceUtils.class) {
                if (preferenceUtils == null) {
                    preferenceUtils = new PreferenceUtils(context.getApplicationContext(), name);
                }
            }
        }
        return preferenceUtils;
    }

    public String getStringParam(String key) {
        return getStringParam(key, "");
    }

    public String getStringParam(String key, String defaultString) {
        return sharedPreferences.getString(key, defaultString);
    }

    public void saveParam(String key, String value) {
        shareEditor.putString(key, value).commit();
    }

    public boolean getBooleanParam(String key) {
        return getBooleanParam(key, false);
    }

    public boolean getBooleanParam(String key, boolean defaultBool) {
        return sharedPreferences.getBoolean(key, defaultBool);
    }

    public void saveParam(String key, boolean value) {
        shareEditor.putBoolean(key, value).commit();
    }

    public int getIntParam(String key) {
        return getIntParam(key, 0);
    }

    public int getIntParam(String key, int defaultInt) {
        return sharedPreferences.getInt(key, defaultInt);
    }

    public void saveParam(String key, int value) {
        shareEditor.putInt(key, value).commit();
    }

    public long getLongParam(String key) {
        return getLongParam(key, 0);
    }

    public long getLongParam(String key, long defaultInt) {
        return sharedPreferences.getLong(key, defaultInt);
    }

    public void saveParam(String key, long value) {
        shareEditor.putLong(key, value).commit();
    }

    public void clearParam() {
        shareEditor.clear();
        shareEditor.commit();
    }
}
