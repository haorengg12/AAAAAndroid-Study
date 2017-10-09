package com.example.listviewtest;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by 黄黄k on 2017-10-09.
 */

public class FruitAdapter extends ArrayAdapter<Fruit> {
    private int resourceId;

    public FruitAdapter(Context context, int textViewResourceId, List<Fruit> objects) {
        super(context, textViewResourceId, objects);
        resourceId = textViewResourceId;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Fruit fruit = getItem(position);
//        View view = LayoutInflater.from(getContext()).inflate(resourceId, parent, false);
        View view;
        ViewHolder viewHolder;
        if (convertView == null) /*提升运行效率*/ {
            view = LayoutInflater.from(getContext()).inflate(resourceId, parent, false);
            viewHolder = new ViewHolder();
            viewHolder.fruitimage = (ImageView) view.findViewById(R.id.fruit_image);
            viewHolder.fruitname = (TextView) view.findViewById(R.id.fruit_name);
            view.setTag(viewHolder);

        } else {
            view = convertView;
            viewHolder = (ViewHolder) view.getTag();
        }
        viewHolder.fruitimage.setImageResource(fruit.getImageId());
        viewHolder.fruitname.setText(fruit.getName());
        return view;
    }

    class ViewHolder {
        ImageView fruitimage;
        TextView fruitname;
    }
}
