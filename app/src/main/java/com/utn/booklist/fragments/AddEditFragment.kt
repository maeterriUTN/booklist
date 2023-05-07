package com.utn.booklist.fragments

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import com.utn.booklist.R

class AddEditFragment : Fragment() {

    var arg : Int = 0
    lateinit var editTitle : EditText
    lateinit var editAuthor : EditText
    lateinit var editYear : EditText
    lateinit var editDescription : EditText
    lateinit var editURL : EditText

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        var v= inflater.inflate(R.layout.fragment_add_edit, container, false)
        editTitle=v.findViewById(R.id.editTextTitle)
        return v
    }

    override fun onStart() {
        super.onStart()
        arg = AddEditFragmentArgs.fromBundle(requireArguments()).arg2
        editTitle.setText("Prueba")



    }



}