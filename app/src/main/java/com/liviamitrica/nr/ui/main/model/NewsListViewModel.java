package com.liviamitrica.nr.ui.main.model;

import androidx.annotation.NonNull;
import androidx.databinding.ObservableArrayList;
import androidx.databinding.ObservableList;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;
import androidx.lifecycle.ViewModel;

import com.liviamitrica.nr.ui.main.listener.NewsArticleHandler;
import com.liviamitrica.nr.ui.main.model.ArticleItemViewModel;

public class NewsListViewModel  extends ViewModel implements LifecycleObserver, NewsArticleHandler {
    @NonNull
    public final ObservableList<ArticleItemViewModel> items;

    public NewsListViewModel() {
        this.items = new ObservableArrayList<>();
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    public void refresh(){

    }

    @Override
    public void onItemSelected(ArticleItemViewModel item) {

    }
}
