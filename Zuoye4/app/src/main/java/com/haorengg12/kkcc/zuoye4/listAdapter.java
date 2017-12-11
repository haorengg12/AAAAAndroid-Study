package com.haorengg12.kkcc.zuoye4;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by 黄黄k on 2017-12-09.
 */

public class listAdapter extends ArrayAdapter<news> {
    private int resourceId;

    public listAdapter(Context context, int textViewResourceId, List<news> objects) {
        super(context, textViewResourceId, objects);
        resourceId = textViewResourceId;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        news ns = getItem(position);
        View view;
        ViewHolder viewHolder;
        if (convertView == null) {
            view = LayoutInflater.from(getContext()).inflate(resourceId, parent, false);
            viewHolder = new ViewHolder();
            viewHolder.textView = (TextView) view.findViewById(R.id.title);
            view.setTag(viewHolder);
        } else {
            view = convertView;
            viewHolder = (ViewHolder) view.getTag();
        }
        viewHolder.textView.setText(ns.getTitle());
        return view;
    }

    class ViewHolder {
        TextView textView;
    }
}
