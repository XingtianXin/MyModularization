package com.example.basemodule.base;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import javax.inject.Inject;

import dagger.android.AndroidInjection;
import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.HasFragmentInjector;

/**
 * Created by Xingtian.Xin
 * Date: 2019/7/5
 * Time: 6:58
 */
public abstract class BaseMvpActivity extends BaseActivity implements BaseMvpView , HasFragmentInjector {

    @Inject
    DispatchingAndroidInjector<Fragment> fragmentInjector;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        AndroidInjection.inject(this);
        super.onCreate(savedInstanceState);
    }

    @Override
    public AndroidInjector<Fragment> supportFragmentInjector() {
        return fragmentInjector;
    }
}
