package com.playmoweb.android.mvp.lifecycle;

import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.LifecycleObserver;
import android.arch.lifecycle.OnLifecycleEvent;

import com.playmoweb.android.mvp.BasePresenter;

/**
 * This presenter will handle automatically the detachView() call on pause and on destroy.
 *
 * @author Playmoweb
 */
public class LifecyclePresenter<T extends MvpLifecycleView> extends BasePresenter<T> implements LifecycleObserver {

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    public void onPause() {
        detachView();
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public void onDestroy() {
        detachView();
    }

    @Override
    public void attachView(final T mvpView) {
        super.attachView(mvpView);
        mvpView.getLifecycle().addObserver(this);
    }

    @Override
    public void detachView() {
        if(mvpView != null) {
            mvpView.getLifecycle().removeObserver(this);
        }
        super.detachView();
    }
}
