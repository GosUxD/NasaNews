package com.ergon.test.nasafeedapp.view.activities;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.ergon.test.nasafeedapp.R;
import com.ergon.test.nasafeedapp.view.fragments.NewsFeedFragment;

/**
 * Created by daniel on 16.5.16.
 */
public abstract class SingleFragmentActivity extends AppCompatActivity {

    private Toolbar mToolbar;

    protected abstract Fragment createFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_fragment);

        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(mToolbar);

        FragmentManager fm = getSupportFragmentManager();
        Fragment fragment = fm.findFragmentById(R.id.new_fragment_container);

        if (fragment == null) {
            fragment = createFragment();
            fm.beginTransaction()
                    .add(R.id.new_fragment_container, fragment)
                    .commit();
        }

    }
}

