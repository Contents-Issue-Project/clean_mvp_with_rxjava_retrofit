package com.example.myapplication.data.trending;

import com.example.myapplication.domain.trending.TrendingDataSource;
import com.example.myapplication.util.DataUnavailableException;
import com.example.myapplication.util.WrongRequestException;

import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class TrendingRemote implements TrendingDataSource {

    @Override
    public Single<TrendingResource> getTrending(TrendingParam trendingParam) {
        //TODO 재사용 불가능?
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.themoviedb.org/3/")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();

        return retrofit.create(TrendingApi.class).getTrending(
                trendingParam.mediaType,trendingParam.timeWindow,trendingParam.apiKey)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .flatMap((response)->{
                    switch(response.code()){
                        case 200:
                            return Single.just(response.body());
                        case 204:
                            return Single.just(new TrendingResource());
                        case 400:
                        case 401:
                        case 404:
                            throw new WrongRequestException(response.message());
                        case 500:
                        case 502:
                        case 503:
                            throw new DataUnavailableException(response.message());
                        default:
                            throw new RuntimeException(response.message());
                    }
                });
    }
}
