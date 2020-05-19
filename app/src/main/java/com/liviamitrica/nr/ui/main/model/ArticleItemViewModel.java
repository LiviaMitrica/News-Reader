package com.liviamitrica.nr.ui.main.model;

import androidx.lifecycle.ViewModel;

public class ArticleItemViewModel extends ViewModel {

    private final String TAG = ArticleItemViewModel.class.getName();

    public String articleName;
    public String articleTitle;
    public String aricleImage;

    public ArticleItemViewModel(String articleName, String articleTitle, String aricleImage) {
        this.articleName = articleName;
        this.articleTitle = articleTitle;
        this.aricleImage = aricleImage;
    }
}
