package com.example.myapplication.data.trending;

import com.example.myapplication.domain.trending.TrendingDataSource;

import io.reactivex.Single;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class TrendingRemote implements TrendingDataSource {

    @Override
    public Single<TrendingResource> getTrending(TrendingParam trendingParam) {
        //TODO 재사용 불가능?
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.themoviedb.org/3/")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();

        return retrofit.create(TrendingApi.class).getTrending(
                trendingParam.mediaType,trendingParam.timeWindow,trendingParam.apiKey);
    }
}
