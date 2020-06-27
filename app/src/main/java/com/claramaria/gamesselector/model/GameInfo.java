package com.claramaria.gamesselector.model;

import android.os.Parcel;
import android.os.Parcelable;

public class GameInfo implements Parcelable {
    private int mImageResource;
    private String mTitle;
    private String mDescription;

    public GameInfo(int imageResource, String title, String description) {
        mImageResource = imageResource;
        mTitle = title;
        mDescription = description;
    }

    private GameInfo(Parcel in) {
        mImageResource = in.readInt();
        mTitle = in.readString();
        mDescription = in.readString();
    }

    public static final Creator<GameInfo> CREATOR = new Creator<GameInfo>() {
        @Override
        public GameInfo createFromParcel(Parcel in) {
            return new GameInfo(in);
        }

        @Override
        public GameInfo[] newArray(int size) {
            return new GameInfo[size];
        }
    };

    public int getImageResource() {
        return mImageResource;
    }

    public String getTitle() {
        return mTitle;
    }

    public String getDescription() {
        return mDescription;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(mImageResource);
        dest.writeString(mTitle);
        dest.writeString(mDescription);
    }
}
