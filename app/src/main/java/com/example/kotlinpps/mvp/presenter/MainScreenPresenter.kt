package com.example.kotlinpps.mvp.presenter

import com.example.kotlinpps.mvp.contract.MainScreenContract

class MainScreenPresenter(val view: MainScreenContract.View, val model: MainScreenContract.Model) :
    MainScreenContract.Presenter {
    init {
        model.getUserData()?.let {
            view.setData(it.mail, it.name, it.surname, it.password)
        }
    }

    override fun onLogOutPressed() {
        model.logOut()
        view.onLogOutPressed()
    }

    override fun onBackPressed() {
        view.onBackPressed()
    }
}
