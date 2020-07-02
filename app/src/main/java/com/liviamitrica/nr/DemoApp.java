package com.liviamitrica.nr;

import android.app.Application;

import com.liviamitrica.data.di.RepoModule;

public class DemoApp extends Application {
    private static RepoModule repoModule;

    @Override
    public void onCreate() {
        super.onCreate();
        this.repoModule = new RepoModule(this);
    }

    public static RepoModule getRepoProvider() {
        return repoModule;
    }
}
