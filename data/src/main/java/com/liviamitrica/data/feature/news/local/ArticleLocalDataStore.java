package com.liviamitrica.data.feature.news.local;

import com.liviamitrica.data.feature.news.remote.model.ArticleDto;
import com.liviamitrica.data.feature.news.remote.model.ArticleListDto;

import java.util.List;

import io.reactivex.Completable;
import io.reactivex.Flowable;
import io.reactivex.Single;
import io.reactivex.SingleSource;

public class ArticleLocalDataStore {

    private ArticleDAO dao;

    public ArticleLocalDataStore(ArticleDAO dao){
        this.dao = dao;
    }

    public Flowable<List<ArticleEntity>> getArticles() {
        return dao.queryArticles();
    }

    public Single<ArticleEntity> getArticleItem(int id) {
        return dao.queryArticleItem(id);
    }

    public Completable deleteArticle(int id) {
        return dao.deleteArticleItem(id);
    }

    public Flowable<List<ArticleEntity>> saveArticles(List<ArticleEntity> articleEntities) {
        for (ArticleEntity articleEntity : articleEntities){
            if(articleEntity.id == null) {
                dao.insertArticle(articleEntity);
            }
        }

        return dao.queryArticles();
    }

    public Completable saveItem(ArticleEntity article) {
        if (article.id == null)
            return dao.insertArticle(article);

        return null;
    }

    public <R> SingleSource<? extends R> saveArticle(ArticleListDto articleListDto) {

        return null;
    }
}
