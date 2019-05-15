package com.example.kotlinpps.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.kotlinpps.R
import com.example.kotlinpps.mvp.model.MainActivityModel
import com.example.kotlinpps.mvp.presenter.MainActivityPresenter
import com.example.kotlinpps.mvp.view.MainActivityView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private var presenter: MainActivityPresenter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        presenter = MainActivityPresenter(MainActivityView(this),MainActivityModel())
        main_activity_sample_button.setOnClickListener { presenter!!.onButtonPressed() }
    }
}
