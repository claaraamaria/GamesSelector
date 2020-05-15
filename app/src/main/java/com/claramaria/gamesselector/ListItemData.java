package com.claramaria.gamesselector;

import android.os.Parcel;
import android.os.Parcelable;

public class ListItemData implements Parcelable {
    private int mImageResource;
    private String mText1;
    private String mText2;

    public ListItemData(int imageResource, String text1, String text2) {
        mImageResource = imageResource;
        mText1 = text1;
        mText2 = text2;
    }

    private ListItemData(Parcel in) {
        mImageResource = in.readInt();
        mText1 = in.readString();
        mText2 = in.readString();
    }

    public static final Creator<ListItemData> CREATOR = new Creator<ListItemData>() {
        @Override
        public ListItemData createFromParcel(Parcel in) {
            return new ListItemData(in);
        }

        @Override
        public ListItemData[] newArray(int size) {
            return new ListItemData[size];
        }
    };

    int getImageResource() {
        return mImageResource;
    }

    String getText1() {
        return mText1;
    }

    String getText2() {
        return mText2;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(mImageResource);
        dest.writeString(mText1);
        dest.writeString(mText2);
    }
}
