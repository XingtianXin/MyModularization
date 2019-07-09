package com.example.module2.injection;

import com.example.basemodule.injection.components.BaseActivityComponent;
import com.example.basemodule.injection.modules.DefaultActivityModule;
import com.example.basemodule.injection.scope.ActivityScope;
import com.example.module2.Module2Activity;
import com.example.module2.Module2Presenter;

import dagger.Module;
import dagger.Provides;
import dagger.android.ContributesAndroidInjector;

/**
 * Created by Xingtian.Xin
 * Date: 2019/7/9
 * Time: 17:24
 */
@Module(subcomponents = {
        BaseActivityComponent.class
})
public abstract class Module2AllActivityModule {
    @ActivityScope
    @ContributesAndroidInjector(modules = DefaultActivityModule.class)
    abstract Module2Activity moduleModule2Activity();

    @Provides
    static Module2Presenter provideModule2Presenter() {
        return new Module2Presenter();
    }
}
