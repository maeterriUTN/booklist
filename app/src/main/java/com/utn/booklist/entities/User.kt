package com.utn.booklist.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "usuarios")
class User (id : Int, user : String ,pass : String){
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    var id : Int
    @ColumnInfo(name = "user")
    var user : String
    @ColumnInfo(name = "pass")
    var pass : String

    init {
        this.id = id
        this.user = user
        this.pass = pass
    }
}