package com.liviamitrica.nr.ui.main.model;

import android.util.Log;

import androidx.annotation.NonNull;
import androidx.databinding.ObservableArrayList;
import androidx.databinding.ObservableList;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;
import androidx.lifecycle.ViewModel;

import com.liviamitrica.nr.ui.main.listener.NewsArticleHandler;

import java.util.List;

import io.reactivex.disposables.Disposable;

public class NewsListViewModel  extends ViewModel implements LifecycleObserver, NewsArticleHandler {
    @NonNull
    public final ObservableList<ArticleItemViewModel> items;
    private static final String TAG = NewsListViewModel.class.getName();
    private Disposable disposable;

    public NewsListViewModel() {
        this.items = new ObservableArrayList<>();
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    public void refresh(){
        ArticleItemViewModel a1 = new ArticleItemViewModel("articol1", "text articol 1, bla bla bla", "https://img2.chinadaily.com.cn/images/202001/13/5e1be3e6a310cf3e97b0bbbc.jpeg" );
        ArticleItemViewModel a2 = new ArticleItemViewModel("articol2", "text articol 2, bla bla bla", "https://images.app.goo.gl/hojGh9oYDcerfrFa7" );
        ArticleItemViewModel a3 = new ArticleItemViewModel("articol3", "text articol 3, bla bla bla", "https://images.app.goo.gl/H4TtGr9KLtkfvWBg6");

        items.add(a1);
        items.add(a2);
        items.add(a3);
    }

    @Override
    public void onItemSelected(ArticleItemViewModel item) {

    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    public void fetchList() {
        Log.d(TAG, "fetchList()");

        /*if(items.isEmpty()) {
            disposable = repository.getToDoList()
                    .map(new ItemsToVmMapper())
                    .subscribe(
                            toDoItemViewModels -> onToDoListReceived(toDoItemViewModels),
                            throwable -> {
                                Log.e(TAG, "fetchToDoList error: ", throwable);
                            });
        }*/
    }

    private void onNewsArticleListReceived(List<ArticleItemViewModel> toDoItems) {
        Log.d(TAG, "onToDoListReceived " + toDoItems.size() + " items");
        items.clear();
        items.addAll(toDoItems);
    }
}
