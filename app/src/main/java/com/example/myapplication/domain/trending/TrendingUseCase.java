package com.example.myapplication.domain.trending;

import com.example.myapplication.data.trending.TrendingParam;
import com.example.myapplication.data.trending.TrendingResource;
import com.example.myapplication.domain.UseCase;

import io.reactivex.Single;

public class TrendingUseCase extends UseCase<TrendingParam, TrendingResource> {
    private TrendingService mTrendingService;

    public TrendingUseCase() {
        mTrendingService = new TrendingServiceImpl();
    }

//    public void setTrendingService(TrendingService mTrendingService) {
//        this.mTrendingService = mTrendingService;
//    }


    @Override
    protected Single<TrendingResource> buildUseCaseSingle(TrendingParam trendingParam) {
        return mTrendingService.getTrending(trendingParam);
    }

}
