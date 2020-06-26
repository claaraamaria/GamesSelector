package com.claramaria.gamesselector.storage;

import android.content.Context;
import android.content.SharedPreferences;

import com.claramaria.gamesselector.model.User;
import com.claramaria.gamesselector.utils.Constants;

public class SharedPrefManager {

    private static SharedPrefManager mInstance;
    private Context mCtx;

    private SharedPrefManager(Context mCtx) {
        this.mCtx = mCtx;
    }

    public static synchronized SharedPrefManager getInstance(Context mCtx) {
        if (mInstance == null) {
            mInstance = new SharedPrefManager(mCtx);
        }
        return mInstance;
    }

    public void saveUser(User user) {
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(Constants.SHARED_PREF_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putInt(Constants.KEY_ID, user.getUserId());
        editor.putString(Constants.KEY_EMAIL, user.getEmail());
        editor.putString(Constants.KEY_NAME, user.getName());
        editor.putString(Constants.KEY_TELEPHONE, user.getTelephone());
        editor.putString(Constants.KEY_PASSWORD, user.getPassword());
        editor.putString(Constants.KEY_USERNAME, user.getUserName());
        editor.putString(Constants.KEY_IMAGE_URL, user.getImageUrl());

        editor.apply();
    }

    public boolean isLoggedIn() {
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(Constants.SHARED_PREF_NAME, Context.MODE_PRIVATE);
        // return sharedPreferences.getInt("id", -1) != -1;
        return false;
    }

    public User getUser(){
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(Constants.SHARED_PREF_NAME, Context.MODE_PRIVATE);
        User user = new User();
        user.setUserId(sharedPreferences.getInt(Constants.KEY_ID, -1));
        user.setUserName(sharedPreferences.getString(Constants.KEY_USERNAME, null));
        user.setName(sharedPreferences.getString(Constants.KEY_NAME, null));
        user.setTelephone(sharedPreferences.getString(Constants.KEY_TELEPHONE, null));
        user.setEmail(sharedPreferences.getString(Constants.KEY_EMAIL, null));
        user.setImageUrl(sharedPreferences.getString(Constants.KEY_IMAGE_URL, null));
        user.setPassword(sharedPreferences.getString(Constants.KEY_PASSWORD, null));
        return user;
    }

    public void clear(){
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(Constants.SHARED_PREF_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.clear();
        editor.apply();
    }
}
