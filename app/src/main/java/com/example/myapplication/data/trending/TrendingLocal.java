package com.example.myapplication.data.trending;

import com.example.myapplication.domain.trending.TrendingDataSource;

import io.reactivex.Single;

public class TrendingLocal implements TrendingDataSource {
    @Override
    public Single<TrendingResource> getTrending(TrendingParam trendingParam) {
        return null;
    }
}
