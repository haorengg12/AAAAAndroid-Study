package com.example.kk;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class Main2Activity extends BasicActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("Main2Activity", this.toString());
        setContentView(R.layout.activity_main2);
//        Intent intent = getIntent();
//        String data = intent.getStringExtra("extra_data");
//        TextView textView = (TextView) findViewById(R.id.ttv2);
//        textView.setText(data);//在TextView里打印
//        Log.d("Second",data);

        Button bty2 = (Button) findViewById(R.id.bty2);
        Button bty3 = (Button) findViewById(R.id.bty3);
//        bty3.setText("传回数据");
        bty2.setText("返回");
        bty3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Main2Activity.this, MainActivity.class);
                startActivity(intent);
//                Intent intent = new Intent();
//                intent.putExtra("data_return", "hahahahahaahahhah");
//                setResult(RESULT_OK, intent);
            }
        });
        bty2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ActivityCollector.finishAll();

            }
        });
    }

//    @Override
//    public void onBackPressed() {
//        super.onBackPressed();
//        Intent intent = new Intent();
//        intent.putExtra("data_return","hahahahahaahahhah");
//        setResult(RESULT_OK,intent);
//        finish();
//    }
}
