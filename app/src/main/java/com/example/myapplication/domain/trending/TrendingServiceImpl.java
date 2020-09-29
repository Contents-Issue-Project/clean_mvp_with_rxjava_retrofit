package com.example.myapplication.domain.trending;

import com.example.myapplication.data.trending.TrendingParam;
import com.example.myapplication.data.trending.TrendingRepository;
import com.example.myapplication.data.trending.TrendingResource;

import io.reactivex.Single;

public class TrendingServiceImpl implements TrendingService {
    //원래 주입되어야 함
    private TrendingDataSource mTrendingDataSource;

    public TrendingServiceImpl(){
        mTrendingDataSource = TrendingRepository.getInstance();
    }

    @Override
    public Single<TrendingResource> getTrending(TrendingParam trendingParam) {
        return mTrendingDataSource.getTrending(trendingParam)
                .flatMap(this::someProcessing);
    }

    private Single<TrendingResource> someProcessing(TrendingResource resourceSingle){
        System.out.println("some processing");
        return Single.just(resourceSingle);
    }
}
