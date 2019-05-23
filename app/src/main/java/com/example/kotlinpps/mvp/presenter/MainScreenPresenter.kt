package com.example.kotlinpps.mvp.presenter

import com.example.kotlinpps.mvp.contract.MainScreenContract

class MainScreenPresenter(val view: MainScreenContract.View, val model: MainScreenContract.Model) :
    MainScreenContract.Presenter {
    init {
        val user = model.getUserData()
        view.setData(user.mail, user.name, user.surname, user.password)
    }

    override fun onLogOutPressed() {
        model.logOut()
        view.onLogOutPressed()
    }

    override fun onBackPressed() {
        view.onBackPressed()
    }
}
