package com.recepinanc.pills;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.widget.Toast;

/**
 * Created by recepinanc on 10/12/2016.with <3
 */
public class AlarmService extends Service {

    private static final String TAG = "ALARM_SERVICE";

    @Override
    public void onCreate() {
        super.onCreate();
        Toast.makeText(AlarmService.this, TAG + ":: Service is created.", Toast.LENGTH_SHORT).show();
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Toast.makeText(AlarmService.this, TAG + ":: Service is destroyedo.", Toast.LENGTH_SHORT).show();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Toast.makeText(this, TAG + "Service Started", Toast.LENGTH_LONG).show();
        return START_STICKY;
    }
}
