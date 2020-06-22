package com.claramaria.gamesselector.fragments;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.claramaria.gamesselector.MainActivity;
import com.claramaria.gamesselector.R;
import com.claramaria.gamesselector.model.User;
import com.claramaria.gamesselector.server.RESTClient;
import com.claramaria.gamesselector.storage.SharedPrefManager;
import com.google.android.gms.common.util.CollectionUtils;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.logging.Logger;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginFragment extends Fragment implements CallbackFragment {
    private EditText etUsername;
    private EditText etPassword;
    private CallbackFragment callbackFragment;
    private String userName;
    private String pass;
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;
    FragmentManager fragmentManager;
    Fragment fragment;
    FragmentTransaction fragmentTransaction;

    @Override
    public void onAttach(@NonNull Context context) {
        sharedPreferences = context.getSharedPreferences("userFile", Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
        super.onAttach(context);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_login, container, false);
        etUsername = view.findViewById(R.id.etUsername);
        etPassword = view.findViewById(R.id.etPassword);

        Button loginBtn = view.findViewById(R.id.btnLogin);
        Button registerBtn = view.findViewById(R.id.btnRegister);

        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userLogin();
            }
        });

        registerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (callbackFragment != null) {
                    callbackFragment.changeFragment();
                }
            }
        });

        return view;
    }


    private void userLogin() {
        userName = etUsername.getText().toString().trim();
        pass = etPassword.getText().toString().trim();

        if (userName.isEmpty()) {
            etUsername.setError("Username is required!");
            etUsername.requestFocus();
            return;
        }

        if (pass.isEmpty()) {
            etPassword.setError("Password required");
            etPassword.requestFocus();
            return;
        }

        Call<List<User>> call = RESTClient
                .getInstance()
                .getApi()
                .loginUser(userName, pass);

        call.enqueue(new Callback<List<User>>() {
            @Override
            public void onResponse(Call<List<User>> call, Response<List<User>> usersResponse) {
                List<User> users = usersResponse.body();
                if(!CollectionUtils.isEmpty(users)){
                    //open the new fragment
                    ProfileFragment profileFragment = new ProfileFragment();
                    profileFragment.setCallbackFragment(this);

                    fragmentManager = getFragmentManager();
                    fragmentTransaction = fragmentManager.beginTransaction();
                    fragmentTransaction.add(R.id.fragment_container, profileFragment).addToBackStack(null).commit();
                    Toast.makeText(getContext(), "Login Successful!", Toast.LENGTH_SHORT).show();

                } else {
                    Toast.makeText(getContext(), "Invalid credentials!", Toast.LENGTH_SHORT).show();
                }
                /*if (!loginResponse.isError()) {

                    Intent intent = new Intent(getContext(), ProfileFragment.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    SharedPrefManager.getInstance(getContext())
                            .saveUser(User.getUserId());

                    startActivity(intent);
                    //Toast.makeText(getContext(), "Login Successful!", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getContext(), "Invalid credentials!", Toast.LENGTH_SHORT).show();
                }*/
            }

            @Override
            public void onFailure(Call<List<User>> call, Throwable e) {
                Toast.makeText(getContext(), e.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

        String uName;
        String uPass;
        uName = sharedPreferences.getString("username", null);
        uPass = sharedPreferences.getString("pass", null);

       /* if (userName.equals(uName) && pass.equals(uPass)) {
            Toast.makeText(getContext(), "Login", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(getContext(), "Error", Toast.LENGTH_SHORT).show();
        }*/
    }

    public void setCallbackFragment(CallbackFragment callbackFragment) {
        this.callbackFragment = callbackFragment;
    }

    private void replaceFragment() {
        fragment = new RegisterFragment();
        fragmentManager = getFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.replace(R.id.fragment_container, fragment).commit();
    }

    @Override
    public void changeFragment() {
        replaceFragment();
    }
}
