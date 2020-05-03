package com.example.gamesselector3;

import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.example.gamesselector3.activities.GamesActivity;
import com.example.gamesselector3.activities.ViewHolder;

import java.util.List;

public class GamesAdapter extends BaseAdapter {

    private GamesActivity gamesActivity;
    private List<Data> parkingList;

    public GamesAdapter(List<Data> dataList, GamesActivity activity) {
        this.parkingList = dataList;
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
            gamesActivity.setViewHolder(viewHolder);
            viewHolder.DataText = rowView.findViewById(R.id.bookText);
            viewHolder.background = rowView.findViewById(R.id.background);
            viewHolder.cardImage = rowView.findViewById(R.id.cardImage);
            rowView.setTag(viewHolder);

        } else {
            gamesActivity.setViewHolder((ViewHolder) convertView.getTag());
        }
        gamesActivity.getViewHolder().DataText.setText(parkingList.get(position).getDescription());

        RequestBuilder<Drawable> drawableRequestBuilder = Glide.with(gamesActivity).load(parkingList.get(position).getImagePath());
        drawableRequestBuilder.into(gamesActivity.getViewHolder().cardImage);

        gamesActivity.getViewHolder().cardImage.setImageDrawable(drawableRequestBuilder.getPlaceholderDrawable());
        return rowView;
    }
}
