package com.example.kotlinpps.activity

import android.content.Context
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.kotlinpps.GOOGLE_OPTIONS
import com.example.kotlinpps.SHARED_PREFERENCE
import com.example.kotlinpps.database.UserRoomDatabase
import com.example.kotlinpps.mvp.contract.MainScreenContract
import com.example.kotlinpps.mvp.model.MainScreenModel
import com.example.kotlinpps.mvp.presenter.MainScreenPresenter
import com.example.kotlinpps.mvp.view.MainScreenView
import com.google.android.gms.auth.api.signin.GoogleSignIn
import kotlinx.android.synthetic.main.activity_main_screen.*

class MainScreenActivity : AppCompatActivity() {
    lateinit private var presenter: MainScreenContract.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(com.example.kotlinpps.R.layout.activity_main_screen)
        presenter = MainScreenPresenter(
            MainScreenView(this),
            MainScreenModel(
                getSharedPreferences(SHARED_PREFERENCE, Context.MODE_PRIVATE),
                UserRoomDatabase.getDatabase(this),
                GoogleSignIn.getClient(this, intent.getParcelableExtra(GOOGLE_OPTIONS))
            )
        )
        mainscreen_btn_logout.setOnClickListener { presenter.onLogOutPressed() }
    }
}
