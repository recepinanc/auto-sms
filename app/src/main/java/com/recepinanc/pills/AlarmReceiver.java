package com.recepinanc.pills;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.telephony.SmsManager;
import android.widget.Toast;

import java.util.Calendar;

/**
 * onReceive will be trigger everyday on certain times
 * <p/>
 * Created by recepinanc on 10/12/2016.with <3
 */
public class AlarmReceiver extends BroadcastReceiver {

    private AlarmManager alarmManager;
    private PendingIntent alarmIntent;

    @Override
    public void onReceive(Context context, Intent intent) {
        SmsManager smsManager = SmsManager.getDefault();
        // CHANGE ${number} to the number you'll send, ${message} to the message you want to send
        smsManager.sendTextMessage("number", null, "message", null, null);
        Toast.makeText(context, "Service is ready!", Toast.LENGTH_LONG).show();
    }

    public void setAlarm(Context context) {
        alarmManager = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);
        Intent intent = new Intent(context, AlarmReceiver.class);
        alarmIntent = PendingIntent.getBroadcast(context, 0, intent, 0);

        // Set the alarm to start at approximately 8:00 a.m.
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(System.currentTimeMillis());
        calendar.set(Calendar.HOUR_OF_DAY, 8);

        // With setInexactRepeating(), you have to use one of the AlarmManager interval
        // constants--in this case, AlarmManager.INTERVAL__HALF_DAY.
        // Alarm will be fired each 12 hour. In this case, in 8 a.m. and p.m.
        alarmManager.setInexactRepeating(AlarmManager.RTC_WAKEUP, System.currentTimeMillis(),
                AlarmManager.INTERVAL_HALF_DAY, alarmIntent);
    }
}
