package com.example.zuoye;

import android.content.Context;
import android.content.Intent;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

/**
 * Created by 黄黄k on 2017-09-27.
 */

public class TitleLayout2 extends LinearLayout {
    public TitleLayout2(Context context, AttributeSet attrs) {
        super(context, attrs);
        LayoutInflater.from(context).inflate(R.layout.title2, this);
        Button titleButton2 = (Button) findViewById(R.id.title_return);
        titleButton2.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), MainActivity.class);//问题
                v.getContext().startActivity(intent);
            }
        });
    }

}
