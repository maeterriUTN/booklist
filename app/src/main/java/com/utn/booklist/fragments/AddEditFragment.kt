package com.utn.booklist.fragments

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import com.google.android.material.snackbar.Snackbar
import com.utn.booklist.R
import com.utn.booklist.entities.AppDatabase
import com.utn.booklist.entities.Book
import com.utn.booklist.entities.UserDao

class AddEditFragment : Fragment() {

    var arg : Int = 0
    lateinit var editTitle : EditText
    lateinit var editAuthor : EditText
    lateinit var editYear : EditText
    lateinit var editDescription : EditText
    lateinit var editURL : EditText
    lateinit var v : View
    var listOfBook : MutableList<Book>? = mutableListOf()
    var listOfBook2: MutableList<Book> = mutableListOf()
    private var db: AppDatabase? = null
    private var userDao: UserDao? = null
    var myID : Int = 0
    lateinit var mytitle : String
    lateinit var myauthor :String
    var myyear :Int = 0
    lateinit var mydescription : String
    lateinit var myURL : String
    lateinit var btnAccept : Button



    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        v= inflater.inflate(R.layout.fragment_add_edit, container, false)
        editTitle=v.findViewById(R.id.editTextTitle)
        editAuthor=v.findViewById(R.id.editTextAuthor)
        editYear=v.findViewById(R.id.editTextTextYear)
        editDescription=v.findViewById(R.id.editTextTextDescription)
        editURL=v.findViewById(R.id.editTextTextURL)
        btnAccept=v.findViewById(R.id.buttonAccept)
        return v
    }

    override fun onStart() {
        super.onStart()
        arg = AddEditFragmentArgs.fromBundle(requireArguments()).arg2
        db = AppDatabase.getInstance(v.context)
        userDao = db?.userDao()
        listOfBook = userDao?.getAll()
        listOfBook2=listOfBook!!
        if (arg!=-1){
            editTitle.setText(listOfBook2[arg].title)
            editAuthor.setText(listOfBook2[arg].author)
            editYear.setText(listOfBook2[arg].year.toString())
            editDescription.setText(listOfBook2[arg].description)
            editURL.setText(listOfBook2[arg].image)
        }

        btnAccept.setOnClickListener {
            if(arg!=-1){
                myID=listOfBook2[arg].id
            }else{
                myID=0
            }
            mytitle=editTitle.text.toString()
            myauthor=editAuthor.text.toString()
            myyear=editYear.text.toString().toInt()
            mydescription=editDescription.text.toString()
            myURL=editURL.text.toString()
            userDao?.insertBook(Book(myID,mytitle,myauthor,mydescription,myURL,myyear))
        }



    }



}