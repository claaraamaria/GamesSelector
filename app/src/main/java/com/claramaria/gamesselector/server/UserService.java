package com.claramaria.gamesselector.server;

import com.claramaria.gamesselector.model.User;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface UserService {

    @FormUrlEncoded
    @POST("users")
    Call<ResponseBody> createUser(
            @Field("name") String name,
            @Field("userName") String userName,
            @Field("email") String email,
            @Field("phone") String phone,
            @Field("password") String password
    );

    @FormUrlEncoded
    @GET("users")
    Call<User> loginUser(
            @Field("userName") String userName,
            @Field("password") String password
    );
}
