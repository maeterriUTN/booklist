package com.utn.booklist.entities

class BooksRepository {
    var bookList : MutableList<Book> = mutableListOf()

    init{
        bookList.add(Book(1,"Rayuela","Cortazar","","",1945))
        bookList.add(Book(2,"El Aleph1","Borges","","",1945))
        bookList.add(Book(2,"El Aleph2","Borges","","",1945))

    }
    fun getBooks () : MutableList<Book>{
        return bookList
    }

}