package com.claramaria.ludsim.fragments;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.claramaria.ludsim.R;
import com.claramaria.ludsim.model.User;
import com.claramaria.ludsim.storage.SharedPrefManager;
import com.squareup.picasso.Picasso;

import java.util.List;

import retrofit2.Callback;

public class ProfileFragment extends Fragment {

    private Context mContext;
    private CallbackFragment callbackFragment;

    public ProfileFragment() {
        //required empty public constructor
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_profile, container, false);

        TextView profileName = view.findViewById(R.id.profName);
        TextView profileUsername = view.findViewById(R.id.profUsername);
        TextView profileEmail = view.findViewById(R.id.profEmail);
        ImageView profileAvatar = view.findViewById(R.id.avatar);

        SharedPrefManager preferences = SharedPrefManager.getInstance(getContext());
        if (preferences != null) {
            User user = preferences.getOwner();
            profileName.setText(user.getName());
            profileUsername.setText(user.getUserName());
            profileEmail.setText(user.getEmail());

            try{
                Picasso.get().load(user.getImageUrl()).into(profileAvatar);
            } catch (Exception e){
                Picasso.get().load(R.drawable.ic_add_image).into(profileAvatar);
            }
        } else {
            Toast.makeText(getContext(), "Unable to obtain user", Toast.LENGTH_SHORT).show();
        }
        return view;
    }

    void setCallbackFragment(Callback<List<User>> listCallback) {
        this.callbackFragment = callbackFragment;
    }
}