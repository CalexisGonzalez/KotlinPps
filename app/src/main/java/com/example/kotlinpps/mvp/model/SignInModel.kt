package com.example.kotlinpps.mvp.model

import com.example.kotlinpps.database.DbQuery.DbInsertUser
import com.example.kotlinpps.database.DbQuery.DbQueryUserExist
import com.example.kotlinpps.database.User
import com.example.kotlinpps.database.UserRoomDatabase
import com.example.kotlinpps.mvp.contract.SignInContract

class SignInModel(private val db: UserRoomDatabase) : SignInContract.Model {
    override fun registrateUser(user: User) {
        DbInsertUser(db.userDao()).executeQuery(user)
    }

    override fun userDoesExist(user: User): Boolean {
        return DbQueryUserExist(db.userDao()).executeQuery(user)
    }
}
