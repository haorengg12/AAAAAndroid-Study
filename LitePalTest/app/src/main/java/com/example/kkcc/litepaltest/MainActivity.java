package com.example.kkcc.litepaltest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import org.litepal.LitePal;
import org.litepal.crud.DataSupport;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button createView = (Button) findViewById(R.id.createView);
        Button addData = (Button) findViewById(R.id.addData);
        createView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LitePal.getDatabase();
            }
        });
        addData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                int i, j;

//                Book book = new Book();
//                book.setName("kk");
//                book.setAuthor("kkcc");
//                book.setId(1);
//                book.setPress("Unkonwn");
//                book.setPrice(10.99);
//                book.setPages(510);
//                book.save();
//                DataSupport.deleteAll(Book.class, "id=?", "1");
//                book.updateAll("id<?", "2");
//                List<Book> books = DataSupport.findAll(Book.class);
                List<Book> books = DataSupport.limit(1).find(Book.class);
                for (Book book : books) {
                    Log.d("MainActivity", book.getAuthor());
                    Log.d("MainActivity", book.getName());
                    Log.d("MainActivity", book.getPress());
                    Log.d("MainActivity", "" + book.getPages());//强制类型转换
                    Log.d("MainActivity", "" + book.getPrice());
                }
                Toast.makeText(MainActivity.this, "OK", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
