package com.ergon.test.nasafeedapp.model.api;

import com.ergon.test.nasafeedapp.model.pojo.News;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by daniel on 15.5.16.
 */
public interface NewsApi {

    @GET("api.json?rss_url=https%3A%2F%2Fwww.nasa.gov%2Frss%2Fdyn%2Fbreaking_news.rss")
    Call<News> getNews();

}
