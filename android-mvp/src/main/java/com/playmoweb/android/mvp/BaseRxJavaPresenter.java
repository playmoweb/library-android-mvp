package com.playmoweb.android.mvp;

import io.reactivex.disposables.CompositeDisposable;

/**
 * BaseRxJavaPresenter
 *
 * @author Playmoweb
 */
public abstract class BaseRxJavaPresenter extends BasePresenter {

    protected CompositeDisposable disposables = new CompositeDisposable();

    @Override
    public void detachView() {
        disposables.clear();
        super.detachView();
    }
}
