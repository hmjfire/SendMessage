package com.example.albert.sendmessage;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;


import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static String TAG = "MainActivity";
    private Button button1 = null;
    Intent secActivity = new Intent();
    Intent intentPhone = null;
    private Activity secondActivity = new Main2Activity();

    private  TestBroadcastReceiver testBroadcastReceiver;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i(TAG,"oncreate 1");
        setContentView(R.layout.activity_main_2);
        //secActivity.setClass(this,Main2Activity.class);
        secActivity.setAction("my_action_aa");
        secActivity.addCategory("my_category");


        button1 = findViewById(R.id.btn1);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this,"You Click Btn 1! And go to the Second Activity",Toast.LENGTH_SHORT).show();
                ComponentName componentName = new ComponentName("com.example.albert.sendmessage","com.example.albert.sendmessage.Main2Activity");
                intentPhone = new Intent();
                intentPhone.setComponent(componentName);
                startActivity(intentPhone);
/*                ActivityManager am = (ActivityManager) getSystemService(Context.ACTIVITY_SERVICE);
                List<ActivityManager.RunningTaskInfo> runningTaskInfos = am.getRunningTasks(1);
                if(runningTaskInfos == null){
                    Log.d(TAG,"running Task is empty!");
                }
                for (ActivityManager.RunningTaskInfo runningTaskInfo : runningTaskInfos) {
                    String topPkg = null;
                    String basePkg = null;
                    if(runningTaskInfo.topActivity != null && runningTaskInfo.baseActivity != null){
                        topPkg = runningTaskInfo.topActivity.getPackageName();
                        //basePkg = runningTaskInfo.baseActivity.getPackageName();
                        basePkg = runningTaskInfo.topActivity.getClassName();
                    }
                    Log.d(TAG,"topPkg :"+topPkg+",basePkg :"+ basePkg);
                }*/
            }
        });

        testBroadcastReceiver = new TestBroadcastReceiver();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.MY_BROADCAST_TWO");
        registerReceiver(testBroadcastReceiver,intentFilter);

    }

    @Override
    protected void onStart() {
        Log.d(TAG,"onStart");
        super.onStart();
    }

    @Override
    protected void onResume() {
        Log.d(TAG,"onResume");
        super.onResume();
    }

    @Override
    protected void onPause() {
        Log.d(TAG,"onPause");
        super.onPause();
    }

    @Override
    protected void onStop() {
        Log.d(TAG,"onStop");
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        Log.d(TAG,"onDestroy");
        super.onDestroy();
        unregisterReceiver(testBroadcastReceiver);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main,menu);
        return true;
    }


}
