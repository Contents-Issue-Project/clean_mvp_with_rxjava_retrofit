package com.example.myapplication.domain;

import io.reactivex.Single;

public abstract class UseCase<RequestFormat, ResponseFormat> {
    public void execute(RequestFormat requestParam, ISuccessCallBack<ResponseFormat> successCallback,
                        IErrorCallBack errorCallback){
        buildUseCaseSingle(requestParam)
                .subscribe((response)->successCallback.onResponse(response),
                        (e)->errorCallback.onError(e));
    }
    protected abstract Single<ResponseFormat> buildUseCaseSingle(RequestFormat requestParam);

    public interface ISuccessCallBack<ResponseFormat>{
        void onResponse(ResponseFormat response);
    }
    public interface IErrorCallBack{
        void onError(Throwable e);
    }
}
