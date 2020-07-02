package com.liviamitrica.nr.ui.main.mapper;

import com.liviamitrica.data.feature.news.model.Article;
import com.liviamitrica.nr.ui.main.model.ArticleItemViewModel;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.functions.Function;

public class ArticlesToVMListMapper implements Function<List<Article>, List<ArticleItemViewModel>> {

    @Override
    public List<ArticleItemViewModel> apply(List<Article> articles) {
        List<ArticleItemViewModel> articleItemViewModels = new ArrayList<>();

        for (Article article : articles) {
            ArticleItemViewModel currentArticle = new ArticleItemViewModel(
                    article.imageUrl != null ? article.imageUrl : "", //Adding default values for business model
                    article.title != null ? article.title : "",
                    article.content != null ? article.content : "",
                    article.description != null ? article.description : ""
            );

            articleItemViewModels.add(currentArticle);
        }

        return articleItemViewModels;
    }
}
