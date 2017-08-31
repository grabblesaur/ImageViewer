package ru.bayar.bogdanov.imageviewer.di.component;

import javax.inject.Singleton;

import dagger.Component;
import ru.bayar.bogdanov.imageviewer.di.module.AppModule;
import ru.bayar.bogdanov.imageviewer.ui.activity.MainActivity;

@Singleton
@Component(modules = AppModule.class)
public interface AppComponent {
    void inject(MainActivity activity);
}
