package com.kiwsan.recycleviewsample

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy

class TodoAdapter(context: Context, items: ArrayList<TodoModel>?) :
    RecyclerView.Adapter<TodoAdapter.TodoViewHolder>() {

    private val items: ArrayList<TodoModel>?
    private val context: Context

    init {
        this.items = items
        this.context = context
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoViewHolder {
        val view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_todo, null)

        return TodoViewHolder(view)
    }

    override fun getItemCount(): Int {
        if (items != null) {
            return items.count()
        }

        return 0
    }

    override fun onBindViewHolder(holder: TodoViewHolder, position: Int) {
        val title = items?.get(position)?.title
        val imageUrl = items?.get(position)?.imageUrl

        holder.todoTitle.text = title

        Glide.with(context)
            .load(imageUrl)
            .diskCacheStrategy(DiskCacheStrategy.ALL)
            .centerCrop()
            .error(android.R.drawable.ic_menu_report_image)
            .into(holder.todoImage)
    }

    inner class TodoViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var todoTitle: TextView
        var todoImage: ImageView

        init {
            this.todoTitle = view.findViewById(R.id.todoTitle) as TextView
            this.todoImage = view.findViewById(R.id.todoImage) as ImageView
        }
    }

}