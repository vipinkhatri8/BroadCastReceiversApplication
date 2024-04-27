package com.example.broadcastreceiversapplication

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast

class BroadCastExample : BroadcastReceiver() {

    //in the manifest file , we defined out receiver to respond to the airplane mode broadcast
    //this is an example of a system - application broadcast receiver using the manifest registered broadcast method
    //this broadcast method works only for API 25 and lower
    override fun onReceive(context: Context?, intent: Intent?) {

        //but we need to first know the boolean state of the airplane mode of the device
        val isAirPlaneMode : Boolean = intent!!.getBooleanExtra("State",false)
        if(isAirPlaneMode){
            Toast.makeText(context, "The airplane mode is active on this device.", Toast.LENGTH_LONG).show()

        }else{
            Toast.makeText(context, "The airplane mode is not active on this device.", Toast.LENGTH_LONG).show()
        }

    }
}