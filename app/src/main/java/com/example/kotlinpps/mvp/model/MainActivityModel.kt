package com.example.kotlinpps.mvp.model

import android.content.SharedPreferences
import com.example.kotlinpps.USER_PREFERENCES_ID
import com.example.kotlinpps.ZERO
import com.example.kotlinpps.database.DbQuery.DbFetchUserId
import com.example.kotlinpps.database.DbQuery.DbInsertUser
import com.example.kotlinpps.database.DbQuery.DbQueryLocalUserValid
import com.example.kotlinpps.database.DbQuery.DbQueryUserExist
import com.example.kotlinpps.database.User
import com.example.kotlinpps.database.UserRoomDatabase
import com.example.kotlinpps.mvp.contract.MainActivityContract
import com.google.android.gms.auth.api.signin.GoogleSignInOptions

class MainActivityModel(private val preferences: SharedPreferences, private val db: UserRoomDatabase) :
    MainActivityContract.Model {
    private val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
        .requestEmail()
        .build()

    override fun getGoogleSignInOptions(): GoogleSignInOptions {
        return gso
    }

    override fun userExist(user: User): Boolean {
        return DbQueryUserExist(db.userDao()).executeQuery(user)
    }

    override fun signInUser(user: User) {
        DbInsertUser(db.userDao()).executeQuery(user)
    }

    override fun logInUser(user: User) {
        val editor: SharedPreferences.Editor = preferences.edit()
        editor.putInt(USER_PREFERENCES_ID, getUserId(user))
        editor.apply()
    }

    override fun userLogInValid(user: User): Boolean {
        return DbQueryLocalUserValid(db.userDao()).executeQuery(user)
    }

    override fun getUserId(user: User): Int {
        return DbFetchUserId(db.userDao()).executeQuery(user)
    }

    override fun getPreferencesId(): Int {
        return preferences.getInt(USER_PREFERENCES_ID, ZERO)
    }
}
