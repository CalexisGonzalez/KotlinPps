package com.example.kotlinpps.mvp.presenter

import android.content.Intent
import com.example.kotlinpps.ZERO
import com.example.kotlinpps.database.User
import com.example.kotlinpps.mvp.contract.MainActivityContract
import com.facebook.AccessToken
import com.facebook.FacebookCallback
import com.facebook.FacebookException
import com.facebook.login.LoginManager
import com.facebook.login.LoginResult
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.common.api.ApiException


class MainActivityPresenter(val view: MainActivityContract.View, val model: MainActivityContract.Model) :
    MainActivityContract.Presenter {

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
            GoogleSignIn.getSignedInAccountFromIntent(data).getResult(ApiException::class.java)?.let {
                it.email?.let { it1 ->
                    val user = User(
                        it1, ZERO.toString(), it.displayName,
                        it.familyName, null, it.id?.toDouble() ?: ZERO.toDouble()
                    )
                    if (!model.userExist(user)) {
                        model.signInUser(user)
                    }
                    model.logInUser(user)
                    view.onLogInSuccess(model.getGoogleSignInOptions())
                }
            }

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

    override fun onFacebookButtonPressed() {
        LoginManager.getInstance()
            .registerCallback(model.getFBCallbackManager(), object : FacebookCallback<LoginResult> {
                override fun onSuccess(result: LoginResult?) {
                    
                }

                override fun onCancel() {
                    view.onExternalFailure()
                }

                override fun onError(error: FacebookException?) {
                    view.onExternalFailure()
                }
            })
    }

    override fun onFacebookCallback(requestCode: Int, resultCode: Int, data: Intent) {
        model.getFBCallbackManager().onActivityResult(requestCode,resultCode,data)
    }
}
