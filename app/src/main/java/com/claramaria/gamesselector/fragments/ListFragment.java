package com.claramaria.gamesselector.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.claramaria.gamesselector.ListAdapter;
import com.claramaria.gamesselector.ListItemData;
import com.claramaria.gamesselector.MainActivity;
import com.claramaria.gamesselector.R;
import com.claramaria.gamesselector.activities.ListBallGames;
import com.claramaria.gamesselector.activities.ListBoardGames;
import com.claramaria.gamesselector.activities.ListCardGames;
import com.claramaria.gamesselector.activities.ListDrinkingGames;
import com.claramaria.gamesselector.activities.ListInteractiveGames;

import java.util.ArrayList;

public class ListFragment extends Fragment {
    private View mView;
    private ArrayList<ListItemData> mList;

    public ListFragment(){

    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mView = inflater.inflate(R.layout.fragment_list, container, false);
        RecyclerView mRecyclerView = mView.findViewById(R.id.recyclerView);
        ListAdapter mAdapter = new ListAdapter(getContext(), mList);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        mRecyclerView.setAdapter(mAdapter);
        return mView;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        createList();
       // addListener();
    }

//    private void addListener() {
//        RecyclerView mRecyclerView = mView.findViewById(R.id.recyclerView);
//        ListAdapter mAdapter = new ListAdapter(getContext(), mList);
//        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
//        mRecyclerView.setAdapter(mAdapter);
//        mAdapter.setOnItemClickListener(new ListAdapter.OnItemClickListener() {
//            @Override
//            public void onItemClick(int position) {
//                Intent myIntent;
//                switch (position) {
//                    case 0:
//                        myIntent = new Intent(MainActivity.this, ListBallGames.class);
//                        startActivityForResult(myIntent, 0);
//                        break;
//                    case 1:
//                        myIntent = new Intent(MainActivity.this, ListBoardGames.class);
//                        startActivityForResult(myIntent, 0);
//                        break;
//                    case 2:
//                        myIntent = new Intent(MainActivity.this, ListDrinkingGames.class);
//                        startActivityForResult(myIntent, 0);
//                        break;
//                    case 3:
//                        myIntent = new Intent(MainActivity.this, ListCardGames.class);
//                        startActivityForResult(myIntent, 0);
//                        break;
//                    case 4:
//                        myIntent = new Intent(MainActivity.this, ListInteractiveGames.class);
//                        startActivityForResult(myIntent, 0);
//                        break;
//                }
//            }
//        });
//    }

    private void createList() {
        mList = new ArrayList<>();
        mList.add(new ListItemData(R.drawable.ic_ball, "Ball Games", "For this kind of games you will only need a ball of any kind and some play mood."));
        mList.add(new ListItemData(R.drawable.ic_cards, "Board Games", "If you have a board game, but not enough players, come here to search your team."));
        mList.add(new ListItemData(R.drawable.ic_drink, "Drinking Games", "Are you 18+ and want to have some fun on a night with a some new people?"));
        mList.add(new ListItemData(R.drawable.ic_cards, "Card Games", "What can you do with a deck of cards? Maybe some new friends! "));
        mList.add(new ListItemData(R.drawable.ic_run, "Interactive Games", "If you have some imagination and no items to play some games, please come here."));

    }
}