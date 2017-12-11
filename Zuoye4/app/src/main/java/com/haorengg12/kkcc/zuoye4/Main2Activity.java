package com.haorengg12.kkcc.zuoye4;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;
import java.util.List;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class Main2Activity extends AppCompatActivity {
    private ImageView img;
    private TextView title2;
    private TextView article;
    private List<news> appList = new ArrayList<>();
    private List<news> ns = new ArrayList<>();
    private int textNum;
    private Toolbar toolbar2;
    private String iD;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        toolbar2 = (Toolbar) findViewById(R.id.toolbar2);
        setSupportActionBar(toolbar2);
        img = (ImageView) findViewById(R.id.image);
        title2 = (TextView) findViewById(R.id.title2);
        article = (TextView) findViewById(R.id.article);
        ActionBar actionBar = getSupportActionBar();
        Intent intent = getIntent();
        textNum = Integer.parseInt(intent.getStringExtra("textNum"));
        iD = intent.getStringExtra("textNum");
        switch (iD) {
            case "0":
                iD = "一";
                break;
            case "1":
                iD = "二";
                break;
            case "2":
                iD = "三";
                break;
            default:
                break;
        }
        if (actionBar != null) {
            actionBar.setTitle("新闻" + iD);
        }
        new Thread(new Runnable() {
            @Override
            public void run() {
                //开启一号子进程
                Message message = new Message();
                message.what = 1;
                handler.sendMessage(message);
            }
        }).start();
    }

    @SuppressLint("HandlerLeak")
    private Handler handler = new Handler() {
        public void handleMessage(Message msg) {
            //所有的回到主进程！
            switch (msg.what) {
                case 1:
                    sendRequestWithOkHttp();
                    break;
                case 2:
                    //刷新UI
                    title2.setText(appList.get(textNum).getTitle());
                    article.setText(appList.get(textNum).getArticle());
                    Glide.with(Main2Activity.this)
                            .load(appList.get(textNum).getPhoto())
                            .into(img);
                    break;
                default:
                    break;
            }
        }
    };

    private void parseJSONWithGSON(String jsonData) {
        Gson gson = new Gson();
        appList = gson.fromJson((jsonData), new TypeToken<List<news>>() {
        }.getType());
        new Thread(new Runnable() {
            @Override
            public void run() {
                //开启解析完成的二号子进程
                Message message = new Message();
                message.what = 2;
                handler.sendMessage(message);
            }
        }).start();
    }

    private void sendRequestWithOkHttp() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    OkHttpClient client = new OkHttpClient();
                    Request request = new Request.Builder()
                            .url("http://192.168.144.241/api/news.json")
                            .build();
                    Response response = client.newCall(request).execute();
                    String responseData = response.body().string();
                    parseJSONWithGSON(responseData);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
