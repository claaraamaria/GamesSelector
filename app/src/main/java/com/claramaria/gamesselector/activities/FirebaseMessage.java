package com.claramaria.gamesselector.activities;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.media.RingtoneManager;
import android.net.Uri;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.core.app.NotificationCompat;

import com.claramaria.gamesselector.MainActivity;
import com.claramaria.gamesselector.R;
import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

public class FirebaseMessage  extends FirebaseMessagingService {
    private static final String TAG = "MsgService";

    @Override
    public void onMessageReceived(@NonNull RemoteMessage remoteMessage) {
        Log.d(TAG, "FROM:"+remoteMessage.getFrom());

        if(remoteMessage.getData().size() > 0 ){
            Log.d(TAG, "MessageData: "+remoteMessage.getData());
            Intent intent = new Intent(this, MainActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            PendingIntent pendingIntent = PendingIntent.getActivity(this, 0/*Request code*/, intent, PendingIntent.FLAG_ONE_SHOT);

            Uri notificationSound = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);

            NotificationCompat.Builder notifBuilder = new NotificationCompat.Builder(this)
                    .setSmallIcon(R.mipmap.ic_launcher)
                    .setContentTitle("SNS Message")
                    .setContentText(remoteMessage.getData().toString())
                    .setAutoCancel(true)
                    .setSound(notificationSound)
                    .setContentIntent(pendingIntent);

            NotificationManager notifyManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
            notifyManager.notify(0/*ID of notification*/, notifBuilder.build());
        }
    }
}
