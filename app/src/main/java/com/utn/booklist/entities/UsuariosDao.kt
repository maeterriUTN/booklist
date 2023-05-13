package com.utn.booklist.entities;
import androidx.room.*
import androidx.room.Dao
import androidx.room.Query

@Dao
interface UsuariosDao {
    @Query("SELECT * FROM usuarios ORDER BY id")
    fun fetchAllUsuarios(): MutableList<User?>?

    @Query("SELECT * FROM usuarios WHERE id = :id")
    fun fetchUserById(id: Int): User?

    @Query("SELECT * FROM usuarios WHERE user = :user")
    fun fetchUserByUser(user: String): User?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertUsuario(user: User)

    @Update
    fun updateUsuario(user: User)

    @Delete
    fun deleteUsuario(user: User)

    @Query("SELECT COUNT(*) FROM usuarios")
    fun countUsuarios(): Int

    @Query("SELECT * FROM usuarios")
    fun getAllUsuarios(): MutableList<User>
}
