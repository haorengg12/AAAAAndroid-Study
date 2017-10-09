package com.example.cds.myapplication;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.net.URI;

import static android.R.attr.button;
import static android.R.attr.secondaryProgressTintMode;

public class kk extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kk);
        TextView textView=(TextView) findViewById(R.id.textview);
        textView.setText("ybdx");
        Button bty=(Button)findViewById(R.id.bty);
        bty.setText("kkkkkkkkkkk");
        bty.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Toast.makeText(kk.this,"'fdsfsdf",Toast.LENGTH_SHORT).show();
//                String data="dasda";
//                Intent intent=new Intent(kk.this,cc.class);
//                intent.putExtra("extra_data",data);//在此区域打包
                 Intent intent=new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("www.ybu.edu.cn"));
                startActivity(intent);
            }
        });
    }
}
