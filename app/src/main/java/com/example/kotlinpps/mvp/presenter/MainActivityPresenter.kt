package com.example.kotlinpps.mvp.presenter

import android.content.Intent
import com.example.kotlinpps.ZERO
import com.example.kotlinpps.database.User
import com.example.kotlinpps.mvp.contract.MainActivityContract
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.common.api.ApiException


class MainActivityPresenter(val view: MainActivityContract.View, val model: MainActivityContract.Model) :
    MainActivityContract.Presenter {
    private var user: User? = null

    init {
        if (model.getPreferencesId() != ZERO) {
            view.onLogInSuccess(model.getGoogleSignInOptions())
        }
    }

    override fun onGoogleButtonPressed() {
        view.onGoogleButtonPressed(model.getGoogleSignInOptions())
    }

    override fun onGoogleCallback(data: Intent) {
        try {
            val account = GoogleSignIn.getSignedInAccountFromIntent(data).getResult(ApiException::class.java)!!
            user = User(
                account.email!!, ZERO.toString(), account.displayName!!,
                account.familyName, null, account.id!!.toDouble()
            )
            if (!model.userExist(user!!)) {
                model.signInUser(user!!)
            }
            model.logInUser(user!!)
            view.onLogInSuccess(model.getGoogleSignInOptions())
        } catch (e: ApiException) {
            view.onExternalFailure()
        }
    }

    override fun onLogInPressed() {
        if (model.userExist(User(view.getEmail(), ZERO.toDouble()))) {
            if (model.userLogInValid(User(view.getEmail(), view.getPassword()))) {
                model.logInUser(User(view.getEmail(), view.getPassword()))
                view.onLogInSuccess(model.getGoogleSignInOptions())
            } else {
                view.onLocalPasswordFailure()
            }
        } else {
            view.onLocalEmailFailure()
        }
    }

    override fun onSignInPressed() {
        view.onSignInPressed()
    }
}
