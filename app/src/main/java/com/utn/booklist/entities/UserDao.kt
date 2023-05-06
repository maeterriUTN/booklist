package com.utn.booklist.entities

import androidx.room.*

@Dao
interface UserDao {

    @Query("SELECT * FROM books ORDER BY id")
    fun fetchAllBooks(): MutableList<Book?>?

    @Query("SELECT * FROM books WHERE id = :id")
    fun fetchBookById(id: Int): Book?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertBook(book: Book)

    @Update
    fun updateBook(book: Book)

    @Delete
    fun delete(book: Book)

    @Query("SELECT COUNT(*) FROM books")
    fun count(): Int

    @Query("SELECT * FROM books")
    fun getAll(): MutableList<Book>
}