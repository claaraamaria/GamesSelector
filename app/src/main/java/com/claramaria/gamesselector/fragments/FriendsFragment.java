package com.claramaria.gamesselector.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.claramaria.gamesselector.R;
import com.claramaria.gamesselector.activities.ChatActivity;
import com.claramaria.gamesselector.adapters.AdapterUsers;
import com.claramaria.gamesselector.model.User;
import com.claramaria.gamesselector.server.RESTClient;
import com.claramaria.gamesselector.storage.SharedPrefManager;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FriendsFragment extends Fragment {

    private RecyclerView recyclerView;
    private AdapterUsers adapter;
    private List<User> userList;

    public FriendsFragment() {
        //required empty public constructor
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_users_list, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        recyclerView = view.findViewById(R.id.users_recyclerView);

        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        Call<List<User>> call = RESTClient
                .getInstance()
                .getApi()
                .getUsers();

        call.enqueue(new Callback<List<User>>() {
            @Override
            public void onResponse(Call<List<User>> call, Response<List<User>> response) {
                userList = response.body();
                SharedPrefManager preferences = SharedPrefManager.getInstance(getContext());
                if (preferences != null) {
                    User owner = preferences.getOwner();
                    userList.remove(owner);
                }else {
                    Toast.makeText(getContext(), "Unable to obtain userFriends", Toast.LENGTH_SHORT).show();
                }

                adapter = new AdapterUsers(getActivity(), userList);
                recyclerView.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<List<User>> call, Throwable e) {
                Toast.makeText(getContext(), e.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
