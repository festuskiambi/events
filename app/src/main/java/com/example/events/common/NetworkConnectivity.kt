package com.example.events.common

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkInfo

/**
 * Created by Festus Kiambi on 9/5/19.
 */
class NetworkConnectivity (private val context: Context) {

    fun isConnected(): Boolean {

        val connectivity = context.getSystemService(
            Context.CONNECTIVITY_SERVICE
        ) as ConnectivityManager

        if (connectivity != null){
           val  info= connectivity.allNetworkInfo

            if(info !=null){
                for (i in info.indices){
                    if (info[i].state == NetworkInfo.State.CONNECTED) return true
                }
            }
        }

        return false
    }

}