package com.example.kotlinpps.database.DbQuery

import android.os.AsyncTask
import com.example.kotlinpps.ZERO
import com.example.kotlinpps.database.User
import com.example.kotlinpps.database.UserDao
import java.util.concurrent.ExecutionException


class DbFetchUserData(private val userDao: UserDao) : AsyncTask<Int, Void, User>(), DbGenericQuery<User?, Int> {

    override fun doInBackground(vararg params: Int?): User? {
        return params[ZERO]?.let { userDao.fetchUserData(it) }
    }

    override fun executeQuery(id: Int): User? {
        try {
            return this.execute(id).get()
        } catch (e: ExecutionException) {
            e.printStackTrace()
        } catch (e: InterruptedException) {
            e.printStackTrace()
        }
        return null
    }
}
