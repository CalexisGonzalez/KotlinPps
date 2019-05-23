package com.example.kotlinpps.database.DbQuery

interface DbGenericQuery<T, S> {
    fun executeQuery(parametertype: S?): T?
}
