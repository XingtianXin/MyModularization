package com.example.basemodule.base;

import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.LayoutRes;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.example.basemodule.R;

import dagger.android.AndroidInjection;
import dagger.android.AndroidInjector;

/**
 * Created by Xingtian.Xin
 * Date: 2019/7/4
 * Time: 16:00
 */
public abstract class BaseActivity extends AppCompatActivity implements FragmentManager.OnBackStackChangedListener {
    private static final String TAG = BaseActivity.class.getSimpleName();
    protected TextView vTxtToolbarTitle;
    protected Toolbar vToolbar;

    @LayoutRes
    protected abstract int getLayoutId();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(getLayoutId());

        vToolbar = findViewById(R.id.toolbar);
        if (vToolbar != null) {
            setSupportActionBar(vToolbar);
            getSupportActionBar().setDisplayShowTitleEnabled(false);
        }

    }

    @Override
    public void setTitle(CharSequence title) {
        if (vTxtToolbarTitle != null) {
            vTxtToolbarTitle.setText(title);
        } else {
            super.setTitle(title);
        }
    }

    @Override
    public void setTitle(int titleId) {
        setTitle(getString(titleId));
    }

    @Override
    public void onBackStackChanged() {
        if (getSupportFragmentManager().getBackStackEntryCount() == 0) {
            getSupportFragmentManager().removeOnBackStackChangedListener(this);
        }
    }
}
