package com.claramaria.gamesselector.fragments;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.claramaria.gamesselector.R;
import com.claramaria.gamesselector.model.User;
import com.claramaria.gamesselector.server.RESTClient;
import com.claramaria.gamesselector.storage.SharedPrefManager;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginFragment extends Fragment {

    private EditText etUsername;
    private EditText etPassword;
    private CallbackFragment callbackFragment;
    private String userName;
    private String pass;
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;

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

     /*   Call<User> call = RESTClient
                .getInstance()
                .getApi()
                .loginUser(userName, pass);

        call.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {

                if (!loginResponse.isError()) {
                    SharedPrefManager.getInstance(getContext())
                            .saveUser(loginResponse.getUser());
                    //open the new activity
                    Intent intent = new Intent(getContext(), ProfileFragment.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);

                    startActivity(intent);
                    //Toast.makeText(getContext(), "Login Successful!", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getContext(), "Invalid credentials!", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {

            }
        });*/

        String uName;
        String uPass;
        uName = sharedPreferences.getString("username", null);
        uPass = sharedPreferences.getString("pass", null);

        if (userName.equals(uName) && pass.equals(uPass)) {
            Toast.makeText(getContext(), "Login", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(getContext(), "Error", Toast.LENGTH_SHORT).show();
        }
    }

    public void setCallbackFragment(CallbackFragment callbackFragment) {
        this.callbackFragment = callbackFragment;
    }
}
