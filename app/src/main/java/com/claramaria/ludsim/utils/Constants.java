package com.claramaria.ludsim.utils;

import android.content.Context;
import android.content.Intent;

import com.claramaria.ludsim.activities.RoomActivity;
import com.claramaria.ludsim.model.CardImage;

public class Constants {
    public static final String KEY_ID="id";
    public static final String KEY_EMAIL="email";
    public static final String KEY_USERNAME="userName";
    public static final String KEY_PASSWORD="password";
    public static final String KEY_TELEPHONE ="telephone";
    public static final String KEY_NAME="name";
    public static final String KEY_IMAGE_URL="imageUrl";
    public static final String SHARED_PREF_NAME = "my_shared_preff";

    public static final String KEY_OWNER_ID="o_id";
    public static final String KEY_OWNER_EMAIL="o_email";
    public static final String KEY_OWNER_USERNAME="o_userName";
    public static final String KEY_OWNER_PASSWORD="o_password";
    public static final String KEY_OWNER_TELEPHONE ="o_telephone";
    public static final String KEY_OWNER_NAME="o_name";
    public static final String KEY_OWNER_IMAGE_URL="o_imageUrl";


    public static final String IMAGE_INDEX = "ImageIndex";
    public static final String DESCRIPTION = "DescriptonKey";

    public static Intent constructIntent(Context ctx, CardImage cardImage) {
        Intent myIntent = new Intent(ctx, RoomActivity.class);
        myIntent.putExtra(IMAGE_INDEX, cardImage.getImagePath());
        myIntent.putExtra(DESCRIPTION, cardImage.getDescription());
        return myIntent;
    }
}
