package com.example.kotlinpps.mvp.contract

import com.example.kotlinpps.database.User

interface SignInContract {
    interface Presenter {
        fun onSignUpPressed()

        fun onCancelPressed()
    }

    interface Model {
        fun registrateUser(user: User)

        fun userDoesExist(user: User): Boolean
    }

    interface View {
        val email: String

        val password: String

        val repPassword: String

        val name: String

        val surname: String

        fun passwordRepMatchError()

        fun missingFieldError()

        fun onCancel()

        fun userAlreadyExists()

        fun succesfulSignUp()

        fun emailFormatError()
    }
}
