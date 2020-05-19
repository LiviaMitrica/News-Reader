package com.liviamitrica.nr.ui.main.model;

import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.ViewModel;

import com.liviamitrica.nr.ui.main.listener.NewsArticleHandler;

public class ArticleItemViewModel extends ViewModel implements LifecycleObserver, NewsArticleHandler {

    private final String TAG = ArticleItemViewModel.class.getName();

    public String articleName;
    public String articleTitle;
    public String aricleImage;

    public ArticleItemViewModel(String articleName, String articleTitle, String aricleImage) {
        this.articleName = articleName;
        this.articleTitle = articleTitle;
        this.aricleImage = aricleImage;
    }

    @Override
    public void onItemSelected(ArticleItemViewModel item) {

    }
}
