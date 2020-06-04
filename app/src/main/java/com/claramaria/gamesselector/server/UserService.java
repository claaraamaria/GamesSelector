package com.claramaria.gamesselector.server;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface UserService {

    @FormUrlEncoded
    @POST("users")
    Call<ResponseBody> createUser(
            @Field("userName") String userName,
            @Field("password") String password);
}
