package com.liviamitrica.data.feature.news.local;

import androidx.annotation.Nullable;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "articles")
public class ArticleEntity {
    @PrimaryKey(autoGenerate = true)
    @Nullable
    public Integer id;
    public String articleContent;
    public String articleTitle;
    public String aricleImage;
    public String articleDescription;
}
