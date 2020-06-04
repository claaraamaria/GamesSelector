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

public class LoginFragment extends Fragment {

    private EditText etUsername;
    private EditText etPassword;
    private CallbackFragment callbackFragment;
    private String username;
    private String pass;
    private SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;

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
                username = etUsername.getText().toString();
                pass = etPassword.getText().toString();

                if(username.isEmpty()){
                    etUsername.setError("Username is required!");
                    etUsername.requestFocus();
                    return;
                }


                String uName;
                String uPass;
                uName = sharedPreferences.getString("username", null);
                uPass = sharedPreferences.getString("pass", null);

                if (username.equals(uName) && pass.equals(uPass)) {
                    Toast.makeText(getContext(), "Login", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getContext(), "Error", Toast.LENGTH_SHORT).show();
                }
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

    public void setCallbackFragment(CallbackFragment callbackFragment) {
        this.callbackFragment = callbackFragment;
    }
}
