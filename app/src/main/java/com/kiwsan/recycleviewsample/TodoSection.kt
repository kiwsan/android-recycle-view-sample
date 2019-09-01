package com.kiwsan.recycleviewsample

class TodoSection {
    var headerTitle: String = ""
    var items: ArrayList<TodoModel> = ArrayList()

    constructor() {
    }

    constructor(headerTitle: String, items: ArrayList<TodoModel>) {
        this.headerTitle = headerTitle
        this.items = items
    }
}