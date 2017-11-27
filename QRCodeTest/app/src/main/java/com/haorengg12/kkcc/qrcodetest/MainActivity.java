package com.haorengg12.kkcc.qrcodetest;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/*
* 引导。。。
* */

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button read;
    private Button write;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        read = (Button) findViewById(R.id.read);
        write = (Button) findViewById(R.id.write);
        read.setOnClickListener(this);
        write.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.read:
                Intent intent = new Intent(this, Main2Activity.class);
                startActivity(intent);
                break;
            case R.id.write:
                Intent intent2 = new Intent(this, Main4Activity.class);
                startActivity(intent2);
                break;
            default:
                break;
        }
    }
}
