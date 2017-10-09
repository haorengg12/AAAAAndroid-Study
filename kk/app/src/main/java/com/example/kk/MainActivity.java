package com.example.kk;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends BasicActivity {

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.kk, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.add_item:
                Toast.makeText(this, "你点击了增加", Toast.LENGTH_SHORT).show();
                break;

            case R.id.Remove_item:
                Toast.makeText(this, "你点击了移动", Toast.LENGTH_SHORT).show();
                break;
            default:

        }
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("MainActivity", this.toString());
        setContentView(R.layout.activity_main);
//        TextView textView = (TextView) findViewById(R.id.ttv1);
//        textView.setText("延边大学出版社");
        Button bty1 = (Button) findViewById(R.id.bty1);
        bty1.setText("点我");
        //点击监听
        bty1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Toast.makeText(MainActivity.this, "你点了我一下", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(MainActivity.this, Main2Activity.class);
//                Intent intent=new Intent(MainActivity.this,MainActivity.class);//standard启动
//                startActivityForResult(intent, 1);
//                String data="有趣";
//                Intent intent=new Intent(MainActivity.this,Main2Activity.class);
//                intent.putExtra("extra_data",data);
//                Intent intent=new Intent(Intent.ACTION_VIEW);
//                intent.setData(Uri.parse("http://www.ybu.edu.cn"));
                startActivity(intent);
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch (requestCode) {
            case 1:
                if (resultCode == RESULT_OK) {
                    String returnedData = data.getStringExtra("data_return");
                    Log.d("Main2Activity", returnedData);
                }
                break;
            default:
        }
    }
}
