package com.example.basemodule.base;

import com.example.basemodule.base.BaseMvpView;

public interface Presenter<V extends BaseMvpView> {

    void attachView(V mvpView);

    void detachView();
}
