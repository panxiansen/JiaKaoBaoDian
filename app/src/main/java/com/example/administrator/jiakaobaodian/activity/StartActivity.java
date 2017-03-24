package com.example.administrator.jiakaobaodian.activity;

import android.annotation.TargetApi;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;

import com.example.administrator.jiakaobaodian.R;

/**
 * Created by Administrator on 2017/2/5.
 */

public class StartActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.start_layout);

        //定义SharedPreference记录APP是否第一次开启
        final SharedPreferences sharedPreferences = getSharedPreferences("com.example.adminstrator.jiakaobaodian.start_time",0);
        final Boolean use_first = sharedPreferences.getBoolean("FIRST",true);



        if (use_first){
            new Handler().postDelayed(new Runnable() {
                @TargetApi(Build.VERSION_CODES.ECLAIR)
                @Override
                public void run() {
                    sharedPreferences.edit().putBoolean("FIRST",false).commit();
                    Intent mainIntent = new Intent(StartActivity.this, FirstStart_Activity.class);
                    StartActivity.this.startActivity(mainIntent);
                    StartActivity.this.finish();
                    overridePendingTransition(R.anim.fade,R.anim.fade_out);
                }
            }, 3000);

        }else{
            new Handler().postDelayed(new Runnable() {
                @TargetApi(Build.VERSION_CODES.ECLAIR)
                @Override
                public void run() {
                    Intent mainIntent = new Intent(StartActivity.this, MainActivity.class);
                    StartActivity.this.startActivity(mainIntent);
                    StartActivity.this.finish();
                    overridePendingTransition(R.anim.fade,R.anim.fade_out);
                }
            }, 3000);

        }


    }





}
