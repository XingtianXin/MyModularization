package com.example.basemodule.injection.components;

import com.example.basemodule.base.BaseMvpActivity;

import dagger.Subcomponent;
import dagger.android.AndroidInjectionModule;
import dagger.android.AndroidInjector;

/**
 * Created by Xingtian.Xin
 * Date: 2019/7/5
 * Time: 9:43
 */

@Subcomponent(modules = {
        AndroidInjectionModule.class,
})
public interface BaseActivityComponent extends AndroidInjector<BaseMvpActivity>{
    //每一个继承BaseActivity（BaseMVPActivity）的Activity，都共享同一个SubComponent
    @Subcomponent.Builder
    abstract class Builder extends AndroidInjector.Builder<BaseMvpActivity> {

    }
}
