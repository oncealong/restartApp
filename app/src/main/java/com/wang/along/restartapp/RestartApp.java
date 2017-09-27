package com.wang.along.restartapp;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.PersistableBundle;
import android.support.annotation.RequiresApi;

import static android.content.Context.JOB_SCHEDULER_SERVICE;

/**
 * Created by alongwang on 2017/9/22.
 */

public class RestartApp {
    public static void restartThroughPendingIntentAlarmManager(Context context) {
        // AlarmManager在API19以上执行时间变得不准确
        int delayTime = 1000;
        Context currentActivity = context;
        Intent intent = new Intent(currentActivity, MainActivity.class);
        AlarmManager mAlarmManager = (AlarmManager) currentActivity.getSystemService(Context.ALARM_SERVICE);
        PendingIntent restartIntent = PendingIntent.getActivity(currentActivity, 0, intent, PendingIntent.FLAG_CANCEL_CURRENT);
        mAlarmManager.set(AlarmManager.RTC, System.currentTimeMillis() + delayTime, restartIntent); // 1s后重启应用
        System.exit(0);
    }

    public static void restartThroughIntentCompatMakeRestartActivityTask(Context context) {
        Context currentActivity = context;
        Intent intent = new Intent(currentActivity, MainActivity.class);
        Intent restartIntent = Intent.makeRestartActivityTask(intent.getComponent());
        currentActivity.startActivity(restartIntent);
        System.exit(0);
    }

    public static void restartThroughPendingIntentJobScheduler(Context context) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            restartThroughPendingIntentJobSchedulerInternal(context);
        } else {
            // 低版本做个回退
            restartThroughPendingIntentAlarmManager(context);
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    private static void restartThroughPendingIntentJobSchedulerInternal(Context context) {
        int delayTimeMin = 1000;
        int delayTimeMax = 2000;
        JobInfo.Builder jobInfoBuild = new JobInfo.Builder(0, new ComponentName(context, JobSchedulerService.class));
        jobInfoBuild.setMinimumLatency(delayTimeMin);
        jobInfoBuild.setOverrideDeadline(delayTimeMax);
        JobScheduler jobScheduler = (JobScheduler) context.getSystemService(JOB_SCHEDULER_SERVICE);
        jobScheduler.schedule(jobInfoBuild.build());
        System.exit(0);
    }

}
