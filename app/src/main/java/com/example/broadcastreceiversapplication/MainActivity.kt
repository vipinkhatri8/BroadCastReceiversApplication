package com.example.broadcastreceiversapplication

import android.content.Intent
import android.content.IntentFilter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {

    //using the context registered Broadcast receiver method
    //we remove the permissions in the manifest file and define the code for the
    //context of usage of the Broadcast receiver method in the main activity as followsw
    //I haven't removed the permissions in the manifest, but dont forget to do so when using the
    //context registered Boradcast receiver

    var br = BroadCastExample()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //we define an intent with the broadcast receiver method
        val filter = IntentFilter()
        filter.addAction(Intent.ACTION_AIRPLANE_MODE_CHANGED)
        this.registerReceiver(br,filter)
    }

    //to launch the Broacast receiver when lauching tha app
    override fun onStart() {
        super.onStart()
        val filter = IntentFilter()
        filter.addAction(Intent.ACTION_AIRPLANE_MODE_CHANGED)
        this.registerReceiver(br,filter)

    }

    //this is so that the app doesn't take any Broadcast receiver messages anymore when it closes or switches to another app

    override fun onStop() {
        super.onStop()
        this.unregisterReceiver(br)
    }
}