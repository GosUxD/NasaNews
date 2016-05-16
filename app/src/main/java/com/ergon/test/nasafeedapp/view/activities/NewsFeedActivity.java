package com.ergon.test.nasafeedapp.view.activities;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import com.ergon.test.nasafeedapp.R;
import com.ergon.test.nasafeedapp.view.fragments.NewsFeedFragment;

public class NewsFeedActivity extends SingleFragmentActivity {

    private static final String TAG = "NewsFeedActivity";

    @Override
    protected Fragment createFragment() {
        return new NewsFeedFragment();
    }
}
