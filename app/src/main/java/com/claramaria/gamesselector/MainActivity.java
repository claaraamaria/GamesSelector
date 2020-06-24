package com.claramaria.gamesselector;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import com.claramaria.gamesselector.fragments.CallbackFragment;
import com.claramaria.gamesselector.fragments.FriendsFragment;
import com.claramaria.gamesselector.fragments.LoginFragment;
import com.claramaria.gamesselector.fragments.ChatListFragment;
import com.claramaria.gamesselector.activities.MapsActivity;
import com.claramaria.gamesselector.fragments.ProfileFragment;
import com.claramaria.gamesselector.fragments.RecyclerViewFragment;
import com.claramaria.gamesselector.fragments.RegisterFragment;
import com.claramaria.gamesselector.storage.SharedPrefManager;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity implements CallbackFragment {
    private DrawerLayout drawer;
    Fragment fragment;
    FragmentManager fragmentManager;
    FragmentTransaction fragmentTransaction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listview_item);

       // addFragment();

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        drawer = findViewById(R.id.drawer_list);

        NavigationView navigationView = findViewById(R.id.nav_view);

        navigationView.setNavigationItemSelectedListener(item -> {
            switch (item.getItemId()) {
                case R.id.nav_list:
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new RecyclerViewFragment()).addToBackStack(null).commit();
                    break;
                case R.id.nav_message:
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new ChatListFragment()).addToBackStack(null).commit();
                    break;
                case R.id.nav_chat:
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new FriendsFragment()).addToBackStack(null).commit();
                    break;
                case R.id.nav_profile:
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new ProfileFragment()).addToBackStack(null).commit();
                    break;
                case R.id.nav_maps:
                    Intent myIntent;
                    myIntent = new Intent(this, MapsActivity.class);
                    startActivityForResult(myIntent, 0);
                    break;
                default:
                    throw new IllegalStateException("IllegalStateException" + item.getItemId());
            }
            drawer.closeDrawer(GravityCompat.START);
            return true;
        });

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar,
                R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new ProfileFragment()).addToBackStack(null).commit();
            navigationView.setCheckedItem(R.id.nav_profile);
        }
    }

    @Override
    public void onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

   /* @Override
    protected void onStart() {
        super.onStart();
        if(SharedPrefManager.getInstance(this).isLoggedIn()){
            Intent intent = new Intent(this, RecyclerViewFragment.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(intent);
        }
    }*/

    public void addFragment() {
        LoginFragment loginFragment = new LoginFragment();
        loginFragment.setCallbackFragment(this);

        fragmentManager = getSupportFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.fragment_container, loginFragment).addToBackStack(null).commit();
    }

    public void replaceFragment() {
        fragment = new RegisterFragment();
        fragmentManager = getSupportFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.replace(R.id.fragment_container, fragment).addToBackStack(null).commit();
    }

    @Override
    public void changeFragment() {
        replaceFragment();
    }
}