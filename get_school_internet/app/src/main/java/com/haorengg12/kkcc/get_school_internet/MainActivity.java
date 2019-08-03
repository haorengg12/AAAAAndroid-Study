package com.haorengg12.kkcc.get_school_internet;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button login = findViewById(R.id.login);
        login.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.login:
                URL url = null;
                HttpURLConnection connection = null;
                try {
//                    HttpURLConnection
                    url = new URL("http://172.16.6.3");
                    connection = (HttpURLConnection) url.openConnection();
                    connection.setRequestMethod("POST");

                } catch (IOException e) {
                    assert connection != null;
                    connection.disconnect();
                    e.printStackTrace();
                }
                break;
            default:
                break;
        }
    }
}
