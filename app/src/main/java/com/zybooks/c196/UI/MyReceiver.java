package com.zybooks.c196.UI;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.widget.Toast;

import com.zybooks.c196.R;

import androidx.annotation.RequiresApi;
import androidx.core.app.NotificationCompat;

public class MyReceiver extends BroadcastReceiver {
    String CHANNEL_ID = "test";
    static int notificationID;

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    public void onReceive(Context context, Intent intent) {
        // indicates preparing to send notification
        Toast.makeText(context, intent.getStringExtra("key"), Toast.LENGTH_LONG).show();
        createNotificationChannel(context,CHANNEL_ID); // id of test, with description
        // builds the notification
        Notification n = new NotificationCompat.Builder(context,CHANNEL_ID)
                .setSmallIcon(R.drawable.ic_launcher_foreground)
                .setContentText(intent.getStringExtra("key"))
                .setContentTitle("Notification Test").build();
        NotificationManager notiMgr = (NotificationManager) context.getSystemService(context.NOTIFICATION_SERVICE);
        notiMgr.notify(notificationID,n);
        // TODO: This method is called when the BroadcastReceiver is receiving
        // an Intent broadcast.
        throw new UnsupportedOperationException("Not yet implemented");
    }


    @RequiresApi(api = Build.VERSION_CODES.O)
    private void createNotificationChannel(Context context, String CHANNEL_ID){
        CharSequence name = context.getResources().getString(R.string.channel_name);
        int importance = NotificationManager.IMPORTANCE_DEFAULT;
        NotificationChannel channel = new NotificationChannel(CHANNEL_ID,name,importance);
        channel.setDescription(String.valueOf(R.string.channel_description));
        NotificationManager notiMgr = context.getSystemService(NotificationManager.class);
        notiMgr.createNotificationChannel(channel);
        // make sure channel id, name and description are in your resources
        // give channel name a resource value. If left blank, will not work properly
        // checkunder res/values
    }
}