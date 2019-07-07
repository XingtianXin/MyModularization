package com.example.mymodularization;

import android.app.Application;
import com.example.basemodule.base.BaseApplication;
import com.example.basemodule.injection.modules.BaseGlobalModule;
import com.example.mymodularization.injection.DaggerAppComponent;

public class App extends BaseApplication {

    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Override
    protected String getBaseUrl() {
        return null;
    }

    @Override
    protected void injectApp() {
        DaggerAppComponent.builder()
                .baseGlobalModule(new BaseGlobalModule(this))
                .build()
                .inject(this);
    }
}
