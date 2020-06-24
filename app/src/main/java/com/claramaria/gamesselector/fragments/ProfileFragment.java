package com.claramaria.gamesselector.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.claramaria.gamesselector.R;
import com.claramaria.gamesselector.model.User;
import com.claramaria.gamesselector.storage.SharedPrefManager;

import java.util.List;

import retrofit2.Callback;

public class ProfileFragment extends Fragment {

    private CallbackFragment callbackFragment;

    public ProfileFragment() {
        //required empty public constructor
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_profile, container, false);

        TextView profileUsername = view.findViewById(R.id.profUsername);
        TextView profileName = view.findViewById(R.id.profName);
        TextView profileEmail = view.findViewById(R.id.profEmail);

        User user = SharedPrefManager.getInstance(null).getUser();
        profileUsername.setText(user.getUserName());
        profileName.setText(user.getName());
        profileEmail.setText(user.getEmail());

        return view;
    }

    void setCallbackFragment(Callback<List<User>> listCallback) {
        this.callbackFragment = callbackFragment;
    }
}