package com.ergon.test.nasafeedapp.model;

import com.ergon.test.nasafeedapp.model.pojo.Item;

import java.util.ArrayList;

/**
 * Created by daniel on 16.5.16.
 */
public class NewsSingleton {

    private ArrayList<Item> mNews;

    private static NewsSingleton ourInstance = new NewsSingleton();

    public static NewsSingleton getInstance() {
        return ourInstance;
    }

    private NewsSingleton() {
        mNews = new ArrayList<Item>();
    }

    public ArrayList<Item> getNews() {
        return mNews;
    }

    public void setNews(ArrayList<Item> news) {
        for (int i = 0; i < news.size(); i++) {
            mNews.add(news.get(i));
        }
    }

    public Item getItem(String newsTitle) {
        for (Item item : mNews) {
            if (item.getTitle().equals(newsTitle))
                return item;
        }
        return null;
    }

}
