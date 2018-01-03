package com.skywalker.idouban.collector;

import android.app.Activity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by apex100528 on 2018/1/3.
 * 此类用于管理Activity，主要为 添加、移除、结束所有Activity三个方法
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
    }
}
