package com.liviamitrica.nr.ui.main.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.liviamitrica.nr.databinding.ArticleItemFragmentBinding;
import com.liviamitrica.nr.ui.main.listener.NewsArticleHandler;
import com.liviamitrica.nr.ui.main.model.ArticleItemViewModel;

import java.util.ArrayList;
import java.util.List;

public class ArticleAdapter extends RecyclerView.Adapter<ArticleAdapter.NewsArticleViewHolder> {

    private List<ArticleItemViewModel> articleItemViewModels;
    private NewsArticleHandler handler;

    public ArticleAdapter() {
        this.articleItemViewModels = new ArrayList<>();
    }

    @Override
    public NewsArticleViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ArticleItemFragmentBinding binder = ArticleItemFragmentBinding.
                inflate(LayoutInflater.from(parent.getContext()),parent, false);

        return new NewsArticleViewHolder(binder);
    }

    @Override
    public void onBindViewHolder(@NonNull NewsArticleViewHolder holder, int position) {
        holder.binding.setViewModel(articleItemViewModels.get(position));
        //point all clicks to a single interface for all items
        holder.binding.setHandler(handler);
    }

    @Override
    public int getItemCount() {
        return articleItemViewModels.size();
    }

    public void setItems(List<ArticleItemViewModel> items, NewsArticleHandler handler) {
        this.handler = handler;
        this.articleItemViewModels = items;
        notifyDataSetChanged();
    }

    public class NewsArticleViewHolder extends RecyclerView.ViewHolder{
        final ArticleItemFragmentBinding binding;

        public NewsArticleViewHolder(ArticleItemFragmentBinding binding){
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
