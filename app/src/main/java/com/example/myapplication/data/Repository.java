package com.example.myapplication.data;

import io.reactivex.Single;
import io.reactivex.schedulers.Schedulers;

public abstract class Repository<ResponseFormat> {
    protected Single<ResponseFormat> setThread(Single<ResponseFormat> response){
        return response.subscribeOn(Schedulers.io())
                .observeOn(Schedulers.computation());
    }
}
