package com.haorengg12.kkcc.zuoye2;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

/**
 * Created by 黄黄k on 2017-10-29.
 */


public class Msg_ListAdapter extends RecyclerView.Adapter<Msg_ListAdapter.ViewHolder> {
    private Context mContext;
    private List<Msg_List> mMsg_ListList;

    static class ViewHolder extends RecyclerView.ViewHolder {
        CardView cardView;
        ImageView Msg_Listimage;
        TextView Msg_Listname;

        public ViewHolder(View view) {
            super(view);
            cardView = (CardView) view;
            Msg_Listimage = (ImageView) view.findViewById(R.id.msg_image);
            Msg_Listname = (TextView) view.findViewById(R.id.msg_name);
        }
    }

    public Msg_ListAdapter(List<Msg_List> fruitList) {
        mMsg_ListList = fruitList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (mContext == null) {
            mContext = parent.getContext();
        }
        View view = LayoutInflater.from(mContext).inflate(R.layout.msg_list, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Msg_List fruit = mMsg_ListList.get(position);
        holder.Msg_Listname.setText(fruit.getName());
        Glide.with(mContext).load(fruit.getImageId()).into(holder.Msg_Listimage);
    }

    @Override
    public int getItemCount() {
        return mMsg_ListList.size();
    }
}