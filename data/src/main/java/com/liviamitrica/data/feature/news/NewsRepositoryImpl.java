package com.liviamitrica.data.feature.news;

import com.liviamitrica.data.NewsRepository;
import com.liviamitrica.data.feature.news.local.ArticleEntity;
import com.liviamitrica.data.feature.news.local.ArticleLocalDataStore;
import com.liviamitrica.data.feature.news.model.Article;
import com.liviamitrica.data.feature.news.remote.NewsRemoteSource;

import java.util.List;

import io.reactivex.Completable;
import io.reactivex.Flowable;
import io.reactivex.Single;
import io.reactivex.annotations.NonNull;

public class NewsRepositoryImpl implements NewsRepository {

    private final NewsRemoteSource remoteSource;
    private ArticleLocalDataStore localSource;

    public NewsRepositoryImpl(NewsRemoteSource remoteSource) {
        this.remoteSource = remoteSource;
    }

    @Override
    @NonNull
    public Single<List<Article>> getNewsArticles() {
        /*return remoteSource.getNewsArticles()
                .map(new NewsDtoToNewsMapper());*/

        return remoteSource.getNewsArticles().flatMap(localSource::saveArticle)
                .onErrorResumeNext(localSource.getArticles())
                .map(new ArticleEntityToArticleMapper());
    }

    @NonNull
    @Override
    public Flowable<List<ArticleEntity>> saveArticles(List<ArticleEntity> articleEntities) {
        return localSource.saveArticles(articleEntities);
    }

    @NonNull
    @Override
    public Completable saveArticle(ArticleEntity articleEntity) {
        return localSource.saveItem(articleEntity);
    }
}
