package com.utn.booklist.fragments

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar
import com.utn.booklist.R
import com.utn.booklist.adapters.BooksAdapter
import com.utn.booklist.entities.BooksRepository

class BookListFragment : Fragment() {

    lateinit var v : View
    lateinit var BookList : RecyclerView
    lateinit var adapter : BooksAdapter
    var BookRepository : BooksRepository = BooksRepository()


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        v = inflater.inflate(R.layout.fragment_book_list, container, false)
        BookList=v.findViewById(R.id.BookList)
        return v
    }

    override fun onStart() {
        super.onStart()
        adapter = BooksAdapter(BookRepository.bookList){position ->
            onItemClick(position)

        }
        BookList.layoutManager= LinearLayoutManager(context)
        BookList.adapter=adapter
    }

    fun onItemClick (pos : Int){

        val action = BookListFragmentDirections.actionBookListFragmentToBookDetailFragment(pos)
        findNavController().navigate(action)
    }

}