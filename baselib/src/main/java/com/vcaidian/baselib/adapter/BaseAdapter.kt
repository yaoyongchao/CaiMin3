package com.vcaidian.baselib.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

class BaseAdapter<T>(val layoutResourceId: Int, val items: List<T>, val init: (View, T,Int) -> Unit) :
        RecyclerView.Adapter<BaseAdapter.ViewHolder<T>>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder<T> {
        val view = LayoutInflater.from(parent.context).inflate(layoutResourceId,parent,false)
//        val view = parent.ctx.layoutInflater.inflate(layoutResourceId, parent, false)
        return ViewHolder(view, init)
    }

    override fun onBindViewHolder(holder: ViewHolder<T>, position: Int) {

        holder.bindForecast(items[position],position)
    }

    override fun getItemCount() = items.size

    class ViewHolder<in T>(view: View, val init: (View, T,Int) -> Unit) : RecyclerView.ViewHolder(view) {
        fun bindForecast(item: T,position: Int) {
            with(item) {
                init(itemView, item,position)
            }
        }
    }
}