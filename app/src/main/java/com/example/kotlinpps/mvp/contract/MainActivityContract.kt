package com.example.kotlinpps.mvp.contract

import android.content.Intent
import com.example.kotlinpps.database.User
import com.facebook.CallbackManager
import com.google.android.gms.auth.api.signin.GoogleSignInOptions


interface MainActivityContract {
    interface Presenter {
        fun onGoogleButtonPressed()
        fun onGoogleCallback(data: Intent)
        fun onLogInPressed()
        fun onSignInPressed()
        fun onFacebookButtonPressed()
        fun onFacebookCallback(requestCode: Int, resultCode: Int, data: Intent)
    }

    interface Model {
        fun getGoogleSignInOptions(): GoogleSignInOptions
        fun userExist(user: User): Boolean
        fun signInUser(user: User)
        fun logInUser(user: User)
        fun userLogInValid(user: User): Boolean
        fun getUserId(user: User): Int
        fun getPreferencesId(): Int
        fun getFBCallbackManager(): CallbackManager
    }

    interface View {
        fun onGoogleButtonPressed(googleSignInOptions: GoogleSignInOptions)
        fun onLogInSuccess(gso: GoogleSignInOptions)
        fun onExternalFailure()
        fun onLocalEmailFailure()
        fun onLocalPasswordFailure()
        fun getEmail(): String
        fun getPassword(): String
        fun onSignInPressed()
    }
}
