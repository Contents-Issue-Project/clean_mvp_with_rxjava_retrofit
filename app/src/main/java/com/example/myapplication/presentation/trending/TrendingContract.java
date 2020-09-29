package com.example.myapplication.presentation.trending;

import com.example.myapplication.data.trending.TrendingParam;
import com.example.myapplication.data.trending.TrendingResource;
import com.example.myapplication.util.DataUnavailableException;
import com.example.myapplication.util.WrongRequestException;

public interface TrendingContract {
    interface View{
        public void setUpContent(TrendingResource trendingResource);
        public void handleWrongRequest(WrongRequestException exception);
        public void handleDataUnavailable(DataUnavailableException exception);
    }
    interface Presenter{
        void loadTrending(TrendingParam trendingParam);
        void bindView(TrendingResource trendingResource);
    }
}
