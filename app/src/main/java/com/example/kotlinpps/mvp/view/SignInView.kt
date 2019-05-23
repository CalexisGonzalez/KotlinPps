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
        get() = activity.get()?.signup_activity_text_email?.text.toString()
    override val password: String
        get() = activity.get()?.signup_activity_text_password?.text.toString()
    override val repPassword: String
        get() = activity.get()?.signup_activity_text_pass_rep?.text.toString()
    override val name: String
        get() = activity.get()?.signup_activity_text_name?.text.toString()
    override val surname: String
        get() = activity.get()?.signup_activity_text_surname?.text.toString()

    override fun passwordRepMatchError() {
        showToast(R.string.error_passwordrep_badmatch)
    }

    override fun missingFieldError() {
        showToast(R.string.error_signup_missing_field)
    }

    override fun onCancel() {
        activity.get()?.finish()
    }

    override fun userAlreadyExists() {
        showToast(R.string.error_user_already_exists)
    }

    override fun succesfulSignUp() {
        showToast(R.string.msg_on_valid_signup)
        activity.get()?.finish()
    }

    override fun emailFormatError() {
        showToast(R.string.error_emailformat)
    }

    private fun showToast(message: Int) {
        Toast.makeText(activity.get(), message, Toast.LENGTH_SHORT).show()
    }
}
