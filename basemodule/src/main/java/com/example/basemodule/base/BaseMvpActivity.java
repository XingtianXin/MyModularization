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
public abstract class BaseMvpActivity<T extends BasePresenter> extends BaseActivity implements BaseMvpView{

    @Inject
    protected T mPresenter;
    @Inject
    protected PresenterManager mPresenterManager;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        AndroidInjection.inject(this);
        super.onCreate(savedInstanceState);
        if (savedInstanceState != null && mPresenterManager.containsPresenter(savedInstanceState)) {
            mPresenter = mPresenterManager.<T>restorePresenter(savedInstanceState);
        }
        if (mPresenter != null) {
            mPresenter.attachView(this);
        }
    }

    @Override
    protected void onDestroy() {
        if (mPresenter != null) {
            mPresenter.detachView();
        }
        super.onDestroy();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        if (mPresenter != null) {
            mPresenterManager.savePresenter(mPresenter, outState);
        }
    }

}
