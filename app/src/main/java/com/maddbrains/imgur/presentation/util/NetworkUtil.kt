package com.maddbrains.imgur.presentation.util

import android.content.Context
import android.net.ConnectivityManager

class NetworkUtil {

    companion object {
        fun isConnectedToInternet(context: Context): Boolean {
            val appContext = context.applicationContext
            val connectivityManager =
                appContext.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
            val networkInfo = connectivityManager.activeNetwork
            return networkInfo != null
        }
    }
}