package com.example.kotlinpps.mvp.view

import android.app.Activity
import android.content.Intent
import com.example.kotlinpps.mvp.contract.MainScreenContract
import kotlinx.android.synthetic.main.activity_main_screen.*
import java.lang.ref.WeakReference

class MainScreenView(activity: Activity) : MainScreenContract.View {
    private val activity: WeakReference<Activity> = WeakReference(activity)

    override fun onLogOutPressed() {
        activity.get()?.finish()
    }

    override fun onBackPressed() {
        val intent = Intent(Intent.ACTION_MAIN)
        intent.addCategory(Intent.CATEGORY_HOME).setFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
        activity.get()?.startActivity(intent)
    }

    override fun setData(email: String, name: String?, surname: String?, password: String) {
        activity.get()?.mainscreen_activity_email?.text = email
        activity.get()?.mainscreen_activity_surname?.text = surname
        activity.get()?.mainscreen_activity_name?.text = name
        activity.get()?.mainscreen_activity_password?.text = password
    }
}
