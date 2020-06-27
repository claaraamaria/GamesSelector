package com.claramaria.gamesselector.activities;

import android.os.Bundle;
import android.view.View;

import com.claramaria.gamesselector.R;
import com.claramaria.gamesselector.adapters.GamesAdapter;
import com.claramaria.gamesselector.model.CardImage;
import com.claramaria.gamesselector.model.GameType;
import com.claramaria.gamesselector.utils.Constants;
import com.claramaria.gamesselector.utils.FactoryCardsInfo;
import com.lorentzos.flingswipe.SwipeFlingAdapterView;

import java.util.List;


public class InteractiveGames extends Games {

    private GamesAdapter gamesAdapter;
    private List<CardImage> dataList;
    private SwipeFlingAdapterView flingContainer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        flingContainer = findViewById(R.id.frame);

        dataList = FactoryCardsInfo.getCardsInfo(GameType.valueOfLabel("Interactive Games"));
        gamesAdapter = new GamesAdapter(dataList, InteractiveGames.this);
        flingContainer.setAdapter(gamesAdapter);
        flingContainer.setFlingListener(new SwipeFlingAdapterView.onFlingListener() {
            @Override
            public void removeFirstObjectInAdapter() {

            }

            @Override
            public void onLeftCardExit(Object dataObject) {
                dataList.remove(0);
                gamesAdapter.notifyDataSetChanged();
                //Do something on the left!
                //You also have access to the original object.
                //If you want to use it just cast it (String) dataObject
            }

            @Override
            public void onRightCardExit(Object dataObject) {
                dataList.remove(0);
                gamesAdapter.notifyDataSetChanged();

                startActivity(Constants.constructIntent(InteractiveGames.this, dataList.get(0)));
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

                gamesAdapter.notifyDataSetChanged();
            }
        });
    }
}
