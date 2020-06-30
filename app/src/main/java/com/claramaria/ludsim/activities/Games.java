package com.claramaria.ludsim.activities;

import androidx.appcompat.app.AppCompatActivity;

import com.claramaria.ludsim.model.ViewHolder;


public abstract class Games extends AppCompatActivity {
    private ViewHolder viewHolder;

    public ViewHolder getViewHolder() {
        return viewHolder;
    }

    public void setViewHolder(ViewHolder viewHolder) {
        this.viewHolder = viewHolder;
    }
}
