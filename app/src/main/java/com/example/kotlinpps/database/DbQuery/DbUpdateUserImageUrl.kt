package com.example.kotlinpps.database.DbQuery

import android.os.AsyncTask
import com.example.kotlinpps.ZERO
import com.example.kotlinpps.database.UserDao

class DbUpdateUserImageUrl(private val userDao: UserDao) : AsyncTask<DbUpdateImagePojo, Void, Void>(),
    DbGenericQuery<Void, DbUpdateImagePojo> {

    override fun doInBackground(vararg images: DbUpdateImagePojo): Void? {
        val image = images[ZERO]
        userDao.updateImageUrl(image.userId, image.imageUrl)
        return null
    }

    override fun executeQuery(user: DbUpdateImagePojo?): Void? {
        this.execute(user)
        return null
    }
}
