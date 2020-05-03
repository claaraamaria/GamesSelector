package com.example.gamesselector3;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.example.gamesselector3.Data;
import com.example.gamesselector3.R;
import com.example.gamesselector3.activities.GamesActivity;
import com.example.gamesselector3.activities.ViewHolder;

import java.util.List;

public class GamesAdapter extends BaseAdapter {

    private GamesActivity gamesActivity;
    private List<Data> parkingList;

    public GamesAdapter(List<Data> apps, GamesActivity activity) {
        this.parkingList = apps;
        gamesActivity = activity;
    }

    @Override
    public int getCount() {
        return parkingList.size();
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        View rowView = convertView;


        if (rowView == null) {

            LayoutInflater inflater = gamesActivity.getLayoutInflater();
            rowView = inflater.inflate(R.layout.item, parent, false);
            // configure view holder
            ViewHolder viewHolder = new ViewHolder();
            GamesActivity.setViewHolder(viewHolder);
            viewHolder.DataText = rowView.findViewById(R.id.bookText);
            viewHolder.background = rowView.findViewById(R.id.background);
            viewHolder.cardImage = rowView.findViewById(R.id.cardImage);
            rowView.setTag(viewHolder);

        } else {
            GamesActivity.setViewHolder((ViewHolder) convertView.getTag());
        }
        GamesActivity.getViewHolder().DataText.setText(parkingList.get(position).getDescription());

        RequestBuilder<Drawable> drawableRequestBuilder = Glide.with(gamesActivity).load(parkingList.get(position).getImagePath());
        drawableRequestBuilder.into(GamesActivity.getViewHolder().cardImage);

        GamesActivity.getViewHolder().cardImage.setImageDrawable(drawableRequestBuilder.getPlaceholderDrawable());
        return rowView;
    }
}
