package com.example.module1.injection;

import com.example.basemodule.injection.components.BaseActivityComponent;
import com.example.basemodule.injection.modules.DefaultActivityModule;
import com.example.basemodule.injection.scope.ActivityScope;
import com.example.module1.Module1Activity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

/**
 * Created by Xingtian.Xin
 * Date: 2019/7/5
 * Time: 10:11
 */
@Module(subcomponents = {
        BaseActivityComponent.class   //1111111111 subComponent=BaseActivityComponent
})
public abstract class Module1AllActivityModule {

    @ActivityScope
    @ContributesAndroidInjector(modules = DefaultActivityModule.class)
    abstract Module1Activity moduleModule1Activity();
}
