package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.myapplication.data.trending.TrendingParam;
import com.example.myapplication.data.trending.TrendingResource;
import com.example.myapplication.presentation.trending.MovieAdapter;
import com.example.myapplication.presentation.trending.MovieItem;
import com.example.myapplication.presentation.trending.TrendingContract;
import com.example.myapplication.presentation.trending.TrendingPresenter;

public class MainActivity extends AppCompatActivity {

    private TrendingContract.Presenter trendingPresenter;
    private Button requestBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        requestBtn = (Button) findViewById(R.id.request_button);
        requestBtn.setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick(View view) {
                TrendingParam param = new TrendingParam();
                param.mediaType = "movie";
                param.timeWindow = "day";
                param.apiKey = "yourAPIKey";
                trendingPresenter.loadTrending(param);
            }
        });

        RecyclerView movieRecyclerView = (RecyclerView) findViewById(R.id.movie_recycler_view);
        movieRecyclerView.setHasFixedSize(true);

        MovieAdapter movieAdapter = new MovieAdapter();
        movieAdapter.addItem(new MovieItem("avengers", 3.5));
        movieAdapter.addItem(new MovieItem("avengers3", 4.5));
        movieRecyclerView.setAdapter(movieAdapter);

        LinearLayoutManager movieLayoutManager = new LinearLayoutManager(this);
        movieRecyclerView.setLayoutManager(movieLayoutManager);

        trendingPresenter = new TrendingPresenter(movieAdapter);
    }

//    //TODO 원래 받을 때, 다른 data타입 정의해야 한다. 같은 API를 호출하지만 다른 결과를 반환하는 서비스도 가능하므로.
//    @Override
//    public void setUpContent(TrendingResource trendingResource) {
//        System.out.println(Thread.currentThread());
//        for (TrendingResource.Movie movie:
//             trendingResource.data) {
//            System.out.println("title : "+ movie.title);
//        }
//    }
}