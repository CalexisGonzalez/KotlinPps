package com.example.kotlinpps.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.kotlinpps.database.UserRoomDatabase
import com.example.kotlinpps.mvp.contract.SignInContract
import com.example.kotlinpps.mvp.model.SignInModel
import com.example.kotlinpps.mvp.presenter.SignInPresenter
import com.example.kotlinpps.mvp.view.SignInView
import kotlinx.android.synthetic.main.activity_sign_in.*

class SignInActivity : AppCompatActivity() {
    private lateinit var presenter: SignInContract.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(com.example.kotlinpps.R.layout.activity_sign_in)
        presenter = SignInPresenter(SignInView(this), SignInModel(UserRoomDatabase.getDatabase(this)))
        signup_activity_button_cancel.setOnClickListener { presenter.onCancelPressed() }
        signup_activity_button_signup.setOnClickListener { presenter.onSignUpPressed() }
    }
}
