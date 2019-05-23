package com.example.kotlinpps.activity

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.kotlinpps.GOOGLE_SIGN_IN
import com.example.kotlinpps.SHARED_PREFERENCE
import com.example.kotlinpps.database.UserRoomDatabase
import com.example.kotlinpps.mvp.contract.MainActivityContract
import com.example.kotlinpps.mvp.model.MainActivityModel
import com.example.kotlinpps.mvp.presenter.MainActivityPresenter
import com.example.kotlinpps.mvp.view.MainActivityView
import com.facebook.stetho.Stetho
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    private lateinit var presenter: MainActivityContract.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Stetho.initializeWithDefaults(this)
        setContentView(com.example.kotlinpps.R.layout.activity_main)
        presenter =
            MainActivityPresenter(
                MainActivityView(this),
                MainActivityModel(
                    getSharedPreferences(SHARED_PREFERENCE, Context.MODE_PRIVATE),
                    UserRoomDatabase.getDatabase(this)
                )
            )
        main_activity_google_login.setOnClickListener { presenter.onGoogleButtonPressed() }
        main_activity_btn_log_in.setOnClickListener { presenter.onLogInPressed() }
        main_activity_btn_sign_up.setOnClickListener { presenter.onSignInPressed() }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == GOOGLE_SIGN_IN) {
            data?.let { presenter.onGoogleCallback(it) }
        }
    }
}
