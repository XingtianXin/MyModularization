package com.example.basemodule.injection.modules;

import android.app.Application;
import android.content.Context;

import com.example.basemodule.model.SharedPrefsService;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Xingtian.Xin
 * Date: 2019/7/4
 * Time: 17:07
 */
@Module
public class BaseGlobalModule {

    public Application mContext;

    /**
     * Module  带有构造方法并且参数被使用的情况下所产生的Component 是没有Create方法的
     *
     * @param mContext
     */
    public BaseGlobalModule(Application mContext) {
        this.mContext = mContext;
    }


    /***
     * @return
     */
    @Provides
    @Singleton
    public Context provideContext() {
        return mContext;
    }

    /**
     * SharedPreferences 保存KEY VALUE 配置信息
     *
     * @return
     */
    @Provides
    @Singleton  //在这加了Singleton 的注解就是单例的了，打出内存地址查看一下
    public SharedPrefsService provideSPDao() {

        //todo 既然Not third part .why not inject ?
        return new SharedPrefsService(mContext);

    }
}
