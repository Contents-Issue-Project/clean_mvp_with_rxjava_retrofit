package com.example.myapplication.data.trending;

import com.example.myapplication.data.trending.TrendingResource;
import io.reactivex.Single;
import retrofit2.Response;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface TrendingApi {
    @GET("trending/{media_type}/{time_window}?")
    Single<Response<TrendingResource>> getTrending(@Path("media_type") String mediaType,
                                                   @Path("time_window") String timeWindow,
                                                   @Query("api_key") String apiKey);
}
