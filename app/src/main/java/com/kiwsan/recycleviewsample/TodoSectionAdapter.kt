package com.kiwsan.recycleviewsample

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class TodoSectionAdapter(context: Context, items: ArrayList<TodoSectionModel>?) :
    RecyclerView.Adapter<TodoSectionAdapter.TodoSectionViewHolder>() {

    private val items: ArrayList<TodoSectionModel>?
    private val context: Context

    init {
        this.items = items
        this.context = context
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoSectionViewHolder {
        val view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_section, null)

        return TodoSectionViewHolder(view)
    }

    override fun getItemCount(): Int {
        if (items != null) {
            return items.count()
        }

        return 0
    }

    override fun onBindViewHolder(holder: TodoSectionViewHolder, position: Int) {
        val name = items?.get(position)?.title
        val sections = items?.get(position)?.items

        val adapter = TodoAdapter(context, sections)

        holder.recyclerView.setHasFixedSize(true)
        holder.recyclerView.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        holder.recyclerView.adapter = adapter

        holder.title.text = name
        holder.btnMore.setOnClickListener {
            Toast.makeText(context, name, Toast.LENGTH_SHORT).show()
        }
    }

    inner class TodoSectionViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var title: TextView
        var recyclerView: RecyclerView
        var btnMore: Button

        init {
            this.title = view.findViewById(R.id.title) as TextView
            this.recyclerView = view.findViewById(R.id.recyclerViewTodo) as RecyclerView
            this.btnMore = view.findViewById(R.id.btnMore) as Button
        }
    }

}