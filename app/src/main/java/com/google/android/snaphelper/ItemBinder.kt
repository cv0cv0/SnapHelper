package com.google.android.snaphelper

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.item_layout.view.*
import me.drakeet.multitype.ItemViewBinder

/**
 * Created by GR on 2017/11/9.
 */
class ItemBinder : ItemViewBinder<String, ItemBinder.ViewHolder>() {
    private var itemClickListener: ((view: View, position: Int) -> Unit)? = null

    override fun onCreateViewHolder(inflater: LayoutInflater, parent: ViewGroup): ViewHolder {
        val itemView = inflater.inflate(R.layout.item_layout, parent, false)
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, item: String) {
        val identifier = holder.itemView.resources.getIdentifier(item, "drawable", "com.google.android.snaphelper")
        Glide.with(holder.itemView)
                .load(identifier)
                .into(holder.itemView.imageView)

        holder.itemView.setOnClickListener {
            itemClickListener?.invoke(holder.itemView.imageView, holder.layoutPosition)
        }
    }

    fun setItemClickListener(listener: (view: View, position: Int) -> Unit) {
        itemClickListener = listener
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
}