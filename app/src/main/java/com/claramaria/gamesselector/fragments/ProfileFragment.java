package com.claramaria.gamesselector.fragments;

import android.content.Intent;
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

public class ProfileFragment extends Fragment {

    private TextView profileName, profileEmail, profilePhone;

    public ProfileFragment() {

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_profile, container, false);

        profileName = view.findViewById(R.id.profName);
        profileEmail = view.findViewById(R.id.profEmail);
        profilePhone = view.findViewById(R.id.profPhone);

        //TODO: get from the server


        User user = SharedPrefManager.getInstance(getContext()).getUser();
        profileName.setText(user.getName());
        profileEmail.setText(user.getEmail());
        profilePhone.setText(user.getTelephone());

        return view;
    }
}
