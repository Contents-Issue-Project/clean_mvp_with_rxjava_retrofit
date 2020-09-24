package com.example.myapplication.domain.trending;

import com.example.myapplication.data.trending.TrendingParam;
import com.example.myapplication.data.trending.TrendingRepository;
import com.example.myapplication.data.trending.TrendingResource;

import io.reactivex.Flowable;

public class TrendingServiceImpl implements TrendingService {
    //원래 주입되어야 함
    private TrendingDataSource mTrendingDataSource;

    public TrendingServiceImpl(){
        mTrendingDataSource = TrendingRepository.getInstance();
    }

    @Override
    public Flowable<TrendingResource> getTrending(TrendingParam trendingParam) {
        return mTrendingDataSource.getTrending(trendingParam)
                .flatMap(this::someProcessing);
    }

    private Flowable<TrendingResource> someProcessing(TrendingResource resourceFlowable){
        System.out.println("some processing");
        return Flowable.just(resourceFlowable);
    }
}
