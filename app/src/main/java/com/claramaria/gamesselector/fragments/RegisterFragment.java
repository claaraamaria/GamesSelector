package com.claramaria.gamesselector.fragments;

import android.content.Context;
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
import com.claramaria.gamesselector.server.RESTClient;

import java.io.IOException;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegisterFragment extends Fragment {

    private EditText etUsername;
    private EditText etPassword;
    private String userName;
    private String pass;

    @Override
    public void onAttach(@NonNull Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("userFile", Context.MODE_PRIVATE);
        super.onAttach(context);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_register, container, false);
        etUsername = view.findViewById(R.id.etUsername);
        etPassword = view.findViewById(R.id.etPassword);

        Button registerBtn = view.findViewById(R.id.btnRegister);


        registerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userName = etUsername.getText().toString();
                pass = etPassword.getText().toString();

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

                /*if (pass.length() < 6) {
                    etPassword.setError("Password should be at least 6 characters long");
                    etPassword.requestFocus();
                    return;
                }*/

                /* User registration using api call */

                Call<ResponseBody> call = RESTClient
                        .getInstance()
                        .getApi()
                        .createUser(userName, pass);

                call.enqueue(new Callback<ResponseBody>() {
                    @Override
                    public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                        try {
                            String resp = response.body().string();
                            Toast.makeText(getContext(), resp, Toast.LENGTH_SHORT).show();
                        } catch (IOException e) {
                            Toast.makeText(getContext(), e.getMessage(), Toast.LENGTH_SHORT).show();
                        }

                    }

                    @Override
                    public void onFailure(Call<ResponseBody> call, Throwable e) {
                        Toast.makeText(getContext(), e.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });

            }
        });

        return view;
    }
}
