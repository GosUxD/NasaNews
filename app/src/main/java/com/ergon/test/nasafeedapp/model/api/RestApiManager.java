package com.ergon.test.nasafeedapp.model.api;

import com.ergon.test.nasafeedapp.model.utils.Constants;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by daniel on 15.5.16.
 */
public class RestApiManager {

    NewsApi mNewsApi;


    public NewsApi getNewsApi() {
        if(mNewsApi == null) {
            Retrofit client = new Retrofit.Builder()
                    .baseUrl(Constants.BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            mNewsApi = client.create(NewsApi.class);
        }
        return mNewsApi;
    }

}
