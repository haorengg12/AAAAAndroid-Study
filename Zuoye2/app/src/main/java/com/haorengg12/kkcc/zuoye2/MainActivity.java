package com.haorengg12.kkcc.zuoye2;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<Msg_List> msgList = new ArrayList<Msg_List>();
    private EditText inputText;
    private Button send;
    private RecyclerView msgRecyclerView;
    private MsgAdapter adapter;
    public static final String MSG_NAME = "msg_name";
    public static final String MSG_IMAGEID = "msg_imageid";
    private boolean imeopen = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent intent = getIntent();
        String msgname = intent.getStringExtra(MSG_NAME);
        final int msgimageid = intent.getIntExtra(MSG_IMAGEID, 0);
        Toolbar toolbat = (Toolbar) findViewById(R.id.toolbar1);
        toolbat.setTitle(msgname);//每个活动的名字
        setSupportActionBar(toolbat);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setHomeAsUpIndicator(R.drawable.delete_2);//返回栈图标
        }
        inputText = (EditText) findViewById(R.id.input_text);
        inputText.setInputType(EditorInfo.TYPE_CLASS_TEXT);
        inputText.setImeOptions(EditorInfo.IME_ACTION_NONE);
//        inputText.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
//            @Override
//            public void onGlobalLayout() {
//                InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
//                if (imm.showSoftInput(inputText, 0)) {
//                    adapter.notifyItemInserted(msgList.size() - 1); // 当有新消息时，刷新ListView中的显示
//                    msgRecyclerView.scrollToPosition(msgList.size() - 1); // 将ListView定位到最后一行
//                }
//            }
//        });
        inputText.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                String content = inputText.getText().toString();
                if (!"".equals(content)) {
                    Msg_List msg = new Msg_List(null, 0, content, Msg_List.TYPE_SENT);
                    msgList.add(msg);
                    initMsgs(content, msgimageid);
                    adapter.notifyItemInserted(msgList.size() - 1); // 当有新消息时，刷新ListView中的显示
                    msgRecyclerView.scrollToPosition(msgList.size() - 1); // 将ListView定位到最后一行
                    inputText.setText("");
                }
                return true;
            }
        });
        send = (Button) findViewById(R.id.send);
        msgRecyclerView = (RecyclerView) findViewById(R.id.msg_recycler_view);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        msgRecyclerView.setLayoutManager(layoutManager);
        adapter = new MsgAdapter(msgList);
        msgRecyclerView.setAdapter(adapter);
        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String content = inputText.getText().toString();
                if (!"".equals(content)) {
                    Msg_List msg = new Msg_List(null, 0, content, Msg_List.TYPE_SENT);
                    msgList.add(msg);
                    initMsgs(content, msgimageid);
                    adapter.notifyItemInserted(msgList.size() - 1); // 当有新消息时，刷新ListView中的显示
                    msgRecyclerView.scrollToPosition(msgList.size() - 1); // 将ListView定位到最后一行
                    inputText.setText("");
                }
            }
        });
        msgRecyclerView.addOnItemTouchListener(new RecyclerViewClickListener(this, new RecyclerViewClickListener.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(inputText.getWindowToken(), 0);
            }

            @Override
            public void onItemLongClick(View view, int position) {
            }

            @Override
            public void onmove(View view, int position) {
                InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(inputText.getWindowToken(), 0);
            }

        }));

    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                Intent intent = new Intent(MainActivity.this, Main2Activity.class);
                startActivity(intent);//活动方法（缺少重新点击还原对话的，数据库？）
                finish();
                break;
            default:
        }
        return true;
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(MainActivity.this, Main2Activity.class);
        startActivity(intent);//活动方法（缺少重新点击还原对话的，数据库？）
        finish();
    }

    private void initMsgs(final String con, final int i) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1234);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Msg_List msg1 = new Msg_List(null, i, con, Msg_List.TYPE_RECEIVED);
                        msgList.add(msg1);
                        adapter.notifyDataSetChanged();
                        adapter.notifyItemInserted(msgList.size() - 1); // 当有新消息时，刷新ListView中的显示
                        msgRecyclerView.scrollToPosition(msgList.size() - 1); // 将ListView定位到最后一行
                    }
                });
            }
        }).start();
    }
}
