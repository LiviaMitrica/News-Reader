package com.liviamitrica.data.store.local;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.liviamitrica.data.feature.news.local.ArticleDAO;
import com.liviamitrica.data.feature.news.local.ArticleEntity;

@Database(entities = {ArticleEntity.class}, version = 1)
public abstract class ArticleDataBase extends RoomDatabase {

    public abstract ArticleDAO articleDAO();
}
