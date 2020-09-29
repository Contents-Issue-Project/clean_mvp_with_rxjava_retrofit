package com.example.myapplication.domain.trending;

import com.example.myapplication.data.trending.TrendingParam;
import com.example.myapplication.data.trending.TrendingResource;

import io.reactivex.Single;

public interface TrendingService {
    public Single<TrendingResource> getTrending(TrendingParam trendingParam);
}
