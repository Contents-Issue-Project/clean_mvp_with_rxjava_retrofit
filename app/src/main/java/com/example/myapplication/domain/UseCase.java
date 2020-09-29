package com.example.myapplication.domain;

import io.reactivex.Single;

public abstract class UseCase<RequestFormat, ResponseFormat> {
    public void execute(RequestFormat requestParam, ICallBack<ResponseFormat> callback){
        buildUseCaseSingle(requestParam)
                .subscribe((response)->callback.onResponse(response));
    }
    protected abstract Single<ResponseFormat> buildUseCaseSingle(RequestFormat requestParam);

    public interface ICallBack<ResponseFormat>{
        void onResponse(ResponseFormat response);
    }
}
