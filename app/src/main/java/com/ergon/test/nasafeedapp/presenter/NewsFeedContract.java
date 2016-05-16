package com.ergon.test.nasafeedapp.presenter;

import com.ergon.test.nasafeedapp.model.pojo.Item;

import java.util.ArrayList;

/**
 * Created by daniel on 15.5.16.
 */
public interface NewsFeedContract {

    interface FeedPresenter {
        void loadNewsFeed();
        void loadNewsDetails(String news);

    }

    interface FeedView {
        void onLoadNewsSuccess(ArrayList<Item> loadedNews);
        void onLoadNewsFail(String error);

        void onShowDetailsSuccess(String newsTitle);
        void onShowDetailsFail(String error);
    }

}
