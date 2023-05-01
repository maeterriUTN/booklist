package com.utn.booklist.fragments

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.material.snackbar.Snackbar
import com.utn.booklist.R

class BookDetailFragment : Fragment() {

    lateinit var v : View
    var arg : Int = 0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        v = inflater.inflate(R.layout.fragment_book_detail, container, false)
        return v
    }

    override fun onStart() {
        super.onStart()
        arg = BookDetailFragmentArgs.fromBundle(requireArguments()).Argumento
        Snackbar.make(v, "click en $arg", Snackbar.LENGTH_LONG).show()

    }


}