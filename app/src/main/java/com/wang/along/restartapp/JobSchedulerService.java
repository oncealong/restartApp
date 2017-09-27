package com.wang.along.restartapp;

import android.app.PendingIntent;
import android.app.job.JobParameters;
import android.app.job.JobService;
import android.content.Intent;
import android.os.Build;
import android.os.PersistableBundle;
import android.support.annotation.RequiresApi;

/**
 * Created by alongwang on 2017/9/22.
 */

@RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
public class JobSchedulerService extends JobService {
    @Override
    public boolean onStartJob(JobParameters jobParameters) {
        startMainServerce();
        jobFinished(jobParameters,false);
        return false;
    }

    private void startMainServerce() {
        startActivity(new Intent(this,MainActivity.class),null);
    }

    @Override
    public boolean onStopJob(JobParameters jobParameters) {
        return false;
    }

    @Override
    public void onTaskRemoved(Intent rootIntent) {
    }
}
