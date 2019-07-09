package com.example.mymodularization;

import android.app.Application;
import com.example.basemodule.base.BaseApplication;
import com.example.basemodule.injection.modules.BaseGlobalModule;
import com.example.mymodularization.injection.AppComponent;
import com.example.mymodularization.injection.DaggerAppComponent;

import dagger.android.AndroidInjector;
import dagger.android.DaggerApplication;

public class App extends BaseApplication {

    private AppComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();
    }

    public AppComponent getComponent() {
        return appComponent;
    }

    @Override
    protected AndroidInjector<? extends DaggerApplication> applicationInjector() {
        appComponent = DaggerAppComponent.builder()
                .baseGlobalModule(new BaseGlobalModule(this))
                .build();
        appComponent.inject(this);
        return appComponent;
    }

    @Override
    protected String getBaseUrl() {
        return null;
    }
}
