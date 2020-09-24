package com.example.myapplication.presentation.trending;

import com.example.myapplication.data.trending.TrendingParam;
import com.example.myapplication.data.trending.TrendingResource;
import com.example.myapplication.domain.trending.TrendingUseCase;

public class TrendingPresenter implements TrendingContract.Presenter {
    private TrendingContract.View view;
    private TrendingUseCase trendingUseCase;

    public TrendingPresenter(TrendingContract.View view) {
        this.view = view;
        trendingUseCase = new TrendingUseCase();
    }

    @Override
    public void loadTrending(TrendingParam trendingParam) {
        //TODO 얘도 사실은 주입해줘야
        trendingUseCase.execute(trendingParam, (response)->{
           bindView(response);
        });
    }

    @Override
    public void bindView(TrendingResource trendingResource) {
        view.setUpContent(trendingResource);
    }
}
