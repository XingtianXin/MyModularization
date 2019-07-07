package com.example.basemodule.base;

import android.app.Activity;
import android.app.Application;
import android.content.Context;

import com.alibaba.android.arouter.launcher.ARouter;
import com.example.basemodule.BuildConfig;

import javax.inject.Inject;

import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.HasActivityInjector;

public abstract class BaseApplication extends Application implements HasActivityInjector {

    static private BaseApplication mApplication;

    @Inject
    DispatchingAndroidInjector<Activity> dispatchingAndroidInjector;
    @Override
    public void onCreate() {
        super.onCreate();
        mApplication = this;
        initRouter();
        initInject();
    }

    protected abstract String getBaseUrl();
    abstract protected void injectApp();

    private void initInject(){
        injectApp();
    }

    public static BaseApplication getInstance(){
        return mApplication;
    }

    public static Context getContext() {
        return mApplication;
    }

    @Override
    public AndroidInjector<Activity> activityInjector() {
        return dispatchingAndroidInjector;
    }

    private void initRouter() {
        if (BuildConfig.DEBUG) {
            ARouter.openLog();     // 打印日志
            ARouter.openDebug();   // 开启调试模式(如果在InstantRun模式下运行，必须开启调试模式！线上版本需要关闭,否则有安全风险)
        }
        ARouter.init(mApplication);
    }
}
