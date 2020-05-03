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

    public static GamesAdapter gamesAdapter;

    private static ViewHolder viewHolder; //TODO: memory leak

    public void setImages(List<Data> images) {
        this.images = images;
    }
    private List<Data> images;
    private SwipeFlingAdapterView flingContainer;
    public GamesActivity() {
    }

    public static ViewHolder getViewHolder() {
        return viewHolder;
    }

    public static void setViewHolder(ViewHolder viewHolder1) {
        viewHolder = viewHolder1;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        flingContainer = findViewById(R.id.frame);

        setImages(FactoryCardsInfo.getCardsInfo("ListBoardGames"));

        images = new ArrayList<>();
        images.add(new Data("board_game","For this kind of games, a link with the complete rules will be listed."));

        images.add(new Data("Football (Soccer)", "Catan\n" ));

        images.add(new Data("board_game", "Dixit \n"));

        images.add(new Data("drinking_games", "Cards against humanity \n"));

        gamesAdapter = new GamesAdapter(images, GamesActivity.this);
        flingContainer.setAdapter(gamesAdapter);
        flingContainer.setFlingListener(new SwipeFlingAdapterView.onFlingListener() {
            @Override
            public void removeFirstObjectInAdapter() {

            }

            @Override
            public void onLeftCardExit(Object dataObject) {
                images.remove(0);
                gamesAdapter.notifyDataSetChanged();
                //Do something on the left!
                //You also have access to the original object.
                //If you want to use it just cast it (String) dataObject
            }

            @Override
            public void onRightCardExit(Object dataObject) {

                images.remove(0);
                gamesAdapter.notifyDataSetChanged();
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
