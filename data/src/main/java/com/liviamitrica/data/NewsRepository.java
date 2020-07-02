package com.liviamitrica.data;

import androidx.annotation.NonNull;

import com.liviamitrica.data.feature.news.local.ArticleEntity;
import com.liviamitrica.data.feature.news.model.Article;

import java.util.List;

import io.reactivex.Completable;
import io.reactivex.Flowable;
import io.reactivex.Single;

public interface NewsRepository {
    @NonNull
    Single<List<Article>> getNewsArticles();

    @NonNull
    Flowable<List<ArticleEntity>> saveArticles(List<ArticleEntity> articleEntities);

    @NonNull
    Completable saveArticle(ArticleEntity articleEntity);
}
