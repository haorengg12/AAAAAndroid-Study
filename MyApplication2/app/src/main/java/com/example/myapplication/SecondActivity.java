package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import static com.example.myapplication.R.id.textView2;
import static com.example.myapplication.R.id.textView3;

public class SecondActivity extends AppCompatActivity {
    @Override
    public void onBackPressed() {
        Intent intent1 = new Intent(SecondActivity.this, com.example.myapplication.FirstActivity.class);
        startActivity(intent1);
        finish();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Button button = (Button) findViewById(R.id.button2);
        TextView textView = (TextView) findViewById(textView2);
        TextView textView2 = (TextView) findViewById(textView3);
        final Intent intent = getIntent();
        String text = intent.getStringExtra("text1");
        String text2 = intent.getStringExtra("text2");
        textView.setText("你的姓名是：" + text);
        textView2.setText("你的学号是：" + text2);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(SecondActivity.this, com.example.myapplication.FirstActivity.class);

                startActivity(intent1);
                finish();
            }
        });

    }
}
