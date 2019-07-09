package com.example.module1.injection;

import com.example.basemodule.base.BaseMvpView;
import com.example.basemodule.injection.components.BaseActivityComponent;
import com.example.basemodule.injection.modules.DefaultActivityModule;
import com.example.basemodule.injection.scope.ActivityScope;
import com.example.module1.Module1Activity;
import com.example.module1.Module1Presenter;

import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import dagger.android.ContributesAndroidInjector;

/**
 * Created by Xingtian.Xin
 * Date: 2019/7/5
 * Time: 10:11
 */
@Module(subcomponents = {
        BaseActivityComponent.class
})
public abstract class Module1AllActivityModule {

    @ActivityScope
    @ContributesAndroidInjector(modules = DefaultActivityModule.class)
    abstract Module1Activity moduleModule1Activity();

    @Provides
    static Module1Presenter provideModule1Presenter() {
        return new Module1Presenter();
    }
}
