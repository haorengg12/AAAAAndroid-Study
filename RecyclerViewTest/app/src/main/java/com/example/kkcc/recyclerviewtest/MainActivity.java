package com.example.kkcc.recyclerviewtest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private List<Fruit> fruitList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initFruits();
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
//        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
//        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        StaggeredGridLayoutManager layoutManager = new StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        FruitAdapter adapter = new FruitAdapter(fruitList);
        recyclerView.setAdapter(adapter);
    }

    private void initFruits() {
        for (int i = 0; i < 4; i++) {
            Fruit apple = new Fruit(getRandomLengthName("apple"), R.drawable.apple_pic);
            fruitList.add(apple);
            Fruit banana = new Fruit(getRandomLengthName("banana"), R.drawable.banana_pic);
            fruitList.add(banana);
            Fruit cherry = new Fruit(getRandomLengthName("cherry"), R.drawable.cherry_pic);
            fruitList.add(cherry);
            Fruit grape = new Fruit(getRandomLengthName("grape"), R.drawable.grape_pic);
            fruitList.add(grape);
            Fruit mango = new Fruit(getRandomLengthName("mango"), R.drawable.mango_pic);
            fruitList.add(mango);
        }
    }
    private String getRandomLengthName(String name){
        Random random = new Random();
        int length = random.nextInt(20) + 1;
        StringBuilder builder = new StringBuilder();
        for (int i=0;i<length;i++){
            builder.append(name);
        }
        return builder.toString();
    }
}
