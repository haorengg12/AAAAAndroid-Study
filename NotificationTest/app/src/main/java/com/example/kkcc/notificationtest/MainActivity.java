package com.example.kkcc.notificationtest;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.NotificationCompat;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button sendNotice = (Button) findViewById(R.id.send_notice);
        sendNotice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, NotificationTest.class);
                PendingIntent pi = PendingIntent.getActivity(MainActivity.this, 0, intent, 0);
                NotificationManager manager = (NotificationManager) getSystemService(MainActivity.NOTIFICATION_SERVICE);
                Notification notification = new NotificationCompat.Builder(MainActivity.this)
                        .setContentTitle("This is content title")
//                        .setContentText("This is content text")
                        .setWhen(System.currentTimeMillis())
                        .setSmallIcon(R.mipmap.ic_launcher)
                        .setLargeIcon(BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher))
                        .setContentIntent(pi)
                        .setAutoCancel(true)//点击删除
//                        .setSound(Uri.fromFile(new File("/system/media/audio/ringtones/Luna.ogg")))//声音
//                        .setVibrate(new long[]{0, 1000, 1000, 1000})//Vibrate
//                        .setLights(Color.GREEN, 1000, 1000)//LED
                        .setDefaults(NotificationCompat.DEFAULT_ALL)
                        .setStyle(new NotificationCompat.BigTextStyle().bigText("This is content textThis is" +
                                " content textThis is content " +
                                "textThis is content textThis is c" +
                                "ontent textThis is content text"))
                        .setStyle(new NotificationCompat.BigPictureStyle().bigPicture(BitmapFactory
                                .decodeResource(getResources(), R.drawable.big_image)))//BigImage
                        .setPriority(NotificationCompat.PRIORITY_MAX)//弹窗
                        .build();
                manager.notify(1, notification);
            }
        });
    }
}
