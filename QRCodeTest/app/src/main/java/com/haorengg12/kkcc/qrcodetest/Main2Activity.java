package com.haorengg12.kkcc.qrcodetest;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

/*
* 二维码扫描+识别
* 基于
* compile 'com.journeyapps:zxing-android-embedded:3.5.0'
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
        actbar();
    }

    public void actbar() {
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                super.onBackPressed();
                break;
            default:
        }
        return true;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button:
                IntentIntegrator integrator = new IntentIntegrator(this);
                integrator.setCaptureActivity(Main3Activity.class);//样式
                integrator.setDesiredBarcodeFormats(IntentIntegrator.ALL_CODE_TYPES);//Code类型
                integrator.setPrompt("");//底下的文字（默认有字，这里设置无字）
                integrator.setOrientationLocked(true);//竖屏已锁
                integrator.setBeepEnabled(false);//声音
                integrator.initiateScan();//是否扫描
                break;
            default:
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        IntentResult result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);
//        Pattern pattern = Pattern.compile("http://");
//        Matcher matcher = pattern.matcher(result.getContents());
        if (result != null) {
            if (result.getContents() == null) {
                Toast.makeText(this, "无结果", Toast.LENGTH_LONG).show();
            }
//            else if (matcher.find()) {
//                Intent intent = new Intent();
//                intent
//            }
            else {
                String rerere = result.getContents();
                textView.setText(rerere);
            }
        } else {
            // This is important, otherwise the result will not be passed to the fragment
            super.onActivityResult(requestCode, resultCode, data);
        }
    }
}