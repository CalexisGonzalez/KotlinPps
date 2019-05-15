package com.example.kotlinpps.mvp.contract

interface MainActivityContract {
    interface Presenter {
        fun onButtonPressed()
    }

    interface Model {

    }

    interface View {
        fun onButtonPressed()
    }
}
