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

import com.claramaria.gamesselector.R;
import com.claramaria.gamesselector.activities.BallGames;
import com.claramaria.gamesselector.activities.BoardGames;
import com.claramaria.gamesselector.activities.CardGames;
import com.claramaria.gamesselector.activities.OverAgeGames;
import com.claramaria.gamesselector.activities.InteractiveGames;
import com.claramaria.gamesselector.adapters.RecyclerViewAdapter;
import com.claramaria.gamesselector.pojos.GameInfo;

import java.util.ArrayList;

public class RecyclerViewFragment extends Fragment implements RecyclerViewAdapter.OnItemClickListener{
    private ArrayList<GameInfo> mList;

    public RecyclerViewFragment() {
        //required empty public constructor
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View mView = inflater.inflate(R.layout.fragment_list, container, false);
        RecyclerView mRecyclerView = mView.findViewById(R.id.recyclerView);
        RecyclerViewAdapter mAdapter = new RecyclerViewAdapter(getContext(), mList, this);

        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        mRecyclerView.setAdapter(mAdapter);
        return mView;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        createList();
    }

    private void createList() {
        mList = new ArrayList<>();
        mList.add(new GameInfo(R.drawable.ic_ball, "Ball Games", "For this kind of games you will only need a ball of any kind and some play mood."));
        mList.add(new GameInfo(R.drawable.ic_cards, "Board Games", "If you have a board game, but not enough players, come here to search your team."));
        mList.add(new GameInfo(R.drawable.ic_drink, "Drinking Games", "Are you 18+ and want to have some fun on a night with a some new people?"));
        mList.add(new GameInfo(R.drawable.ic_cards, "Card Games", "What can you do with a deck of cards? Maybe some new friends! "));
        mList.add(new GameInfo(R.drawable.ic_run, "Interactive Games", "If you have some imagination and no items to play some games, please come here."));

    }

    @Override
    public void onItemClick(int position) {
        Intent myIntent;
        switch (position) {
            case 0:
                myIntent = new Intent(getContext(), BallGames.class);
                startActivityForResult(myIntent, 0);
                break;
            case 1:
                myIntent = new Intent(getContext(), BoardGames.class);
                startActivityForResult(myIntent, 0);
                break;
            case 2:
                myIntent = new Intent(getContext(), OverAgeGames.class);
                startActivityForResult(myIntent, 0);
                break;
            case 3:
                myIntent = new Intent(getContext(), CardGames.class);
                startActivityForResult(myIntent, 0);
                break;
            case 4:
                myIntent = new Intent(getContext(), InteractiveGames.class);
                startActivityForResult(myIntent, 0);
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + position);
        }
    }
}