package com.utn.booklist.fragments

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.utn.booklist.R
import com.utn.booklist.activities.LoginActivity
import com.utn.booklist.entities.AppDatabase
import com.utn.booklist.entities.User
import com.utn.booklist.entities.UsuariosDao

class UserFragment : Fragment() {

    lateinit var v : View

    lateinit var btnLogout : Button
    lateinit var txtUsuario : TextView
    private var db: AppDatabase? = null
    private var usuariosDao: UsuariosDao? = null
    var usuarioactual : User = User(999,"Master","1234")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        v= inflater.inflate(R.layout.fragment_user, container, false)
        db = AppDatabase.getInstance(v.context)
        usuariosDao = db?.usuariosDao()

        btnLogout=v.findViewById(R.id.buttonLogout)
        txtUsuario=v.findViewById(R.id.textViewUsuario)


        return v
    }

    override fun onStart() {
        super.onStart()
        usuarioactual = usuariosDao?.fetchUserById(999)!!
        txtUsuario.setText(usuarioactual.user.toString())
        btnLogout.setOnClickListener {
            var intent = Intent(context, LoginActivity::class.java)
            startActivity(intent)
        }
    }

}