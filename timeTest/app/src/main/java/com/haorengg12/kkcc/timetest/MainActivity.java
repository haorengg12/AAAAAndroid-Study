package com.haorengg12.kkcc.timetest;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.Calendar;
import java.util.TimeZone;
import java.util.Timer;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    public static final int CASE_TIME = 1;
    private TextView sandiegoTime;
    private TextView chinaTime;
    private Timer mTimer;
    private String hour_cn;
    private String min_cn;
    private String sec_cn;
    private String hour_sa;
    private String min_sa;
    private String sec_sa;
    private LinearLayout cnLayout;
    private LinearLayout saLayout;
    private com.haorengg12.kkcc.timetest.ClockView cnTime;
    private com.haorengg12.kkcc.timetest.ClockView2 saTime;
    //两种写法
    private Handler handler = new Handler() {
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case CASE_TIME:
                    setChinaTime();
                    setSandiaTime();
                    break;
                default:
                    break;
            }
        }
    };
//    private Handler updateHandler = new Handler() {
//        @Override
//        public void handleMessage(Message msg) {
//            switch (msg.what) {
//                case CASE_TIME:
//                    setChinaTime();
//                    setSandiaTime();
//                    break;
//                default:
//                    break;
//            }
//        }
//    };
//    public MainActivity() {
//        init();
//    }
//    private void init() {
//        timeThread.start();
//    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sandiegoTime = (TextView) findViewById(R.id.sandiaTime);
        chinaTime = (TextView) findViewById(R.id.chinaTime);
        cnLayout = (LinearLayout) findViewById(R.id.cn_layout);
        cnLayout.setOnClickListener(this);
        saLayout = (LinearLayout) findViewById(R.id.san_layout);
        saLayout.setOnClickListener(this);
        setChinaTime();
        setSandiaTime();
        cnTime = (com.haorengg12.kkcc.timetest.ClockView) findViewById(R.id.cn_time);
        saTime = (com.haorengg12.kkcc.timetest.ClockView2) findViewById(R.id.sa_time);
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    while (true) {
                        // handler.sendEmptyMessage(CASE_TIME);
                        Message message = new Message();
                        message.what = CASE_TIME;
                        handler.sendMessage(message);
                        Thread.sleep(1);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    @SuppressLint("SetTextI18n")
    public void setChinaTime() {
        //设置中国时间
        Calendar cnCalendar = Calendar.getInstance();
        cnCalendar.setTimeZone(TimeZone.getTimeZone("GMT+8:00"));//China
        hour_cn = String.valueOf(cnCalendar.get(Calendar.HOUR_OF_DAY));
        min_cn = String.valueOf(cnCalendar.get(Calendar.MINUTE));
        sec_cn = String.valueOf(cnCalendar.get(Calendar.SECOND));
        if (hour_cn.length() == 1) {
            hour_cn = 0 + hour_cn;
        }
        if (min_cn.length() == 1) {
            min_cn = 0 + min_cn;
        }
        if (sec_cn.length() == 1) {
            sec_cn = 0 + sec_cn;
        }
        chinaTime.setText(hour_cn + ":" + min_cn + ":" + sec_cn);
    }

    @SuppressLint("SetTextI18n")
    public void setSandiaTime() {
        //设置圣地亚哥时间
        Calendar saCalendar = Calendar.getInstance();
        saCalendar.setTimeZone(TimeZone.getTimeZone("GMT-8:00"));//San Diego
        hour_sa = String.valueOf(saCalendar.get(Calendar.HOUR_OF_DAY));
        min_sa = String.valueOf(saCalendar.get(Calendar.MINUTE));
        sec_sa = String.valueOf(saCalendar.get(Calendar.SECOND));
        if (hour_sa.length() == 1) {
            hour_sa = 0 + hour_sa;
        }
        if (min_sa.length() == 1) {
            min_sa = 0 + min_sa;
        }
        if (sec_sa.length() == 1) {
            sec_sa = 0 + sec_sa;
        }
        sandiegoTime.setText(hour_sa + ":" + min_sa + ":" + sec_sa);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.cn_layout:
                saTime.setVisibility(View.GONE);
                cnTime.setVisibility(View.VISIBLE);
                break;
            case R.id.san_layout:
                cnTime.setVisibility(View.GONE);
                saTime.setVisibility(View.VISIBLE);
                break;
            default:
                break;
        }
    }
}
