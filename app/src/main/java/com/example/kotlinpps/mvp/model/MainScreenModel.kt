package com.example.kotlinpps.mvp.model

import android.content.SharedPreferences
import com.example.kotlinpps.USER_PREFERENCES_ID
import com.example.kotlinpps.ZERO
import com.example.kotlinpps.database.DbQuery.DbFetchUserData
import com.example.kotlinpps.database.User
import com.example.kotlinpps.database.UserRoomDatabase
import com.example.kotlinpps.mvp.contract.MainScreenContract
import com.google.android.gms.auth.api.signin.GoogleSignInClient

class MainScreenModel(
    private val preferences: SharedPreferences, private val db: UserRoomDatabase,
    private val googleClient: GoogleSignInClient
) : MainScreenContract.Model {
    override fun getUserData(): User {
        return DbFetchUserData(db.userDao()).executeQuery(preferences.getInt(USER_PREFERENCES_ID, ZERO))!!
    }

    override fun logOut() {
        googleClient.signOut()
        val editor: SharedPreferences.Editor = preferences.edit()
        editor.putInt(USER_PREFERENCES_ID, ZERO)
        editor.apply()
    }
}
