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
        editor.putString(Constants.KEY_PHONE, user.getTelephone());

        editor.apply();
    }

    public boolean isLoggedIn() {
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(Constants.SHARED_PREF_NAME, Context.MODE_PRIVATE);
        return sharedPreferences.getInt("id", -1) != -1;
    }

    public User getUser(){
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(Constants.SHARED_PREF_NAME, Context.MODE_PRIVATE);
        return new User(
                sharedPreferences.getInt(Constants.KEY_ID, -1),
                sharedPreferences.getString(Constants.KEY_USERNAME, null),
                sharedPreferences.getString(Constants.KEY_NAME, null),
                sharedPreferences.getString(Constants.KEY_PHONE, null),
                sharedPreferences.getString(Constants.KEY_EMAIL, null),
                sharedPreferences.getString(Constants.KEY_PASSWORD, null),
                sharedPreferences.getString(Constants.KEY_IMAGE, null)
                );
    }

    public void clear(){
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(Constants.SHARED_PREF_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.clear();
        editor.apply();
    }
}
