package com.liviamitrica.nr.ui.main.model;

import android.app.Application;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.databinding.ObservableArrayList;
import androidx.databinding.ObservableBoolean;
import androidx.databinding.ObservableField;
import androidx.databinding.ObservableList;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;

import com.liviamitrica.data.NewsRepository;
import com.liviamitrica.data.feature.news.model.Article;
import com.liviamitrica.data.feature.news.remote.mapper.NewsDtoToNewsMapper;
import com.liviamitrica.nr.ui.main.listener.NewsArticleHandler;
import com.liviamitrica.nr.ui.main.mapper.ArticlesToVMListMapper;
import com.liviamitrica.nr.ui.main.reactive.SingleLiveEvent;

import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;

public class NewsListViewModel  extends AndroidViewModel implements LifecycleObserver, NewsArticleHandler {
    @NonNull
    public final ObservableList<ArticleItemViewModel> items;
    private static final String TAG = NewsListViewModel.class.getName();
    private Disposable disposable;
    public final SingleLiveEvent<String> openLink;
    private final static String LINK = "https://newsapi.org/";
    public final ObservableField<String> resultText;
    private final NewsRepository repo;
    public final ObservableBoolean isLoading;
    public final SingleLiveEvent<Throwable> error;

    public NewsListViewModel(Application application, NewsRepository repo) {
        super(application);
        this.repo = repo;
        this.items = new ObservableArrayList<>();
        this.resultText = new ObservableField<>();
        this.openLink = new SingleLiveEvent<>();
        this.isLoading = new ObservableBoolean();
        this.error = new SingleLiveEvent<>();
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    public void refresh(){

        isLoading.set(true);
        repo.getNewsArticles()
                .map(new ArticlesToVMListMapper())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        this::onNewsArticlesReceived,
                        this::onNewsArticlesError
                );

    }

    private void onNewsArticlesReceived(List<ArticleItemViewModel> articleItemViewModels) {
        isLoading.set(false);
        resultText.set("Found {articleItemViewModels.size()} articles");
        items.clear();
        items.addAll(articleItemViewModels);
    }


    private void onNewsArticlesError(Throwable throwable) {
        isLoading.set(false);
        error.setValue(throwable);
    }

    public void onPoweredBySelected() {
        openLink.setValue(LINK);
    }

    @Override
    public void onItemSelected(ArticleItemViewModel item) {

    }
}
