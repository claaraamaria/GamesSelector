package com.claramaria.gamesselector.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.RecyclerView;

import com.claramaria.gamesselector.R;
import com.claramaria.gamesselector.model.User;
import com.claramaria.gamesselector.storage.SharedPrefManager;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.squareup.picasso.Picasso;

import java.util.HashMap;

public class ChatActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    ImageView profileAvatar;
    TextView username;
    TextView name;
    EditText messageEt;
    ImageButton sendBtn;
    String senderUsername;
    String receiverUsername;

    FirebaseAuth firebaseAuth;

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Object userId = data.getExtras().get("userId");
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        recyclerView = findViewById(R.id.chat_recycler_view);
        profileAvatar = findViewById(R.id.profileAvatar);
        username = findViewById(R.id.chat_username);
        name = findViewById(R.id.chat_name);
        messageEt = findViewById(R.id.messageEt);
        sendBtn = findViewById(R.id.send_btn);

        SharedPrefManager preferences = SharedPrefManager.getInstance(ChatActivity.this);
        if (preferences != null) {
            User user = preferences.getTargetUser();
            username.setText(user.getUserName());
            name.setText(user.getName());

            receiverUsername = user.getUserName();
            senderUsername = preferences.getOwner().getUserName();

            try{
                Picasso.get().load(user.getImageUrl()).into(profileAvatar);
            } catch (Exception e){
                Picasso.get().load(R.drawable.ic_add_image).into(profileAvatar);
            }
        } else {
            Toast.makeText(ChatActivity.this, "Unable to obtain user", Toast.LENGTH_SHORT).show();
        }

        firebaseAuth = FirebaseAuth.getInstance();

        sendBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String messageText = messageEt.getText().toString();
                if(!"".equals(messageText)){
                    sendMessage(messageText);
                }
                else{
                    Toast.makeText(ChatActivity.this, "Cannot send an empty message", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void sendMessage(String message) {

        DatabaseReference reference = FirebaseDatabase.getInstance().getReference();

        HashMap<String, Object> chatMessage = new HashMap<>();
        chatMessage.put("sender", senderUsername);
        chatMessage.put("receiver", receiverUsername);
        chatMessage.put("message", message);

        reference.child("Chats").push().setValue(chatMessage);

        messageEt.setText("");
    }

}
