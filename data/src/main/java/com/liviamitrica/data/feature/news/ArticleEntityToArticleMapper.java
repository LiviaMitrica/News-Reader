package com.liviamitrica.data.feature.news;

import com.liviamitrica.data.feature.news.local.ArticleEntity;
import com.liviamitrica.data.feature.news.model.Article;
import java.util.ArrayList;
import java.util.List;

import io.reactivex.functions.Function;

public class ArticleEntityToArticleMapper implements Function<List<ArticleEntity>, List<Article>> {

    @Override
    public List<Article> apply(List<ArticleEntity> articles) {
        List<Article> articleItems = new ArrayList<>();

        for (ArticleEntity article : articles) {
            Article currentArticle = new Article(
                    article.aricleImage != null ? article.aricleImage : "", //Adding default values for business model
                    article.articleTitle != null ? article.articleTitle : "",
                    article.articleContent != null ? article.articleContent : "",
                    article.articleDescription != null ? article.articleDescription : ""
            );

            articleItems.add(currentArticle);
        }

        return articleItems;
    }
}
