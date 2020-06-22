package com.claramaria.gamesselector.server;

import com.claramaria.gamesselector.model.User;

import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface UserService {

    @POST("users")
    Call<ResponseBody> createUser(@Body User user);

    @GET("users")
    Call<List<User>> loginUser(
            @Query("userName") String userName,
            @Query("password") String password
    );

    @GET("users")
    Call<List<User>> getUsers();
}
