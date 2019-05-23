package com.example.kotlinpps.database.DbQuery

import android.os.AsyncTask
import com.example.kotlinpps.ZERO
import com.example.kotlinpps.database.User
import com.example.kotlinpps.database.UserDao


class DbInsertUser(private val userDao: UserDao) : AsyncTask<User, Void, Void>(), DbGenericQuery<Void, User> {
    override fun executeQuery(user: User?): Void? {
        this.execute(user)
        return null
    }

    override fun doInBackground(vararg users: User?): Void? {
        userDao.insert(users[ZERO]!!)
        return null
    }
}
