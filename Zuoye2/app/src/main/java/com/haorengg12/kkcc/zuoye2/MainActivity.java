package com.haorengg12.kkcc.zuoye2;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<Msg_List> msgList = new ArrayList<Msg_List>();
    private EditText inputText;
    private Button send;
    private RecyclerView msgRecyclerView;
    private MsgAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbat = (Toolbar) findViewById(R.id.toolbar1);
        setSupportActionBar(toolbat);
        toolbat.setTitle("");//每个活动的名字
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setHomeAsUpIndicator(R.drawable.delete_2);
        }
        initMsgs(); // 初始化消息数据
        inputText = (EditText) findViewById(R.id.input_text);
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
                    adapter.notifyItemInserted(msgList.size() - 1); // 当有新消息时，刷新ListView中的显示
                    msgRecyclerView.scrollToPosition(msgList.size() - 1); // 将ListView定位到最后一行
                    inputText.setText(""); // 清空输入框中的内容
                }
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
//                Intent intent = new Intent(MainActivity.this, Main2Activity.class);
//                startActivity(intent);//活动方法（没写）
                finish();
                break;
            default:
        }
        return true;
    }

    private void initMsgs() {
        Msg_List msg1 = new Msg_List(null, 0, "Hello guy.", Msg_List.TYPE_RECEIVED);
        msgList.add(msg1);
        Msg_List msg2 = new Msg_List(null, 0, "Hello. Who is that?", Msg_List.TYPE_SENT);
        msgList.add(msg2);
        Msg_List msg3 = new Msg_List(null, 0, "This is Tom. Nice talking to you. ", Msg_List.TYPE_RECEIVED);
        msgList.add(msg3);
    }
}
