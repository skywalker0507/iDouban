package com.skywalker.idouban;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.WindowManager;

import com.skywalker.idouban.collector.ActivityCollector;

public class SplashActivity extends AppCompatActivity {

    private Handler mHandler=new Handler();
    private SharedPreferences mSp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.e("Splash Activity","on create");
        setContentView(R.layout.activity_splash);

        ActivityCollector.addActivity(this);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);

        mSp=getSharedPreferences("config",MODE_PRIVATE);
        final SharedPreferences.Editor editor=mSp.edit();

        //默认第一次打开APP
        boolean firstEnter=mSp.getBoolean("guide",true);


        /**
         * 如果是第一次打开，则进入引导页面
         * 引导页面画面结束之后，设置为非第一次进入APP
         */
        if(firstEnter){
            mHandler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    startActivity(new Intent(SplashActivity.this,GuideActivity.class));
                    finish();
                    editor.putBoolean("guide",false);
                    editor.commit();
                }
            },1000);
        }else{
            mHandler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    startActivity(new Intent(SplashActivity.this,MainActivity.class));
                }
            },2000);
        }
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        ActivityCollector.removeActivity(this);
    }
}
