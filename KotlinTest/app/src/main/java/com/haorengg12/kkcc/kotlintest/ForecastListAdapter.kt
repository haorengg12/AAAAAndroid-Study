package com.haorengg12.kkcc.kotlintest

import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import android.widget.TextView

/**
 * Created by 黄黄k on 2017-11-04.
 */
class ForecastListAdapter(val item: List<String>) : RecyclerView.Adapter<ForecastListAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(TextView(parent.context))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.textView.text = item[position]
    }

    override fun getItemCount(): Int = item.size

    class ViewHolder(val textView: TextView) : RecyclerView.ViewHolder(textView)
}