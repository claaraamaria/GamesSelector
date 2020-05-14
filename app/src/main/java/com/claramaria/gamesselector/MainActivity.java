package com.claramaria.gamesselector;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.claramaria.gamesselector.activities.ListBallGames;
import com.claramaria.gamesselector.activities.ListBoardGames;
import com.claramaria.gamesselector.activities.ListCardGames;
import com.claramaria.gamesselector.activities.ListDrinkingGames;
import com.claramaria.gamesselector.activities.ListInteractiveGames;
import com.claramaria.gamesselector.fragments.ChatFragment;
import com.claramaria.gamesselector.fragments.MessageFragment;
import com.claramaria.gamesselector.fragments.ProfileFragement;
import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private DrawerLayout drawer;
    private ArrayList<ListItemData> mList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listview_item);

        createList();
        buildRecyclerView();

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        drawer = findViewById(R.id.drawer_list);

        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.nav_message:
                        getSupportFragmentManager().beginTransaction().add(R.id.fragment_container, new MessageFragment()).commit();
                        break;
                    case R.id.nav_chat:
                        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new ChatFragment()).commit();
                        break;
                    case R.id.nav_profile:
                        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new ProfileFragement()).commit();
                        break;
                    case R.id.nav_share:
                        Toast.makeText(MainActivity.this, "Share", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.nav_send:
                        Toast.makeText(MainActivity.this, "Send", Toast.LENGTH_SHORT).show();
                        break;
                }
                drawer.closeDrawer(GravityCompat.START);
                return true;
            }
        });

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar,
                R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new MessageFragment()).commit();
            navigationView.setCheckedItem(R.id.nav_message);
        }
    }

    @Override
    public void onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    public void createList() {
        mList = new ArrayList<>();
        mList.add(new ListItemData(R.drawable.ic_ball, "Ball Games", "For this kind of games you will only need a ball of any kind and some play mood."));
        mList.add(new ListItemData(R.drawable.ic_cards, "Board Games", "If you have a board game, but not enough players, come here to search your team."));
        mList.add(new ListItemData(R.drawable.ic_drink, "Drinking Games", "Are you 18+ and want to have some fun on a night with a some new people?"));
        mList.add(new ListItemData(R.drawable.ic_cards, "Card Games", "What can you do with a deck of cards? Maybe some new friends! "));
        mList.add(new ListItemData(R.drawable.ic_run, "Interactive Games", "If you have some imagination and no items to play some games, please come here."));

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