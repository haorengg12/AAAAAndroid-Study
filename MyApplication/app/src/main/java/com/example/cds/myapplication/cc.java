package com.example.cds.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class cc extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cc);
        Intent intent=getIntent();
        String data=intent.getStringExtra("extra_data");
        TextView textView=(TextView)findViewById(R.id.textView3);
        textView.setText(data);

    }
}
