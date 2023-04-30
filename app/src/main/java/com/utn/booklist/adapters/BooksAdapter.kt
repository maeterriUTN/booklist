package com.utn.booklist.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.utn.booklist.R
import com.utn.booklist.entities.Book

class BooksAdapter(var bookList : MutableList <Book>) : RecyclerView.Adapter<BooksAdapter.BooksHolder>() {
    class BooksHolder(v: View) : RecyclerView.ViewHolder(v) {
        private var view: View

        init {
            this.view = v
        }
        fun setTitle (title : String){
            var txtTitle : TextView = view.findViewById(R.id.txtTitle)
            txtTitle.text = title
        }
        fun setAuthor (author : String){
            var txtAuthor : TextView = view.findViewById(R.id.txtAuthor)
            txtAuthor.text = author
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BooksHolder {
        val view =  LayoutInflater.from(parent.context).inflate(R.layout.item_book,parent,false)
        return (BooksHolder(view))
    }

    override fun getItemCount(): Int {
        return bookList.size
    }

    override fun onBindViewHolder(holder: BooksHolder, position: Int) {
        holder.setTitle(bookList[position].title)
        holder.setAuthor(bookList[position].author)
    }
}