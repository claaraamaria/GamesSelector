package com.claramaria.ludsim.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.claramaria.ludsim.R;
import com.claramaria.ludsim.utils.Constants;


public class RoomActivity extends AppCompatActivity {

    ImageView activityPic;
    TextView activityDesc;
    Button setLocationBtn;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.room_activity);

        activityPic = findViewById(R.id.activity_pic);
        activityDesc = findViewById(R.id.activity_descr);
        setLocationBtn = findViewById(R.id.maps_btn);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("LudSim");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        activityPic.setImageResource(getIntent().getExtras().getInt(Constants.IMAGE_INDEX));
        activityDesc.setText(getIntent().getExtras().getString(Constants.DESCRIPTION));

        setLocationBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent;
                myIntent = new Intent(RoomActivity.this, MapsActivity.class);
                startActivityForResult(myIntent, 0);
            }
        });
    }

}
