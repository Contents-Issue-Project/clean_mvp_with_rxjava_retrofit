package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.myapplication.data.trending.TrendingParam;
import com.example.myapplication.data.trending.TrendingResource;
import com.example.myapplication.presentation.trending.TrendingContract;
import com.example.myapplication.presentation.trending.TrendingPresenter;

public class MainActivity extends AppCompatActivity implements TrendingContract.View {

    private TrendingContract.Presenter trendingPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        trendingPresenter = new TrendingPresenter(this);
        TrendingParam param = new TrendingParam();
        param.mediaType = "movie";
        param.timeWindow = "day";
        param.apiKey = "yourAPI";
        trendingPresenter.loadTrending(param);
    }

    //TODO 원래 받을 때, 다른 data타입 정의해야 한다. 같은 API를 호출하지만 다른 결과를 반환하는 서비스도 가능하므로.
    @Override
    public void setUpContent(TrendingResource trendingResource) {
        System.out.println(Thread.currentThread());
        for (TrendingResource.Movie movie:
             trendingResource.data) {
            System.out.println("title : "+ movie.title);
        }
    }
}