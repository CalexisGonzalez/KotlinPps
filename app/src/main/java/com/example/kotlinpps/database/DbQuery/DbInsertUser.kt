package com.example.kotlinpps.database.DbQuery

import android.os.AsyncTask
import com.example.kotlinpps.ZERO
import com.example.kotlinpps.database.User
import com.example.kotlinpps.database.UserDao


class DbInsertUser(private val userDao: UserDao) : AsyncTask<User, Void, Void>(), DbGenericQuery<Unit, User> {
    override fun executeQuery(user: User) {
        this.execute(user)
    }

    override fun doInBackground(vararg users: User): Void? {
        userDao.insert(users[ZERO])
        return null
    }
}
