package com.claramaria.ludsim.activities;

import android.os.Bundle;
import android.view.View;

import com.claramaria.ludsim.R;
import com.claramaria.ludsim.adapters.AdapterGames;
import com.claramaria.ludsim.model.CardImage;
import com.claramaria.ludsim.model.GameType;
import com.claramaria.ludsim.utils.Constants;
import com.claramaria.ludsim.utils.FactoryCardsInfo;
import com.lorentzos.flingswipe.SwipeFlingAdapterView;

import java.util.List;

public class BallGames extends Games {

    private AdapterGames adapterGames;
    private List<CardImage> dataList;
    private SwipeFlingAdapterView flingContainer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        flingContainer = findViewById(R.id.frame);

        dataList = FactoryCardsInfo.getCardsInfo(GameType.valueOfLabel("Ball Games"));
        adapterGames = new AdapterGames(dataList, BallGames.this);
        flingContainer.setAdapter(adapterGames);
        flingContainer.setFlingListener(new SwipeFlingAdapterView.onFlingListener() {
            @Override
            public void removeFirstObjectInAdapter() {
                //required empty public constructor
            }

            @Override
            public void onLeftCardExit(Object dataObject) {
                dataList.remove(0);
                adapterGames.notifyDataSetChanged();
                //Do something on the left!
                //You also have access to the original object.
                //If you want to use it just cast it (String) dataObject
            }

            @Override
            public void onRightCardExit(Object dataObject) {
                dataList.remove(0);
                adapterGames.notifyDataSetChanged();

                startActivity(Constants.constructIntent(BallGames.this, dataList.get(0)));
            }

            @Override
            public void onAdapterAboutToEmpty(int itemsInAdapter) {

            }

            @Override
            public void onScroll(float scrollProgressPercent) {

                View view = flingContainer.getSelectedView();
                view.findViewById(R.id.background).setAlpha(0);
                view.findViewById(R.id.item_swipe_right_indicator).setAlpha(scrollProgressPercent < 0 ? -scrollProgressPercent : 0);
                view.findViewById(R.id.item_swipe_left_indicator).setAlpha(scrollProgressPercent > 0 ? scrollProgressPercent : 0);
            }
        });


        // Optionally add an OnItemClickListener
        flingContainer.setOnItemClickListener(new SwipeFlingAdapterView.OnItemClickListener() {
            @Override
            public void onItemClicked(int itemPosition, Object dataObject) {

                View view = flingContainer.getSelectedView();
                view.findViewById(R.id.background).setAlpha(0);

                adapterGames.notifyDataSetChanged();
            }
        });
    }
}
