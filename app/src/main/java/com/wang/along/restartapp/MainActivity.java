package com.wang.along.restartapp;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnPendingIntentAlarmManager = (Button) findViewById(R.id.btn_pendingIntent_alarmManager);
        btnPendingIntentAlarmManager.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                RestartApp.restartThroughPendingIntentAlarmManager(MainActivity.this);
            }
        });
        Button btnIntentCompat = (Button) findViewById(R.id.btn_intentCompat_makeRestartActivityTask);
        btnIntentCompat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                RestartApp.restartThroughIntentCompatMakeRestartActivityTask(MainActivity.this);
            }


        });
        Button btnPendingIntentJobSchduler = (Button) findViewById(R.id.btn_pendingIntent_jobScheduler);
        btnPendingIntentJobSchduler.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                RestartApp.restartThroughPendingIntentJobScheduler(MainActivity.this);
            }
        });
    }

}
