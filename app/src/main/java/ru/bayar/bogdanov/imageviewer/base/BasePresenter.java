package ru.bayar.bogdanov.imageviewer.base;

import ru.bayar.bogdanov.imageviewer.ApiService;

public abstract class BasePresenter <V extends BaseView>{

    private V mView;

    protected ApiService mApiService;

    public void onDestroy() {
        if (isViewAttached())
            detachView();
    }

    public final void attachView(V view) {
        if (view == null) {
            throw new NullPointerException("View must not be null");
        }
        mView = view;
    }

    protected final void detachView() {
        mView = null;
    }

    protected final V getView() {
        return mView;
    }

    protected final boolean isViewAttached() {
        return mView != null;
    }
}
