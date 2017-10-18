package com.example.kkcc.litepaltest;

import org.litepal.crud.DataSupport;

/**
 * Created by 黄黄k on 2017-10-17.
 */

public class Book extends DataSupport {
    private int id;
    private String author;
    private double price;
    private int pages;
    private String name;
    private String press;

    //序号
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    //作者
    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    //
    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    //页码
    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    //名字
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    //出版社
    public String getPress() {
        return press;
    }

    public void setPress(String press) {
        this.press = press;
    }
}
