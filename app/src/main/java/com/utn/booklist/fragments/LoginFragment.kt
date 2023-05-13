package com.utn.booklist.fragments

import android.content.Intent
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.TextureView
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.navigation.fragment.findNavController
import com.google.android.material.snackbar.Snackbar
import com.utn.booklist.R
import com.utn.booklist.activities.LoginActivity
import com.utn.booklist.activities.MainActivity
import com.utn.booklist.entities.*

class LoginFragment : Fragment() {

    lateinit var v : View
    lateinit var textUser : TextView
    lateinit var textPass : TextView
    lateinit var btnLogin : Button
    lateinit var btnNew : Button
    var listOfuser: MutableList<User> = mutableListOf()
    private var db: AppDatabase? = null
    private var usuariosDao: UsuariosDao? = null
    var usuarioActual : User = (User(1,"Master","12345678"))

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        v= inflater.inflate(R.layout.fragment_login, container, false)
        textUser=v.findViewById(R.id.editTextUser)
        textPass=v.findViewById(R.id.editTextPassword)
        btnLogin=v.findViewById(R.id.buttonLogin)
        btnNew=v.findViewById(R.id.buttonNew)
        listOfuser.add(User(1,"marcelo","1234"))
        listOfuser.add(User(2,"prueba","password"))


        return v
    }

    override fun onStart() {
        super.onStart()
        db = AppDatabase.getInstance(v.context)
        usuariosDao = db?.usuariosDao()
        usuariosDao?.insertUsuario(User(1,"marcelo","1234"))
        usuariosDao?.insertUsuario(User(2,"mariela","4567"))
        usuariosDao?.insertUsuario(User(3,"pedro","4567"))


        btnLogin.setOnClickListener {
            if (usuariosDao?.fetchUserByUser(textUser.text.toString())!=null)
            {usuarioActual = usuariosDao?.fetchUserByUser(textUser.text.toString())!!
                if (usuarioActual.pass == textPass.text.toString())
                {
                    usuariosDao?.insertUsuario(User(999,usuarioActual.user,usuarioActual.pass))
                    var intent = Intent(context, MainActivity::class.java)
                    startActivity(intent)}
                else{
                    Snackbar.make(v,"Contraseña incorrecta", Snackbar.LENGTH_LONG).show()
                }


            }
            else{
                Snackbar.make(v,"Usuario no encontrado", Snackbar.LENGTH_LONG).show()
            }

        }
        btnNew.setOnClickListener {
            val action = LoginFragmentDirections.actionLoginFragmentToCreateUserFragment()
            findNavController().navigate(action)
        }

    }



}