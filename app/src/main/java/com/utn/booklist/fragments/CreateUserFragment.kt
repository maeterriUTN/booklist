package com.utn.booklist.fragments

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.navigation.fragment.findNavController
import com.google.android.material.snackbar.Snackbar
import com.utn.booklist.R
import com.utn.booklist.entities.AppDatabase
import com.utn.booklist.entities.User
import com.utn.booklist.entities.UsuariosDao

class CreateUserFragment : Fragment() {
    lateinit var v : View
    lateinit var textNewUser : TextView
    lateinit var textNewPass : TextView
    lateinit var btnCrear : Button
    private var db: AppDatabase? = null
    private var usuariosDao: UsuariosDao? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        v= inflater.inflate(R.layout.fragment_create_user, container, false)
        db = AppDatabase.getInstance(v.context)
        usuariosDao = db?.usuariosDao()
        textNewUser=v.findViewById(R.id.editTextNewUser)
        textNewPass=v.findViewById(R.id.editTextNewPass)
        btnCrear=v.findViewById(R.id.buttonCrear)

        return v
    }

    override fun onStart() {
        super.onStart()

        btnCrear.setOnClickListener {
            Snackbar.make(v,"Usuario ${textNewUser.text.toString()} ingresado", Snackbar.LENGTH_LONG).show()
            usuariosDao?.insertUsuario(User(0,textNewUser.text.toString(),textNewPass.text.toString()))
            val action = CreateUserFragmentDirections.actionCreateUserFragmentToLoginFragment()
            findNavController().navigate(action)
        }


    }



}