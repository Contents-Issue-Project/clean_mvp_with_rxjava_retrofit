package com.example.myapplication.data.trending;

import com.example.myapplication.data.Repository;
import com.example.myapplication.domain.trending.TrendingDataSource;

import io.reactivex.Single;

public class TrendingRepository extends Repository<TrendingResource> implements TrendingDataSource {
    private static TrendingRepository INSTANCE = null;

    private final TrendingDataSource mTrendingRemote;

//    TODO singleton인데 매개변수 받는게 맞나?
//    private TrendingRepository(TrendingDataSource trendingRemote){
    private TrendingRepository(){
        mTrendingRemote = new TrendingRemote();
    }

//    public static TrendingRepository getInstance(TrendingDataSource trendingRemote){
    public static TrendingRepository getInstance(){
        if (INSTANCE == null){
            INSTANCE = new TrendingRepository();
        }
        return INSTANCE;
    }

    @Override
    public Single<TrendingResource> getTrending(TrendingParam trendingParam) {
        return setThread(mTrendingRemote.getTrending(trendingParam));
    }
}
