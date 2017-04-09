package com.srainbow.leisureten.NetRequest;


import com.srainbow.leisureten.data.APIData.FunnyPicData;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by SRainbow on 2016/9/29.
 */
public interface RequestApi {
    @GET("joke/randJoke.php?type=pic")
    Observable<FunnyPicData> getFunnyPicData(@Query("key") String key);
}
