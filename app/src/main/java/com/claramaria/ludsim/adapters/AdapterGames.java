package com.claramaria.ludsim.adapters;

import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.claramaria.ludsim.R;
import com.claramaria.ludsim.activities.Games;
import com.claramaria.ludsim.model.CardImage;
import com.claramaria.ludsim.model.ViewHolder;

import java.util.List;

public class AdapterGames extends BaseAdapter {

    private final Games games;
    private final List<CardImage> parkingList;

    public AdapterGames(List<CardImage> dataList, Games activity) {
        this.parkingList = dataList;
        games = activity;
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
        if (convertView == null) {
            LayoutInflater inflater = games.getLayoutInflater();
            rowView = inflater.inflate(R.layout.item_card, parent, false);
            // configure view holder
            ViewHolder viewHolder = new ViewHolder();
            games.setViewHolder(viewHolder);
            viewHolder.dataText = rowView.findViewById(R.id.bookText);
            viewHolder.background = rowView.findViewById(R.id.background);
            viewHolder.cardImage = rowView.findViewById(R.id.cardImage);
            rowView.setTag(viewHolder);

        } else {
            games.setViewHolder((ViewHolder) convertView.getTag());
        }
        games.getViewHolder().dataText.setText(parkingList.get(position).getDescription());

        RequestBuilder<Drawable> drawableRequestBuilder = Glide.with(games).load(parkingList.get(position).getImagePath());
        drawableRequestBuilder.into(games.getViewHolder().cardImage);

        games.getViewHolder().cardImage.setImageDrawable(drawableRequestBuilder.getPlaceholderDrawable());
        return rowView;
    }
}
