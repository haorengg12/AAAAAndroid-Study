package com.haorengg12.kkcc.zxing1.zxing1;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;
import com.haorengg12.kkcc.zxing1.R;

/*
* 基于
* compile 'com.journeyapps:zxing-android-embedded:3.5.0'
* 这个库
* */

public class Main2Activity extends AppCompatActivity implements View.OnClickListener {
    private Button button;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        button = (Button) findViewById(R.id.button);
        textView = (TextView) findViewById(R.id.text);
        button.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button:
                IntentIntegrator integrator = new IntentIntegrator(this);
                integrator.setOrientationLocked(false);
                integrator.setCaptureActivity(SmallCaptureActivity.class);
                integrator.initiateScan();
                break;
            default:
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        IntentResult result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);
        if (result != null) {
            if (result.getContents() == null) {
                Toast.makeText(this, "无结果", Toast.LENGTH_LONG).show();
            } else {
                textView.setText(result.getContents());
            }
        } else {
            // This is important, otherwise the result will not be passed to the fragment
            super.onActivityResult(requestCode, resultCode, data);
        }
    }
}