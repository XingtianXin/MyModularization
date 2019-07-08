package com.example.module1.injection;

/**
 * Created by Xingtian.Xin
 * Date: 2019/7/5
 * Time: 10:14
 */

import com.example.basemodule.base.BaseApplication;
import com.example.basemodule.injection.modules.BaseGlobalModule;

import javax.inject.Singleton;

import dagger.Component;
import dagger.android.AndroidInjectionModule;
import dagger.android.support.AndroidSupportInjectionModule;

@Singleton
@Component(modules = {
        BaseGlobalModule.class,      //全局的Module,要确保提供的对象是全局唯一的

        AndroidInjectionModule.class,   //在应用程序的MainComponent（application 中inject了）中，注入AndroidInjectionModule，
        // 以确保Android的类(Activity、Fragment、Service、BroadcastReceiver及ContentProvider等)可以绑定。
        // 一般把AndroidInjectionModule放在ApplicationComponent中，其他的Component依赖Application即可
        //AndroidSupportInjectionModule.class,  //使用的Fragment 是V4 包中的？不然就只需要AndroidInjectionModule

        //这个是专门为了在Activity & Fragment 中使用依赖注入使用的
        Module1AllActivityModule.class
})
public interface Module1Component {
    void inject(BaseApplication application); //
}
