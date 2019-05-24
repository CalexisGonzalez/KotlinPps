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
        activity.get()?.let {
            val signInIntent = GoogleSignIn.getClient(it, googleSignInOptions).signInIntent
            it.startActivityForResult(signInIntent, GOOGLE_SIGN_IN)
        }
    }

    override fun onExternalFailure() {
        showToast(R.string.external_log_in_error)
    }

    override fun onLocalEmailFailure() {
        showToast(R.string.local_email_error)
    }

    override fun onLocalPasswordFailure() {
        showToast(R.string.local_log_in_error)
    }

    override fun onLogInSuccess(gso: GoogleSignInOptions) {
        val intent = Intent(activity.get(), MainScreenActivity::class.java)
            .putExtra(GOOGLE_OPTIONS, gso)
        activity.get()?.startActivity(intent)
    }

    override fun getEmail(): String {
        return activity.get()?.main_activity_mail?.text.toString()
    }

    override fun getPassword(): String {
        return activity.get()?.main_activity_password?.text.toString()
    }

    override fun onSignInPressed() {
        activity.get()?.startActivity(Intent(activity.get(), SignInActivity::class.java))
    }

    private fun showToast(message: Int) {
        Toast.makeText(activity.get(), message, Toast.LENGTH_SHORT).show()
    }
}
