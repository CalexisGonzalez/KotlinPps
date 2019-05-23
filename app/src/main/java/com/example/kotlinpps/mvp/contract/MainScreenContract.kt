package com.example.kotlinpps.mvp.contract

import com.example.kotlinpps.database.User

interface MainScreenContract {
    interface Presenter {
        fun onLogOutPressed()
        fun onBackPressed()
    }

    interface Model {
        fun getUserData(): User?
        fun logOut()
    }

    interface View {
        fun onLogOutPressed()
        fun onBackPressed()
        fun setData(email: String, name: String?, surname: String?, password: String)
    }
}
