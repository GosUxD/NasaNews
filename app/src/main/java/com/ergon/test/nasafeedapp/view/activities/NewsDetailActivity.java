package com.ergon.test.nasafeedapp.view.activities;

import android.os.Bundle;
import android.support.v4.app.Fragment;

import com.ergon.test.nasafeedapp.view.fragments.NewsDetailFragment;

public class NewsDetailActivity extends SingleFragmentActivity {

    public static final String EXTRA_NEWS_TITLE = "NEWS_TITLE";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
    }

    @Override
    protected Fragment createFragment() {
        String newsTitle = getIntent().getStringExtra(EXTRA_NEWS_TITLE);
        return NewsDetailFragment.newInstance(newsTitle);
    }
}
