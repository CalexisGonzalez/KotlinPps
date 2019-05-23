package com.example.kotlinpps.mvp.view

import android.app.Activity
import android.widget.Toast
import com.example.kotlinpps.R
import com.example.kotlinpps.mvp.contract.SignInContract
import kotlinx.android.synthetic.main.activity_sign_in.*
import java.lang.ref.WeakReference

class SignInView(activity: Activity) : SignInContract.View {
    private val activity: WeakReference<Activity> = WeakReference(activity)

    override val email: String
        get() = activity.get()!!.signup_activity_text_email.text.toString()
    override val password: String
        get() = activity.get()!!.signup_activity_text_password.text.toString()
    override val repPassword: String
        get() = activity.get()!!.signup_activity_text_pass_rep.text.toString()
    override val name: String
        get() = activity.get()!!.signup_activity_text_name.text.toString()
    override val surname: String
        get() = activity.get()!!.signup_activity_text_surname.text.toString()

    override fun passwordRepMatchError() {
        Toast.makeText(activity.get(), R.string.error_passwordrep_badmatch, Toast.LENGTH_SHORT).show()
    }

    override fun missingFieldError() {
        Toast.makeText(activity.get(), R.string.error_signup_missing_field, Toast.LENGTH_SHORT).show()
    }

    override fun onCancel() {
        activity.get()!!.finish()
    }

    override fun userAlreadyExists() {
        Toast.makeText(activity.get(), R.string.error_user_already_exists, Toast.LENGTH_SHORT).show()
    }

    override fun succesfulSignUp() {
        Toast.makeText(activity.get(), R.string.msg_on_valid_signup, Toast.LENGTH_SHORT).show()
        activity.get()!!.finish()
    }

    override fun emailFormatError() {
        Toast.makeText(activity.get(), R.string.error_emailformat, Toast.LENGTH_SHORT).show()
    }
}
