package com.example.themoviedb

import android.content.Context
import android.content.SharedPreferences

object Preferances {
    private const val PREFERENCES_NAME = "preference"
    private const val KEY = "user_key"

    private fun getPreferences(context: Context): SharedPreferences {
        return context.getSharedPreferences(PREFERENCES_NAME, Context.MODE_PRIVATE)
    }

    fun setLogin(context: Context, login: String, password: String) {
        val prefs =
            getPreferences(
                context
            )
        prefs.edit().putString(login, "$login $password").apply()
    }

    fun getLogin(context: Context, login: String, password: String): Boolean {
        val prefs =
            getPreferences(
                context
            )
        prefs.all.forEach {
            if (it.key == login) {
                if (it.value.toString().startsWith(login) && it.value.toString().contains(password))
                    return true
            }
        }
        return false
    }
    fun setUser(context: Context, login: String){
        val prefs = getPreferences(context)
        prefs.edit().putString(KEY,login).apply()
    }
    fun getUser(context: Context): String? {
        val prefs =
            getPreferences(
                context
            )
       return prefs.getString(KEY,"")

    }
}
