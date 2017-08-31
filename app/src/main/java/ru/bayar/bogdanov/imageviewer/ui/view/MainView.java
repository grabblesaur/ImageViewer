package ru.bayar.bogdanov.imageviewer.ui.view;


import java.util.List;

import ru.bayar.bogdanov.imageviewer.base.BaseView;

public interface MainView extends BaseView {
    void onGetLinksSuccess(List<String> body);
    void onGetLinksError(Throwable throwable);
}
