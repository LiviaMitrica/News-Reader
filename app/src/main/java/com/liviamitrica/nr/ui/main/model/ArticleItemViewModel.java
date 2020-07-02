package com.liviamitrica.nr.ui.main.model;

import androidx.lifecycle.ViewModel;

import io.reactivex.annotations.NonNull;

public class ArticleItemViewModel extends ViewModel {

    private final String TAG = ArticleItemViewModel.class.getName();

    public String articleContent;
    public String articleTitle;
    public String aricleImage;
    public final String articleDescription;

    public ArticleItemViewModel(String aricleImage, String articleTitle,String articleContent, String articleDescription ) {
        this.articleTitle = articleTitle;
        this.articleContent = articleContent;
        this.aricleImage = aricleImage;
        this.articleDescription = articleDescription;
    }
}
