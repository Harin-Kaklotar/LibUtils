/*
 * Copyright 2016, The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.codyy.lib.utils;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import java.util.List;

/**
 * This provides methods to help Activities load their UI.
 */
public class ActivityUtils {
    private ActivityUtils() {
        throw new UnsupportedOperationException("u can't instantiate me...");
    }

    /**
     * The {@code fragment} is added to the container view with id {@code frameId}. The operation is
     * performed by the {@code fragmentManager}.
     */
    public static void addFragmentToActivity(@NonNull FragmentManager fragmentManager,
                                             @NonNull Fragment fragment, int frameId, String tag) {
        FragmentTransaction transaction = fragmentManager.beginTransaction();
//        transaction.add(frameId, fragment);
        transaction.replace(frameId, fragment, tag);
//        transaction.commit();
        transaction.commitAllowingStateLoss();
    }

    /**
     * 判断是否存在Activity
     *
     * @param context     上下文
     * @param packageName 包名
     * @param className   activity全路径类名
     * @return {@code true}: 是<br>{@code false}: 否
     */
    public static boolean isActivityExists(Context context, String packageName, String className) {
        Intent intent = new Intent();
        intent.setClassName(packageName, className);
        return !(context.getPackageManager().resolveActivity(intent, 0) == null ||
                intent.resolveActivity(context.getPackageManager()) == null ||
                context.getPackageManager().queryIntentActivities(intent, 0).size() == 0);
    }

    /**
     * 打开Activity
     *
     * @param context     上下文
     * @param packageName 包名
     * @param className   全类名
     */
    public static void launchActivity(Context context, String packageName, String className) {
        launchActivity(context, packageName, className, null);
    }

    /**
     * 打开Activity
     *
     * @param context     上下文
     * @param packageName 包名
     * @param className   全类名
     * @param bundle      bundle
     */
    public static void launchActivity(Context context, String packageName, String className, Bundle bundle) {
        context.startActivity(IntentUtils.getComponentIntent(packageName, className, bundle));
    }

    /**
     * 获取launcher activity
     *
     * @param context     上下文
     * @param packageName 包名
     * @return launcher activity
     */
    public static String getLauncherActivity(Context context, String packageName) {
        Intent intent = new Intent(Intent.ACTION_MAIN, null);
        intent.addCategory(Intent.CATEGORY_LAUNCHER);
        PackageManager pm = context.getPackageManager();
        List<ResolveInfo> infos = pm.queryIntentActivities(intent, 0);
        for (ResolveInfo info : infos) {
            if (info.activityInfo.packageName.equals(packageName)) {
                return info.activityInfo.name;
            }
        }
        return "no " + packageName;
    }
}
