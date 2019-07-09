package com.example.basemodule.base;

/**
 * Created by Xingtian.Xin
 * Date: 2019/7/4
 * Time: 10:17
 */
public class BasePresenter<T extends BaseMvpView> implements Presenter<T> {
    private T mMvpView;

//    public BasePresenter(T mMvpView) {
///      this.mMvpView = mMvpView;
//    }

    @Override
    public void attachView(T mvpView) {
        mMvpView = mvpView;
    }

    @Override
    public void detachView() {
        mMvpView = null;
    }

    protected T getView() {
        return mMvpView;
    }
}
