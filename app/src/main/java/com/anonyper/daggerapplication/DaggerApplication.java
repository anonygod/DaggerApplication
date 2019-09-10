package com.anonyper.daggerapplication;

import android.app.Application;

import com.alibaba.android.arouter.launcher.ARouter;

/**
 * DaggerApplication
 * Created by anonyper on 2019/6/24.
 */
public class DaggerApplication extends Application {
    private static DaggerApplication daggerApplication;

    public static DaggerApplication getInstance() {
        return daggerApplication;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        daggerApplication = this;
        if (BuildConfig.DEBUG) {
            ARouter.openDebug();
            ARouter.openLog();
        }
        ARouter.init(this);
    }

}
