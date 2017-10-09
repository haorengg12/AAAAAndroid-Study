package com.example.kk;

import android.app.Activity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 黄黄k on 2017-09-25.
 */

public class ActivityCollector {
    public static List<Activity> activities = new ArrayList<>();

    public static void addActivity(Activity activity) {
        activities.add(activity);
    }

    public static void removeActivity(Activity activity) {
        activities.remove(activity);

    }

    public static void finishAll() {
        for (Activity activity : activities) {
            if (!activity.isFinishing()) {
                activity.finish();
            }
        }
    }//直接退出程序
}
