package com.haorengg12.kkcc.floatbuttontest;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Toast;

import com.getbase.floatingactionbutton.FloatingActionButton;

public class MainActivity extends Activity {
    private FloatingActionButton kk1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        kk1 = (FloatingActionButton) findViewById(R.id.kk1);
        kk1.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "lalala", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
