package com.utn.booklist.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "books")
class Book (
     id : Int,
     title : String,
     author : String,
     description : String,
     image : String,
     year : Int)

{
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    var id : Int
    @ColumnInfo(name = "title")
    var title : String
    @ColumnInfo(name = "author")
    var author : String
    @ColumnInfo(name = "description")
    var description : String
    @ColumnInfo(name = "image")
    var image : String
    @ColumnInfo(name = "year")
    var year : Int

init {
    this.id= id
     this.title = title
     this.author= author
     this.description= description
      this.image= image
     this.year= year
}

}