package com.example.medicine_tracker;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.provider.Settings;

import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

public class AlarmReceiver_night extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent3) {
        MediaPlayer mp= MediaPlayer.create(context, Settings.System.DEFAULT_ALARM_ALERT_URI);
        mp.setLooping(true);
        mp.start();

        Intent i3=new Intent(context,NotificationActivity.class);
        intent3.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        PendingIntent pendingIntent2=PendingIntent.getActivity(context,3,i3,PendingIntent.FLAG_MUTABLE);

        NotificationCompat.Builder builder=new NotificationCompat.Builder(context,"Medicine Tracker")
                .setSmallIcon(R.drawable.ic_launcher_background)
                .setContentTitle("Medicine Tracker Notification3")
                .setContentText("Time to take medicine")
                .setAutoCancel(true)
                .setDefaults(NotificationCompat.DEFAULT_ALL)
                .setPriority(NotificationCompat.PRIORITY_HIGH)
                .setContentIntent(pendingIntent2);

        NotificationManagerCompat notificationManagerCompat=NotificationManagerCompat.from(context);
        notificationManagerCompat.notify(123,builder.build());
    }
}
