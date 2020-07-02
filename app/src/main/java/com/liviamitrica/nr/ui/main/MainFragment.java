package com.liviamitrica.nr.ui.main;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

import com.liviamitrica.nr.databinding.MainFragmentBinding;
import com.liviamitrica.nr.ui.main.model.NewsListViewModel;
import com.liviamitrica.nr.ui.main.model.factory.ViewModelFactory;
import com.liviamitrica.nr.ui.main.navigator.AlertNavigator;

public class MainFragment extends Fragment {

    private NewsListViewModel mViewModel;
    private AlertNavigator alertNavigator;

    public static MainFragment newInstance() {
        return new MainFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        MainFragmentBinding binding = MainFragmentBinding.inflate(inflater, container, false);
        binding.setViewModel(mViewModel);
        return binding.getRoot();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        alertNavigator = new AlertNavigator(getChildFragmentManager(), requireContext());

        mViewModel = new ViewModelProvider(this, new ViewModelFactory(requireActivity().getApplication())).get(NewsListViewModel.class);
        mViewModel.error.observe(this, throwable -> alertNavigator.showErrorFor(throwable));
        mViewModel.openLink.observe(this, link -> openLink(link));
        getLifecycle().addObserver(mViewModel);
    }

    private void openLink(@NonNull String link) {
        Intent i = new Intent(Intent.ACTION_VIEW);
        i.setData(Uri.parse(link));
        startActivity(i);
    }
}