package com.claramaria.gamesselector;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.claramaria.gamesselector.activities.ListBallGames;
import com.claramaria.gamesselector.activities.ListBoardGames;
import com.claramaria.gamesselector.activities.ListCardGames;
import com.claramaria.gamesselector.activities.ListDrinkingGames;
import com.claramaria.gamesselector.activities.ListInteractiveGames;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {
    private ArrayList<ListItemData> mList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listview_item);

        createList();
        buildRecyclerView();

    }


    public void createList() {
        mList = new ArrayList<>();
        mList.add(new ListItemData(R.drawable.ic_android, "Ball Games", "For this kind of games you will only need a ball"));
        mList.add(new ListItemData(R.drawable.board_game, "Board Games", "If you have a board game, but not enough players, come here"));
        mList.add(new ListItemData(R.drawable.drinking_games, "Drinking Games", "Are you 18+ and want to have some fun on a night?"));
        mList.add(new ListItemData(R.drawable.deck_of_cards, "Card Games", "Some old fashion card games, but maybe you haven't heard of some of them. Wanna check them out?"));
        mList.add(new ListItemData(R.drawable.hide_and_seek, "Interactive Games", "If you have some imagination an no items to play some games, please come here."));

    }

    public void buildRecyclerView() {
        RecyclerView mRecyclerView = findViewById(R.id.recyclerView);
        mRecyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(this);
        ListAdapter mAdapter = new ListAdapter(mList);

        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapter);

        mAdapter.setOnItemClickListener(new ListAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                Intent myIntent;
                switch (position) {
                    case 0:
                        myIntent = new Intent(MainActivity.this, ListBallGames.class);
                        startActivityForResult(myIntent, 0);
                        break;
                    case 1:
                        myIntent = new Intent(MainActivity.this, ListBoardGames.class);
                        startActivityForResult(myIntent, 0);
                        break;
                    case 2:
                        myIntent = new Intent(MainActivity.this, ListDrinkingGames.class);
                        startActivityForResult(myIntent, 0);
                        break;
                    case 3:
                        myIntent = new Intent(MainActivity.this, ListCardGames.class);
                        startActivityForResult(myIntent, 0);
                        break;
                    case 4:
                        myIntent = new Intent(MainActivity.this, ListInteractiveGames.class);
                        startActivityForResult(myIntent, 0);
                        break;
                }
            }
        });
    }
}