package com.example.myapplication.domain;

import io.reactivex.Flowable;

public abstract class UseCase<RequestFormat, ResponseFormat> {
    public void execute(RequestFormat requestParam, ICallBack<ResponseFormat> callback){
        buildUseCaseFlowable(requestParam)
                .subscribe((response)->callback.onResponse(response));
    }
    protected abstract Flowable<ResponseFormat> buildUseCaseFlowable(RequestFormat requestParam);

    public interface ICallBack<ResponseFormat>{
        void onResponse(ResponseFormat response);
    }
}
