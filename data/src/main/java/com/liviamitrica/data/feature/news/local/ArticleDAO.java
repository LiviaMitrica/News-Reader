package com.liviamitrica.data.feature.news.local;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.liviamitrica.data.feature.news.model.Article;

import java.util.List;

import io.reactivex.Completable;
import io.reactivex.Flowable;
import io.reactivex.Single;

@Dao
public interface ArticleDAO {

    @Query("SELECT * FROM articles")
    Flowable<List<ArticleEntity>> queryArticles();

    @Query("SELECT * FROM articles where id= :id")
    Single<ArticleEntity> queryArticleItem(int id);

    @Query("DELETE FROM articles where id=:id")
    Completable deleteArticleItem(int id);

    @Query("DELETE FROM articles")
    Completable deleteAllArticles();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    Completable insertArticle(ArticleEntity articleEntity);
}
