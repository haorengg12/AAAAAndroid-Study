package com.example.kkcc.servicebestpractice;

/**
 * Created by 黄黄k on 2017-10-22.
 */

public interface DownLoadListener {
    void onProgress(int progress);

    void onSuccess();

    void onFailed();

    void onPause();

    void onCanceled();
}
