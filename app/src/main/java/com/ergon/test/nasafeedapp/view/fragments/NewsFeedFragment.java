package com.ergon.test.nasafeedapp.view.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ergon.test.nasafeedapp.R;
import com.ergon.test.nasafeedapp.model.NewsSingleton;
import com.ergon.test.nasafeedapp.model.adapter.NewsAdapter;
import com.ergon.test.nasafeedapp.model.pojo.Item;
import com.ergon.test.nasafeedapp.presenter.NewsFeedContract;
import com.ergon.test.nasafeedapp.presenter.NewsFeedPresenter;
import com.ergon.test.nasafeedapp.view.activities.NewsDetailActivity;

import java.util.ArrayList;

/**
 * Created by daniel on 15.5.16.
 */
public class NewsFeedFragment extends Fragment implements NewsFeedContract.FeedView {

    private static final String TAG = "NewsFeedFragment";
    private RecyclerView mNewsRecycler;
    private ArrayList<Item> mItems;
    private NewsAdapter mAdapter;
    private NewsFeedPresenter mNewsFeedPresenter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_news_feed, container, false);

        mItems = NewsSingleton.getInstance().getNews();
        mAdapter = new NewsAdapter(mItems, mListener);

        mNewsRecycler = (RecyclerView) root.findViewById(R.id.news_recycler_view);
        mNewsRecycler.setLayoutManager(new LinearLayoutManager(getActivity()));
        mNewsRecycler.setAdapter(mAdapter);

        mNewsFeedPresenter = new NewsFeedPresenter(this);

        return root;
    }

    public NewsAdapter.NewsItemListener mListener = new NewsAdapter.NewsItemListener() {
        @Override
        public void onNewsClick(Item news) {
            mNewsFeedPresenter.loadNewsDetails(news.getTitle());
        }
    };

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if (NewsSingleton.getInstance().getNews().size() == 0) {
            mNewsFeedPresenter.loadNewsFeed();
        }
    }

    @Override
    public void onLoadNewsSuccess(ArrayList<Item> loadedNews) {
        mAdapter.addNews(loadedNews);
        Log.i(TAG, "onLoadNewsSuccess: ");
    }

    @Override
    public void onLoadNewsFail(String error) {
        Log.e(TAG, "onLoadNewsFail: " + error);
    }

    @Override
    public void onShowDetailsSuccess(String newsTitle) {
        Intent intent = new Intent(getContext(), NewsDetailActivity.class);
        intent.putExtra(NewsDetailActivity.EXTRA_NEWS_TITLE, newsTitle);
        startActivity(intent);
    }

    @Override
    public void onShowDetailsFail(String error) {
        Log.e(TAG, "onShowDetailsFail: " + error );
    }

}
