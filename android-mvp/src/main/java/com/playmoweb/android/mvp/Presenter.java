package com.playmoweb.android.mvp;

/**
 * Presenter
 * Every presenter in the app must either implement this interface or extend BasePresenter
 * indicating the MvpView type that wants to be attached with.
 *
 * @author Playmoweb
 */
public interface Presenter<V extends MvpView> {

    void attachView(V mvpView);

    void detachView();
}

