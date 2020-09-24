package com.example.myapplication.domain.trending;

import com.example.myapplication.data.trending.TrendingParam;
import com.example.myapplication.data.trending.TrendingResource;

import io.reactivex.Flowable;

public interface TrendingDataSource {
    Flowable<TrendingResource> getTrending(TrendingParam trendingParam);
}
