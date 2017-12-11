package com.haorengg12.kkcc.zuoye4;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;
import java.util.List;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {
    private List<news> ns = new ArrayList<>();
    private List<news> appList = new ArrayList<>();
    private listAdapter adapter;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        adapter = new listAdapter(MainActivity.this, R.layout.list_item, ns);
        ListView listView = (ListView) findViewById(R.id.list_view);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //点击事件
                news nns = ns.get(position);
                Intent intent = new Intent(MainActivity.this, Main2Activity.class);
                intent.putExtra("textNum", String.valueOf(id));
                startActivity(intent);
            }
        });
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
                    initFruits();
                    break;
                default:
                    break;
            }
        }
    };

    private void initFruits() {
        //获取新闻标题
        for (news nnns : appList) {
            news nnkk = new news();
            nnkk.setTitle("       " + nnns.getTitle());
            ns.add(nnkk);
        }
        adapter.notifyDataSetChanged();
    }

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
