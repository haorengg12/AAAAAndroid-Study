package com.haorengg12.kkcc.qrcodetest;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;

import java.util.HashMap;
import java.util.Map;

/*
* 二维码生成
* 基于
* compile 'com.google.zxing:core:3.3.1'
* 来自谷歌原生Zxing库
* */

public class Main4Activity extends AppCompatActivity implements View.OnClickListener {
    private Button button;
    private EditText textView;
    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        button = (Button) findViewById(R.id.button);
        imageView = (ImageView) findViewById(R.id.image);
        textView = (EditText) findViewById(R.id.text);
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
                if (!"".equals(textView.getText().toString())) {
                    Bitmap qrBitmap = generateBitmap(textView.getText().toString(), 500, 500);
                    imageView.setImageBitmap(qrBitmap);
                } else {
                    Bitmap qrBitmap = generateBitmap("啥也没有", 800, 800);
                    imageView.setImageBitmap(qrBitmap);
                }
                break;
            default:
                break;
        }
    }

    private Bitmap generateBitmap(String content, int width, int height) {
        QRCodeWriter qrCodeWriter = new QRCodeWriter();
        Map<EncodeHintType, String> hints = new HashMap<>();
        hints.put(EncodeHintType.CHARACTER_SET, "utf-8");
        try {
            BitMatrix encode = qrCodeWriter.encode(content, BarcodeFormat.QR_CODE, width, height, hints);
            int[] pixels = new int[width * height];
            for (int i = 0; i < height; i++) {
                for (int j = 0; j < width; j++) {
                    if (encode.get(j, i)) {
                        pixels[i * width + j] = 0x000000;
                    } else {
                        pixels[i * width + j] = 0xfafafa;//默认背景颜色#fafafa
                    }
                }
            }
            return Bitmap.createBitmap(pixels, 0, width, width, height, Bitmap.Config.RGB_565);
        } catch (WriterException e) {
            e.printStackTrace();
        }
        return null;
    }
}
