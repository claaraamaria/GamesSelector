package com.claramaria.gamesselector.server;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RESTClient {
    private static final String BASE_URL = "http://server-env.eba-xyvg76az.eu-central-1.elasticbeanstalk.com/";
    private static RESTClient mInstance;
    private Retrofit retrofit;

    private RESTClient(){
        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public static synchronized RESTClient getInstance(){
        if(mInstance == null){
            mInstance= new RESTClient();
        }
        return mInstance;
    }

    public UserService getApi(){
        return retrofit.create(UserService.class);
    }
}
