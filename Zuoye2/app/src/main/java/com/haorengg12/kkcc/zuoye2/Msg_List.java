package com.haorengg12.kkcc.zuoye2;

/**
 * Created by 黄黄k on 2017-10-29.
 */

public class Msg_List {

    public static final int TYPE_RECEIVED = 0;
    public static final int TYPE_SENT = 1;
    private String name;
    private int imageId;
    private String content;
    private int type;

    public Msg_List(String name, int imageId, String content, int type) {
        this.name = name;
        this.imageId = imageId;
        this.content = content;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public int getImageId() {
        return imageId;
    }

    public String getContent() {
        return content;
    }

    public int getType() {
        return type;
    }
}
