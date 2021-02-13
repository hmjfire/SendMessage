package com.example.albert.sendmessage;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

public class TestBroadcastReceiver extends BroadcastReceiver {

    String strAction = null;
    final String TAG = "MainActivity-Receiver";
    private final String MY_BROADCAST = "android.intent.action.MY_BROADCAST_TWO";
    private final String BOOT_COMPLETED = "android.intent.action.BOOT_COMPLETED";
    @Override
    public void onReceive(Context context, Intent intent) {

        strAction = intent.getAction();
        if(strAction.equals(BOOT_COMPLETED)){
            Toast.makeText(context,"hello!!",Toast.LENGTH_SHORT).show();
        }

    }

}
