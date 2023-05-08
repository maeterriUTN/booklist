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
import com.utn.booklist.entities.AppDatabase
import com.utn.booklist.entities.Book
import com.utn.booklist.entities.BooksRepository
import com.utn.booklist.entities.UserDao

class BookListFragment : Fragment() {

    lateinit var v : View
    lateinit var BookList : RecyclerView
    lateinit var adapter : BooksAdapter
    var BookRepository : BooksRepository = BooksRepository()
    private var db: AppDatabase? = null
    private var userDao: UserDao? = null
    var prueba : MutableList<Book> = mutableListOf()
    var prueba2 : MutableList<Book>? = mutableListOf()



    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        v = inflater.inflate(R.layout.fragment_book_list, container, false)
        BookList=v.findViewById(R.id.BookList)

        return v
    }

    override fun onStart() {
        super.onStart()
        db = AppDatabase.getInstance(v.context)
        userDao = db?.userDao()
        userDao?.insertBook(Book(1,"El Aleph","Jorge Luis Borges","","https://quelibroleo.com/images/libros/libro_1362277233.jpg",1949))
        userDao?.insertBook(Book(2,"Rayuela","Julio Cortazar","","https://educacion.ufm.edu/wp-content/uploads/2013/07/Rayuela.jpg",1963))
        userDao?.insertBook(Book(3,"Una Cama Limpia Para Morir","Mariela Gurevich","Hay dos mundos. Uno adentro, el otro afuera. Uno que se vuelve opresivo, mientras el otro se dibuja como utopía. Hay dos mundos: el que habitan las travas que son arriadas como ganado al matadero para ser carne de experimentación","https://www.editorialsudestada.com.ar/wp-content/uploads/2022/10/mari-2048x1400.jpg",2022))
        userDao?.insertBook(Book(4,"Un mundo felíz","Aldous Huxley","","",1932))
        userDao?.insertBook(Book(5,"Sobre Heroes y Tumbas","Ernesto Sabato","","",1961))
        userDao?.insertBook(Book(6,"Las intermintencias de la Muerte","José Saramago","","",2005))
        userDao?.insertBook(Book(7,"Las venas abiertas de América Latina","Eduardo Galeano","","",1971))
        userDao?.insertBook(Book(8,"El arte de la guerra","Tsun Tzu","","",-400))
        userDao?.insertBook(Book(9,"Tiempo sin lluvia","Cynan Jones","","",2006))
        prueba2 = userDao?.getAll()
        prueba = prueba2!!
        //prueba = userDao?.fetchAllBooks()
        //adapter = BooksAdapter(BookRepository.bookList){position ->
        //    onItemClick(position)
        //}

        adapter = BooksAdapter(prueba){position ->
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