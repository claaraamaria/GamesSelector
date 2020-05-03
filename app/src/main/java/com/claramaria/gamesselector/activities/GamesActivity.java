package com.claramaria.gamesselector.activities;

import androidx.appcompat.app.AppCompatActivity;


public abstract class GamesActivity extends AppCompatActivity {
    private ViewHolder viewHolder;

    public ViewHolder getViewHolder() {
        return viewHolder;
    }

    public void setViewHolder(ViewHolder viewHolder) {
        this.viewHolder = viewHolder;
    }
}
