package com.example.kotlinpps.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface UserDao {
    @Insert
    fun insert(user: User)

    @Query("SELECT * FROM userTable  WHERE id == :userId")
    fun fetchUserData(userId: Int): User

    @Query("SELECT COUNT(*) from userTable WHERE mail == :userEmail  AND socialId == :socialId")
    fun fetchUserExist(userEmail: String, socialId: Double): Int

    @Query("SELECT COUNT(*) from userTable WHERE mail == :userEmail AND password == :userPassword")
    fun fetchUserLocalLogInValid(userEmail: String, userPassword: String): Int

    @Query("UPDATE userTable SET password = :userPassword, name = :userName, surname = :userSurname WHERE id == :id")
    fun updateTable(id: Int, userPassword: String, userName: String, userSurname: String)

    @Query("SELECT id FROM userTable WHERE mail == :userEmail AND socialId == :socialId")
    fun fetchUserId(userEmail: String, socialId: Double): Int

    @Query("SELECT imageUrl FROM userTable WHERE id == :userId")
    fun fetchImageUrl(userId: Int): String

    @Query("UPDATE userTable SET imageUrl = :imageUrl WHERE id == :userId")
    fun updateImageUrl(userId: Int, imageUrl: String)
}
