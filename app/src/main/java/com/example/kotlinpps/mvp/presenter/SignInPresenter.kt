package com.example.kotlinpps.mvp.presenter

import com.example.kotlinpps.DEFAULT_AVATAR_URL
import com.example.kotlinpps.EMAIL_FORMAT
import com.example.kotlinpps.EMPTY
import com.example.kotlinpps.ZERO
import com.example.kotlinpps.database.User
import com.example.kotlinpps.mvp.contract.SignInContract
import java.util.regex.Pattern

class SignInPresenter(val view: SignInContract.View, val model: SignInContract.Model) : SignInContract.Presenter {
    override fun onSignUpPressed() {
        if (fieldMissing()) {
            view.missingFieldError()
        } else if (!isEmailValid(view.email)) {
            view.emailFormatError()
        } else if (view.password != view.repPassword) {
            view.passwordRepMatchError()
        } else {
            val user = User(
                view.email, view.password,
                view.name, view.surname, DEFAULT_AVATAR_URL, ZERO.toDouble()
            )
            if (model.userDoesExist(user)) {
                view.userAlreadyExists()
            } else {
                model.registrateUser(user)
                view.succesfulSignUp()
            }
        }
    }

    override fun onCancelPressed() {
        view.onCancel()
    }

    private fun fieldMissing(): Boolean {
        return view.email == EMPTY || view.password == EMPTY || view.repPassword == EMPTY
                || view.name == EMPTY || view.surname == EMPTY
    }

    private fun isEmailValid(email: String): Boolean {
        val expression = EMAIL_FORMAT
        val pattern = Pattern.compile(expression, Pattern.CASE_INSENSITIVE)
        val matcher = pattern.matcher(email)
        return matcher.matches()
    }
}
