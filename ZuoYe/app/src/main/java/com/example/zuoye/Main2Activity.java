package com.example.zuoye;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        ActionBar actionBar = getSupportActionBar();//删除标题栏
        if (actionBar != null) {
            actionBar.hide();
        }
        ActivityCollector.addActivity(this);
//        Button titleButton2 = (Button) findViewById(R.id.title_return);
        Intent intent = getIntent();
        String data = intent.getStringExtra("extra_data");
        String dd = intent.getStringExtra("extra_dd");
        TextView textView = (TextView) findViewById(R.id.textView3);
        TextView textView1 = (TextView) findViewById(R.id.textView5);
        textView.setText("您的名字是：" + data);
        textView1.setText("您的手机号是：" + dd);
        //返回
//        titleButton2.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(Main2Activity.this, MainActivity.class);
//                startActivity(intent);
//                finish();
//            }
//        });
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(Main2Activity.this, MainActivity.class);
        startActivity(intent);
        finish();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ActivityCollector.removeActivity(this);
    }
}
