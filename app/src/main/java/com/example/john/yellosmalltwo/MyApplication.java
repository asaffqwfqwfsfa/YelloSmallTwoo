package com.example.john.yellosmalltwo;

import android.app.Application;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.github.moduth.blockcanary.BlockCanary;
import com.mob.MobSDK;
import com.squareup.leakcanary.LeakCanary;
import com.tencent.bugly.crashreport.CrashReport;

import cn.jpush.android.api.JPushInterface;

/**
 * Created by john on 2018/7/17.
 */

public class MyApplication extends Application{
    @Override
    public void onCreate() {
        super.onCreate();
        Fresco.initialize(this);
        MobSDK.init(this, "227c4b4c099c6", "f5bd1023bfda8b749b1fd67b2f755317");
        CrashReport.initCrashReport(getApplicationContext(), "7b501b5587", false);
        LeakCanary.install(this);
        BlockCanary.install(this, new AppBlockCanaryContext()).start();

    }
}
