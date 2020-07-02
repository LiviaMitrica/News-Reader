package com.liviamitrica.data.di;

import android.app.Application;
import android.content.Context;

import com.liviamitrica.data.NewsRepository;
import com.liviamitrica.data.feature.news.NewsRepositoryImpl;
import com.liviamitrica.data.feature.news.remote.NewsRemoteSource;
import com.liviamitrica.data.remote.HttpClientFactory;

import io.reactivex.annotations.NonNull;

public class RepoModule {
    @NonNull
    private Context context;
    @NonNull
    private HttpClientFactory httpClientFactory;

    public RepoModule(@NonNull Application application) {
        this.context = application.getApplicationContext();
        this.httpClientFactory = new HttpClientFactory();
    }

    public NewsRepository provideNewsRepository() {
        return (NewsRepository) new NewsRepositoryImpl(provideNewsRemoteSource());
    }

    private NewsRemoteSource provideNewsRemoteSource() {
        return new NewsRemoteSource(httpClientFactory.getNewsApi());
    }
}
