package ru.bayar.bogdanov.imageviewer;

import android.content.Context;

import ru.bayar.bogdanov.imageviewer.di.component.AppComponent;
import ru.bayar.bogdanov.imageviewer.di.component.DaggerAppComponent;
import ru.bayar.bogdanov.imageviewer.di.module.AppModule;

/**
 * Created by Majo on 24.05.17.
 */

public class Application extends android.app.Application {

    private AppComponent mApplicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        mApplicationComponent = createComponent();


    }

    private AppComponent createComponent() {
        return DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .build();
    }

    public static AppComponent getComponent(Context context) {
        return ((Application)context.getApplicationContext()).mApplicationComponent;
    }
}
