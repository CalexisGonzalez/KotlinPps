package com.example.kotlinpps.database.DbQuery

import android.os.AsyncTask
import com.example.kotlinpps.ZERO
import com.example.kotlinpps.database.User
import com.example.kotlinpps.database.UserDao

class DbUpdateUserData(private val userDao: UserDao) : AsyncTask<User, Void, Void>(), DbGenericQuery<Void, User> {

    override fun doInBackground(vararg users: User): Void? {
        val user = users[ZERO]
        userDao.updateTable(user.id!!, user.password, user.name!!, user.surname!!)
        return null
    }

    override fun executeQuery(user: User?): Void? {
        this.execute(user)
        return null
    }
}
