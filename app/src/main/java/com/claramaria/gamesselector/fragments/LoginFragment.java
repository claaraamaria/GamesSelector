package com.claramaria.gamesselector.fragments;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.claramaria.gamesselector.R;
import com.claramaria.gamesselector.model.User;
import com.claramaria.gamesselector.server.RESTClient;
import com.claramaria.gamesselector.storage.SharedPrefManager;
import com.google.android.gms.common.util.CollectionUtils;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginFragment extends Fragment implements CallbackFragment {
    private static final String TAG = "LoginFragment";
    private EditText etUsername;
    private EditText etPassword;
    private CallbackFragment callbackFragment;
    private FragmentManager fragmentManager;
    private FragmentTransaction fragmentTransaction;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_login, container, false);
        etUsername = view.findViewById(R.id.etUsername);
        etPassword = view.findViewById(R.id.etPassword);

        Button loginBtn = view.findViewById(R.id.btnLogin);
        Button registerBtn = view.findViewById(R.id.btnRegister);

        loginBtn.setOnClickListener(v -> userLogin());

        registerBtn.setOnClickListener(v -> {
            if (callbackFragment != null) {
                callbackFragment.changeFragment();
            }
        });

        return view;
    }

    @Override
    public void onStart() {
        super.onStart();

        if (SharedPrefManager.getInstance(getContext()).isLoggedIn()) {
            ProfileFragment profileFragment = new ProfileFragment();

            fragmentManager = getFragmentManager();
            fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.add(R.id.fragment_container, profileFragment).addToBackStack(null).commit();
        }
    }

    private void userLogin() {
        String userName = etUsername.getText().toString().trim();
        String pass = etPassword.getText().toString().trim();

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
                    SharedPrefManager sharedPrefManager = SharedPrefManager.getInstance(getContext());
                    sharedPrefManager.saveUser(users.get(0));

                    ProfileFragment profileFragment = new ProfileFragment();
                    profileFragment.setCallbackFragment(this);

                    fragmentManager = getFragmentManager();
                    fragmentTransaction = fragmentManager.beginTransaction();
                    fragmentTransaction.add(R.id.fragment_container, new RecyclerViewFragment()).addToBackStack(null).commit();
                    final InputMethodManager imm = (InputMethodManager) getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
                    imm.hideSoftInputFromWindow(getView().getWindowToken(), 0);
                    Toast.makeText(getContext(), "Login Successful!", Toast.LENGTH_SHORT).show();

                } else {
                    Toast.makeText(getContext(), "Invalid credentials!", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<List<User>> call, Throwable e) {
                Toast.makeText(getContext(), e.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void setCallbackFragment(CallbackFragment callbackFragment) {
        this.callbackFragment = callbackFragment;
    }

    @Override
    public void changeFragment() {
        Fragment fragment = new RegisterFragment();
        fragmentManager = getFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.replace(R.id.fragment_container, fragment).commit();
    }
}
