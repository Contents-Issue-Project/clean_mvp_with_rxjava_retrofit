package com.example.myapplication.data.trending;

import com.example.myapplication.domain.trending.TrendingDataSource;

import io.reactivex.Flowable;

public class TrendingLocal implements TrendingDataSource {
    @Override
    public Flowable<TrendingResource> getTrending(TrendingParam trendingParam) {
        return null;
    }
}
