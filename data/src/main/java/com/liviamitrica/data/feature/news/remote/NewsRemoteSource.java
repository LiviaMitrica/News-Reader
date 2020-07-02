package com.liviamitrica.data.feature.news.remote;

import com.liviamitrica.data.feature.news.remote.model.ArticleListDto;
import com.liviamitrica.data.remote.NewsApi;

import io.reactivex.Single;
import io.reactivex.annotations.NonNull;
import io.reactivex.schedulers.Schedulers;

public class NewsRemoteSource {
    private static final String API_KEY = "02c75a3f97234305b730f699bc18c8f8";
    private static final String EN_LANGUAGE_FILTER = "en";
    @NonNull
    private final NewsApi newsApi;

    public NewsRemoteSource(NewsApi newsApi) {
        this.newsApi = newsApi;
    }

    public Single<ArticleListDto> getNewsArticles() {
        return newsApi.getNewsArticles(API_KEY, EN_LANGUAGE_FILTER)
                .subscribeOn(Schedulers.io());
    }
}
