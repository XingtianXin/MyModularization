package com.example.basemodule.base;

import android.os.Bundle;

import com.fewlaps.quitnowcache.QNCache;
import com.fewlaps.quitnowcache.QNCacheBuilder;

import java.util.concurrent.atomic.AtomicLong;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * Created by Xingtian.Xin
 * Date: 2019/7/9
 * Time: 14:13
 */
@Singleton
public class PresenterManager {
    private static final String KEY_PRESENTER_ID = "presenter_id";

    private final AtomicLong currentId;
    private final QNCache<BasePresenter<?>> qnCache;

    @Inject
    public PresenterManager() {
        currentId = new AtomicLong();
        qnCache = new QNCacheBuilder().createQNCache();
    }

    public <P extends BasePresenter<?>> P restorePresenter(Bundle savedInstanceState) {
        return restorePresenter(savedInstanceState, KEY_PRESENTER_ID);
    }

    public <P extends BasePresenter<?>> P restorePresenter(Bundle savedInstanceState, String key) {
        Long presenterId = savedInstanceState.getLong(key);
        P presenter = (P) qnCache.get(presenterId.toString());
        qnCache.remove(presenterId.toString());
        return presenter;
    }


    public boolean containsPresenter(Bundle savedInstanceState) {
        return containsPresenter(savedInstanceState, KEY_PRESENTER_ID);
    }

    public boolean containsPresenter(Bundle savedInstanceState, String key) {
        Long presenterId = savedInstanceState.getLong(key);
        return qnCache.contains(presenterId.toString());
    }

    public void savePresenter(BasePresenter<?> presenter, Bundle outState) {
        savePresenter(presenter, outState, KEY_PRESENTER_ID);
    }

    public void savePresenter(BasePresenter<?> presenter, Bundle outState, String key) {
        Long presenterId = currentId.incrementAndGet();
        qnCache.set(presenterId.toString(), presenter);
        outState.putLong(key, presenterId);
    }
}
