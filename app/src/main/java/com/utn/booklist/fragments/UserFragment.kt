package com.utn.booklist.fragments

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.utn.booklist.R
import com.utn.booklist.activities.LoginActivity

class UserFragment : Fragment() {

    lateinit var v : View

    lateinit var btnLogout : Button
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        v= inflater.inflate(R.layout.fragment_user, container, false)

        btnLogout=v.findViewById(R.id.buttonLogout)


        return v
    }

    override fun onStart() {
        super.onStart()
        btnLogout.setOnClickListener {
            var intent = Intent(context, LoginActivity::class.java)
            startActivity(intent)
        }
    }

}