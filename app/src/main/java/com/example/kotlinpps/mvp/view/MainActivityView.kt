package com.example.kotlinpps.mvp.view

import android.app.Activity
import android.content.Intent
import android.widget.Toast
import com.example.kotlinpps.GOOGLE_OPTIONS
import com.example.kotlinpps.GOOGLE_SIGN_IN
import com.example.kotlinpps.R
import com.example.kotlinpps.activity.MainScreenActivity
import com.example.kotlinpps.activity.SignInActivity
import com.example.kotlinpps.mvp.contract.MainActivityContract
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import kotlinx.android.synthetic.main.activity_main.*
import java.lang.ref.WeakReference

class MainActivityView(activity: Activity) : MainActivityContract.View {
    private val activity: WeakReference<Activity> = WeakReference(activity)

    override fun onGoogleButtonPressed(googleSignInOptions: GoogleSignInOptions) {
        val signInIntent = GoogleSignIn.getClient(activity.get()!!, googleSignInOptions).signInIntent
        activity.get()!!.startActivityForResult(signInIntent, GOOGLE_SIGN_IN)
    }

    override fun onExternalFailure() {
        Toast.makeText(activity.get(), R.string.external_log_in_error, Toast.LENGTH_SHORT).show()
    }

    override fun onLocalEmailFailure() {
        Toast.makeText(activity.get(), R.string.local_email_error, Toast.LENGTH_SHORT).show()
    }

    override fun onLocalPasswordFailure() {
        Toast.makeText(activity.get(), R.string.local_log_in_error, Toast.LENGTH_SHORT).show()
    }

    override fun onLogInSuccess(gso: GoogleSignInOptions) {
        val intent = Intent(activity.get(), MainScreenActivity::class.java)
            .putExtra(GOOGLE_OPTIONS, gso)
        activity.get()!!.startActivity(intent)
    }

    override fun getEmail(): String {
        return activity.get()!!.main_activity_mail.text.toString()
    }

    override fun getPassword(): String {
        return activity.get()!!.main_activity_password.text.toString()
    }

    override fun onSignInPressed() {
        activity.get()!!.startActivity(Intent(activity.get(), SignInActivity::class.java))
    }
}
