package com.example.kkcc.myapplication;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by 黄黄k on 2017-10-12.
 */

public class Right_Fragment extends Fragment {
    public static final String TAG = "RightFragment";

//    @Override
//    public void onAttach(Context context) {
//        super.onAttach(context);
//        Log.d(TAG, "onAttach");//碎片和活动关联
//    }
//
//    @Override
//    public void onCreate(@Nullable Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        Log.d(TAG, "onCreate");
//    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Log.d(TAG, "onCreateVoew");//为碎片创造视图
        View view = inflater.inflate(R.layout.right_fragment, container, false);
        return view;
    }
//
//    @Override
//    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
//        super.onActivityCreated(savedInstanceState);
//        Log.d(TAG, "onActivityCreated");//确保碎片关联的活动一定已经创建完毕时调用
//    }
//
//    @Override
//    public void onStart() {
//        super.onStart();
//        Log.d(TAG, "onStart");
//    }
//
//    @Override
//    public void onResume() {
//        super.onResume();
//        Log.d(TAG, "onResume");
//    }
//
//    @Override
//    public void onPause() {
//        super.onPause();
//        Log.d(TAG, "onPause");
//    }
//
//    @Override
//    public void onStop() {
//        super.onStop();
//        Log.d(TAG, "onStop");
//    }
//
//    @Override
//    public void onDestroy() {
//        super.onDestroy();
//        Log.d(TAG, "onDestroy");
//    }
//
//    @Override
//    public void onDetach() {
//        super.onDetach();
//        Log.d(TAG, "onDeach");//碎片和活动解除关联时调用
//    }
}
