package ru.bayar.bogdanov.imageviewer.presenter;


import android.util.Log;

import java.util.List;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import ru.bayar.bogdanov.imageviewer.ApiService;
import ru.bayar.bogdanov.imageviewer.base.BasePresenter;
import ru.bayar.bogdanov.imageviewer.ui.view.MainView;

public class MainPresenter extends BasePresenter<MainView> {

    private static final String TAG = MainPresenter.class.getName();

    @Inject
    public MainPresenter(ApiService apiService) {
        mApiService = apiService;
    }

    public void getLinks() {
        mApiService.getLinks().enqueue(new Callback<List<String>>() {
            @Override
            public void onResponse(Call<List<String>> call, Response<List<String>> response) {
                Log.i(TAG, "onResponse: " + response.message());
                getView().onGetLinksSuccess(response.body());
            }

            @Override
            public void onFailure(Call<List<String>> call, Throwable t) {
                Log.e(TAG, "onFailure: " + t.getMessage());
                getView().onGetLinksError(t);
            }
        });
    }
}
