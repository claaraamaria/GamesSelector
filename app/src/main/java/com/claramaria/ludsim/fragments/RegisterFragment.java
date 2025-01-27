package com.claramaria.ludsim.fragments;

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

import com.claramaria.ludsim.R;
import com.claramaria.ludsim.model.User;
import com.claramaria.ludsim.server.RESTClient;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegisterFragment extends Fragment {

    private EditText etName;
    private EditText etEmail;
    private EditText etPhone;
    private EditText etUsername;
    private EditText etPassword;
    private String name;
    private String email;
    private String telephone;
    private String userName;
    private String password;

    public RegisterFragment() {
        // Required empty public constructor
    }

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
        etEmail = view.findViewById(R.id.etEmail);
        etName = view.findViewById(R.id.etName);
        etPhone = view.findViewById(R.id.etPhone);

        Button registerBtn = view.findViewById(R.id.btnRegister);


        registerBtn.setOnClickListener(v -> userRegister());

        return view;
    }


    private void userRegister() {
        name = etName.getText().toString().trim();
        email = etEmail.getText().toString().trim();
        telephone = etPhone.getText().toString().trim();
        userName = etUsername.getText().toString().trim();
        password = etPassword.getText().toString().trim();

        if (userName.isEmpty()) {
            etUsername.setError("Username is required!");
            etUsername.requestFocus();
            return;
        }

        if (password.isEmpty()) {
            etPassword.setError("Password required");
            etPassword.requestFocus();
            return;
        }

        if (password.length() < 8) {
            etPassword.setError("Password should be at least 8 characters long");
                    etPassword.requestFocus();
                    return;
        }

        /* User registration using api call */
        User user = new User();
        user.setUserId(0); user.setUserName(userName); user.setName(name); user.setTelephone(telephone); user.setEmail(email); user.setImageUrl(null); user.setPassword(password);
        Call<ResponseBody> call = RESTClient
                .getInstance()
                .getApi()
                .createUser(user);

        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                if (response.isSuccessful())
                    Toast.makeText(getContext(), "User created", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable e) {
                Toast.makeText(getContext(), e.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
