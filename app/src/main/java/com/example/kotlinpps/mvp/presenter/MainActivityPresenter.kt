package com.example.kotlinpps.mvp.presenter

import com.example.kotlinpps.mvp.contract.MainActivityContract

class MainActivityPresenter(val view: MainActivityContract.View, val model: MainActivityContract.Model) :
    MainActivityContract.Presenter{

    override fun onButtonPressed() {
        view.onButtonPressed()
    }
}
