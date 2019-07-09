package com.example.mymodularization.injection;

import com.example.basemodule.base.BaseApplication;
import com.example.basemodule.injection.modules.BaseGlobalModule;
import com.example.module1.injection.Module1AllActivityModule;
import com.example.mymodularization.App;

import javax.inject.Singleton;

import dagger.Component;
import dagger.android.AndroidInjectionModule;
import dagger.android.AndroidInjector;

/**
 * Created by Xingtian.Xin
 * Date: 2019/7/5
 * Time: 9:26
 */
@Singleton
@Component(modules = {
        BaseGlobalModule.class,         //全局的Module,要确保提供的对象是全局唯一的

        AndroidInjectionModule.class,   //在应用程序的MainComponent（application 中inject了）中，注入AndroidInjectionModule，
        // 以确保Android的类(Activity、Fragment、Service、BroadcastReceiver及ContentProvider等)可以绑定。
        // 一般把AndroidInjectionModule放在ApplicationComponent中，其他的Component依赖Application即可
        //AndroidSupportInjectionModule.class,  //使用的Fragment 是V4 包中的？不然就只需要AndroidInjectionModule


        //下面的是ABCD 等Module 的Activity 需要依赖注入的ActivityModule 配置

        Module1AllActivityModule.class, //减少模版代码,需要依赖注入的只需要添加两行代码就好了
        //MainGlobalModule.class,

        //NewsModuleAllActivityModule.class,  //减少模版代码,需要依赖注入的只需要添加两行代码就好了
        //NewsGlobalModule.class,

})
public interface AppComponent extends AndroidInjector<App> {
    void inject(BaseApplication application); //
}
