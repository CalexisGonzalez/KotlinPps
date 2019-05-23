package com.example.kotlinpps.database

import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey
import com.example.kotlinpps.USER_TABLE
import com.example.kotlinpps.ZERO

@Entity(tableName = USER_TABLE)
data class User(
    @PrimaryKey(autoGenerate = true)
    var id: Int?,
    var mail: String,
    var password: String,
    var name: String?,
    var surname: String?,
    var imageUrl: String?,
    var socialId: Double
) {

    constructor(mail: String, password: String, name: String, surname: String?, imageUrl: String?, socialId: Double)
            : this(null, mail, password, name, surname, imageUrl, socialId) {
        this.mail = mail
        this.password = password
        this.name = name
        this.surname = surname
        this.imageUrl = imageUrl
        this.socialId = socialId
    }

    @Ignore
    constructor(mail: String, password: String) :
            this(null, mail, password, null, null, null, ZERO.toDouble()) {
        this.mail = mail
        this.password = password
    }

    @Ignore
    constructor(mail: String, socialId: Double) :
            this(null, mail, ZERO.toString(), null, null, null, socialId) {
        this.mail = mail
        this.socialId = socialId
    }
}
