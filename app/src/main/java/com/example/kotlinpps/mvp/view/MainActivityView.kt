package com.example.kotlinpps.mvp.view

import android.app.Activity
import android.widget.Toast
import com.example.kotlinpps.R
import com.example.kotlinpps.mvp.contract.MainActivityContract
import kotlinx.android.synthetic.main.activity_main.*
import java.lang.ref.WeakReference

class MainActivityView(activity: Activity) : MainActivityContract.View {
    private val activity: WeakReference<Activity> = WeakReference(activity)

    override fun onButtonPressed() {
        Toast.makeText(activity.get(), R.string.app_name,Toast.LENGTH_LONG).show()
    }
}
