package com.ergon.test.nasafeedapp.presenter;

import com.ergon.test.nasafeedapp.model.api.RestApiManager;
import com.ergon.test.nasafeedapp.model.pojo.Item;
import com.ergon.test.nasafeedapp.model.pojo.News;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by daniel on 15.5.16.
 */
public class NewsFeedPresenter implements NewsFeedContract.FeedPresenter {

    private static final String TAG = "NewsFeedPresenter";
    private NewsFeedContract.FeedView mFeedView;
    private RestApiManager mRestApiManager;

    public NewsFeedPresenter(NewsFeedContract.FeedView feedView) {
        mFeedView = feedView;
        mRestApiManager = new RestApiManager();
    }

    @Override
    public void loadNewsFeed() {
        mRestApiManager.getNewsApi().getNews().enqueue(new Callback<News>() {
            @Override
            public void onResponse(Call<News> call, Response<News> response) {
                mFeedView.onLoadNewsSuccess((ArrayList<Item>) response.body().getItems());
            }

            @Override
            public void onFailure(Call<News> call, Throwable t) {
                mFeedView.onLoadNewsFail(t.toString());
            }
        });
    }

    @Override
    public void loadNewsDetails(String newsTitle) {
        mFeedView.onShowDetailsSuccess(newsTitle);
    }
}
