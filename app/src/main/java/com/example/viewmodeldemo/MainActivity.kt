package com.example.viewmodeldemo

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.ViewModelProvider

class MainActivity : AppCompatActivity(), LifecycleOwner {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var button = findViewById<Button>(R.id.button)
        var textView = findViewById<TextView>(R.id.textView)

        var viewModel = ViewModelProvider(this).get(MainActivityViewModel::class.java)
        textView.text = viewModel.number.toString()

        button.setOnClickListener {
            viewModel.addNumber()
            textView.text = viewModel.number.toString()
        }
    }
}