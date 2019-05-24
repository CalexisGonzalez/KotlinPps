package com.example.kotlinpps.database.DbQuery

import android.os.AsyncTask
import com.example.kotlinpps.ZERO
import com.example.kotlinpps.database.User
import com.example.kotlinpps.database.UserDao
import java.util.concurrent.ExecutionException

class DbFetchUserId(private val userDao: UserDao) : AsyncTask<User, Void, Int>(), DbGenericQuery<Int, User> {

    override fun doInBackground(vararg users: User): Int {
        return userDao.fetchUserId(users[ZERO].mail, users[ZERO].socialId)
    }

    override fun executeQuery(user: User): Int {
        try {
            return this.execute(user).get()
        } catch (e: ExecutionException) {
            e.printStackTrace()
        } catch (e: InterruptedException) {
            e.printStackTrace()
        }

        return ZERO
    }
}
