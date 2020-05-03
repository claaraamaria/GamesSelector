package com.claramaria.gamesselector;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.claramaria.gamesselector.activities.ListBallGames;
import com.claramaria.gamesselector.activities.ListBoardGames;
import com.claramaria.gamesselector.activities.ListCardGames;
import com.claramaria.gamesselector.activities.ListDrinkingGames;
import com.claramaria.gamesselector.activities.ListInteractiveGames;


public class MainActivity extends AppCompatActivity {
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listview_item_click_event);

        listView = findViewById(R.id.list);
        String[] values = new String[]{
                "Ball Games",
                "Board Games",
                "Drinking Games",
                "Card Games",
                "Interactive Games",
        };

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, android.R.id.text1, values);

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                Intent myIntent;
                switch (position) {
                    case 0:
                        myIntent = new Intent(view.getContext(), ListBallGames.class);
                        startActivityForResult(myIntent, 0);
                        break;
                    case 1:
                        myIntent = new Intent(view.getContext(), ListBoardGames.class);
                        startActivityForResult(myIntent, 0);
                        break;
                    case 2:
                        myIntent = new Intent(view.getContext(), ListDrinkingGames.class);
                        startActivityForResult(myIntent, 0);
                        break;
                    case 3:
                        myIntent = new Intent(view.getContext(), ListCardGames.class);
                        startActivityForResult(myIntent, 0);
                        break;
                    case 4:
                        myIntent = new Intent(view.getContext(), ListInteractiveGames.class);
                        startActivityForResult(myIntent, 0);
                        break;
                }
            }
        });
    }
}