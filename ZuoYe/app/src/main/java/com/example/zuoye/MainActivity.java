package com.example.zuoye;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ActionBar actionBar = getSupportActionBar();//删除标题栏
        if (actionBar != null) {
            actionBar.hide();
        }
        Button button = (Button) findViewById(R.id.send);
        final EditText editText = (EditText) findViewById(R.id.editText);//名字
        editText.addTextChangedListener(new LimitInputTextWatcher(editText));
        editText.setInputType(EditorInfo.TYPE_CLASS_TEXT);
        editText.setImeOptions(EditorInfo.IME_ACTION_NEXT);

        final EditText kk = (EditText) findViewById(R.id.edit_phone);//电话号码
        kk.setInputType(EditorInfo.TYPE_CLASS_PHONE);//数字键盘
        kk.setImeOptions(EditorInfo.IME_ACTION_DONE);
        ActivityCollector.addActivity(this);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String inputname = editText.getText().toString();
                String inputphone = kk.getText().toString();
                Intent intent = new Intent(MainActivity.this, Main2Activity.class);
                intent.putExtra("extra_data", inputname);
                intent.putExtra("extra_dd", inputphone);
                startActivity(intent);
            }
        });

    }

    @Override
    public void onBackPressed() {
        AlertDialog.Builder dialog = new AlertDialog.Builder(MainActivity.this);//！！！！这里要context
        dialog.setCancelable(true);
        dialog.setTitle("确定要退出么");
        dialog.setPositiveButton("确定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                ActivityCollector.finishAll();
            }
        });
        dialog.setNegativeButton("取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
            }
        });
        dialog.show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ActivityCollector.removeActivity(this);
    }
}
