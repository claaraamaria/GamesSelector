package com.example.gamesselector3.activities;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.gamesselector3.Data;
import com.example.gamesselector3.FactoryCardsInfo;
import com.example.gamesselector3.GamesAdapter;
import com.example.gamesselector3.R;
import com.lorentzos.flingswipe.SwipeFlingAdapterView;

import java.util.ArrayList;
import java.util.List;


public abstract class GamesActivity extends AppCompatActivity {
    private ViewHolder viewHolder;

    public ViewHolder getViewHolder() {
        return viewHolder;
    }

    public void setViewHolder(ViewHolder viewHolder) {
        this.viewHolder = viewHolder;
    }
}
