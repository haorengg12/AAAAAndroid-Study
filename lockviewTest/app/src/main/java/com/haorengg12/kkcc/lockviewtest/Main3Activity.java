package com.haorengg12.kkcc.lockviewtest;

import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.hanks.passcodeview.PasscodeView;

public class Main3Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (Build.VERSION.SDK_INT >= 21) {
            View decorView = getWindow().getDecorView();
            int option = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                    | View.SYSTEM_UI_FLAG_LAYOUT_STABLE;
            decorView.setSystemUiVisibility(option);
            getWindow().setStatusBarColor(Color.TRANSPARENT);
        }

        setContentView(R.layout.activity_main3);
        PasscodeView passcodeView = (PasscodeView) findViewById(R.id.passcodeView);
        passcodeView
                .setPasscodeLength(4)
                .setLocalPasscode("5555")
                .setListener(new PasscodeView.PasscodeViewListener() {
                    @Override
                    public void onFail() {

                    }

                    @Override
                    public void onSuccess(String number) {
                        startActivity(new Intent(Main3Activity.this, Main2Activity.class));
                    }
                });
    }
}
