package com.liviamitrica.nr.ui.main.viewBindings;

import androidx.databinding.BindingAdapter;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.liviamitrica.nr.ui.main.Adapter.ArticleAdapter;
import com.liviamitrica.nr.ui.main.listener.NewsArticleHandler;
import com.liviamitrica.nr.ui.main.model.ArticleItemViewModel;

import java.util.List;


public class RecyclerBinding {

    @BindingAdapter({"items", "todoHandler"})
    public static void addFeedItems(RecyclerView recyclerView, List<ArticleItemViewModel> newsList, NewsArticleHandler handler) {
        ArticleAdapter taskAdapter = (ArticleAdapter) recyclerView.getAdapter();

        if (taskAdapter == null) {
            taskAdapter = new ArticleAdapter();
            recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext()));
            recyclerView.setAdapter(taskAdapter);
        }

        taskAdapter.setItems(newsList, handler);
    }
}
