package com.utn.booklist.fragments

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.google.android.material.snackbar.Snackbar
import com.utn.booklist.R
import com.utn.booklist.entities.AppDatabase
import com.utn.booklist.entities.Book
import com.utn.booklist.entities.UserDao

class BookDetailFragment : Fragment() {
    var listOfBook : MutableList<Book>? = mutableListOf()
    var listOfBook2: MutableList<Book> = mutableListOf()
    lateinit var txtTitle : TextView
    lateinit var txtAuthor : TextView
    lateinit var txtYear : TextView
    lateinit var txtDescription : TextView
    lateinit var v : View
    var arg : Int = 0
    private var db: AppDatabase? = null
    private var userDao: UserDao? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        v = inflater.inflate(R.layout.fragment_book_detail, container, false)
        txtAuthor=v.findViewById(R.id.txtAuthorDescription)
        txtTitle=v.findViewById(R.id.txtTitleDescription)
        txtYear=v.findViewById(R.id.txtYearDescription)
        txtDescription=v.findViewById(R.id.txtDescription)


        return v
    }

    override fun onStart() {
        super.onStart()
        db = AppDatabase.getInstance(v.context)
        userDao = db?.userDao()
        arg = BookDetailFragmentArgs.fromBundle(requireArguments()).Argumento
        listOfBook = userDao?.getAll()
        listOfBook2=listOfBook!!
        txtTitle.setText(listOfBook2[arg].title)
        txtAuthor.setText(listOfBook2[arg].author)
        txtYear.setText(listOfBook2[arg].year.toString())
        txtDescription.setText(listOfBook2[arg].description)
        Snackbar.make(v, listOfBook2[arg].title, Snackbar.LENGTH_LONG).show()

    }


}