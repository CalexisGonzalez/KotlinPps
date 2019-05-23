package com.example.kotlinpps.database.DbQuery

import android.os.AsyncTask
import com.example.kotlinpps.ZERO
import com.example.kotlinpps.database.UserDao
import java.util.concurrent.ExecutionException

class DbFetchUserImageUrl(private val userDao: UserDao) : AsyncTask<Int, Void, String>(), DbGenericQuery<String, Int> {

    override fun doInBackground(vararg ids: Int?): String? {
        return userDao.fetchImageUrl(ids[ZERO]!!)
    }

    override fun executeQuery(id: Int?): String? {
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
