package com.recepinanc.pills;

import android.app.Application;
import android.content.Intent;

/**
 * Created by recepinanc on 10/12/2016.with <3
 */
public class Pill extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        startService(new Intent(getApplicationContext(), AlarmService.class));
    }
}