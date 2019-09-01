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

class TodoAdapter(context: Context, items: ArrayList<TodoSection>) :
    RecyclerView.Adapter<TodoAdapter.TodoViewHolder>() {

    private val items: ArrayList<TodoSection>?
    private val context: Context

    init {
        this.items = items
        this.context = context
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoViewHolder {
        val view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_todo, null)

        val item = TodoViewHolder(view)

        return item
    }

    override fun getItemCount(): Int {
        if (items != null) {
            return items.count()
        }

        return 0
    }

    override fun onBindViewHolder(holder: TodoViewHolder, position: Int) {
        val name = items?.get(position)?.headerTitle
        val sections = items?.get(position)?.items



        holder.title.text = name
        holder.btnMore.setOnClickListener {
            Toast.makeText(context, name, Toast.LENGTH_SHORT).show()
        }
    }

    inner class TodoViewHolder(view: View) : RecyclerView.ViewHolder(view) {
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