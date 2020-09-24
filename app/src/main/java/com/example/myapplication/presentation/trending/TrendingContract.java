package com.example.myapplication.presentation.trending;

import com.example.myapplication.data.trending.TrendingParam;
import com.example.myapplication.data.trending.TrendingResource;

public interface TrendingContract {
    interface View{
        public void setUpContent(TrendingResource trendingResource);
    }
    interface Presenter{
        void loadTrending(TrendingParam trendingParam);
        void bindView(TrendingResource trendingResource);
    }
}
