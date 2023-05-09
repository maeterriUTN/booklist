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
import com.utn.booklist.R
import com.utn.booklist.activities.LoginActivity
import com.utn.booklist.activities.MainActivity
import com.utn.booklist.entities.Book
import com.utn.booklist.entities.User

class LoginFragment : Fragment() {

    lateinit var v : View
    lateinit var textUser : TextView
    lateinit var textPass : TextView
    lateinit var btnLogin : Button
    lateinit var btnNew : Button
    var listOfuser: MutableList<User> = mutableListOf()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        v= inflater.inflate(R.layout.fragment_login, container, false)
        textUser=v.findViewById(R.id.editTextUser)
        textPass=v.findViewById(R.id.editTextPassword)
        btnLogin=v.findViewById(R.id.buttonLogin)
        btnNew=v.findViewById(R.id.buttonNew)
        listOfuser.add(User("marcelo","1234"))
        listOfuser.add(User("prueba","password"))

        return v
    }

    override fun onStart() {
        super.onStart()
        btnLogin.setOnClickListener {

            var intent = Intent(context, MainActivity::class.java)
            startActivity(intent)
        }
        btnNew.setOnClickListener {
            val action = LoginFragmentDirections.actionLoginFragmentToCreateUserFragment()
            findNavController().navigate(action)
        }

    }



}