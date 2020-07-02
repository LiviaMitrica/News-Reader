package com.liviamitrica.nr;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.liviamitrica.nr.ui.main.MainFragment;

import io.reactivex.disposables.Disposable;

public class MainActivity extends AppCompatActivity {
    private Disposable disposable;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.container, MainFragment.newInstance())
                    .commitNow();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        if (disposable != null) {
            disposable.dispose();
        }
    }
}