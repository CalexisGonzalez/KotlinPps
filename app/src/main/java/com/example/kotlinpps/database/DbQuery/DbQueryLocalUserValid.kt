package com.example.kotlinpps.database.DbQuery

import android.os.AsyncTask
import com.example.kotlinpps.ONE
import com.example.kotlinpps.ZERO
import com.example.kotlinpps.database.User
import com.example.kotlinpps.database.UserDao
import java.util.concurrent.ExecutionException

class DbQueryLocalUserValid(private val userDao: UserDao) : AsyncTask<User, Void, Boolean>(),
    DbGenericQuery<Boolean, User> {

    override fun doInBackground(vararg users: User): Boolean? {
        return userDao.fetchUserLocalLogInValid(
            users[ZERO].mail,
            users[ZERO].password
        ) == ONE
    }

    override fun executeQuery(user: User?): Boolean? {
        try {
            return this.execute(user).get()
        } catch (e: ExecutionException) {
            e.printStackTrace()
        } catch (e: InterruptedException) {
            e.printStackTrace()
        }
        return false
    }
}
