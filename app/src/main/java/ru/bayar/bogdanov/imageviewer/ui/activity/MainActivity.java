package ru.bayar.bogdanov.imageviewer.ui.activity;

import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Log;
import android.widget.Toast;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import ru.bayar.bogdanov.imageviewer.Application;
import ru.bayar.bogdanov.imageviewer.R;
import ru.bayar.bogdanov.imageviewer.base.BaseActivity;
import ru.bayar.bogdanov.imageviewer.presenter.MainPresenter;
import ru.bayar.bogdanov.imageviewer.ui.adapter.ImageAdapter;
import ru.bayar.bogdanov.imageviewer.ui.view.MainView;

public class MainActivity extends BaseActivity implements MainView {

    private static final String TAG = MainActivity.class.getName();

    @BindView(R.id.recycler_view)
    RecyclerView mRecyclerView;

    @Inject
    MainPresenter mPresenter;

    private ImageAdapter mImageAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Application.getComponent(this).inject(this);
        mPresenter.attachView(this);
        initViews();
    }

    @Override
    protected void initViews() {
        Log.i(TAG, "initViews: ");
        // TODO: 31.08.2017 need to determine whether it was smartphone or tablet
        mRecyclerView.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));
        mImageAdapter = new ImageAdapter(this);
        mRecyclerView.setAdapter(mImageAdapter);
        mPresenter.getLinks();
    }

    @Override
    public void onGetLinksSuccess(List<String> links) {
        mImageAdapter.onLinksAdded(links);
        dismissDialogProgress();
    }

    @Override
    public void onGetLinksError(Throwable throwable) {
        Toast.makeText(this, throwable.getMessage(), Toast.LENGTH_LONG).show();
        dismissDialogProgress();
    }
}
