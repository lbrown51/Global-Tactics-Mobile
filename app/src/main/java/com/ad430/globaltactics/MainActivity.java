package com.ad430.globaltactics;

import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import android.os.Bundle;
import android.util.Log;

import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    final String TAG = "MAIN ACTIVITY";

    private final FirebaseAuth auth;

    public MainActivity() {
        auth = FirebaseAuth.getInstance();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        signIn();

        setContentView(R.layout.activity_main);

        setupNavigation();
    }

    private void signIn() {
        auth.signInAnonymously()
                .addOnCompleteListener(task -> {
                    if (task.isSuccessful()) {
                        // Sign in success, update UI with the signed-in user's information
                        Log.d(TAG, "signInAnonymously:success");
                    } else {
                        // If sign in fails, display a message to the user.
                        Log.w(TAG, "signInAnonymously:failure", task.getException());
                    }
                });
    }

    private void setupNavigation() {
        // Get navigation host that links to the nav graph
        NavHostFragment navHostFragment = (NavHostFragment) getSupportFragmentManager()
                .findFragmentById(R.id.nav_host_fragment);
        assert navHostFragment != null;
        // Get the nav controller of that fragment
        NavController navController = navHostFragment.getNavController();


        // Get the drawer that holds the rest of the main activity
        DrawerLayout drawerLayout = findViewById(R.id.drawer_layout);
        // Get the view that contains the menu
        NavigationView navView = findViewById(R.id.navigation_view);
        // Get the material io toolbar that contains the app title
        MaterialToolbar materialToolbar = findViewById(R.id.topAppBar);

        // All the different fragments
        HashSet<Integer> fragmentIds = new HashSet<Integer>(
            Arrays.asList(
                R.id.homeScreenFragment,
                R.id.aboutUsFragment,
                R.id.ourExpertsFragment,
                R.id.ourSuccessesFragment,
                R.id.blogFragment,
                R.id.eventsFragment,
                R.id.privacyPolicyFragment,
                R.id.contactFragment
            ));

        // The different fragments that will show up in the app bar
        AppBarConfiguration appBarConfiguration =
            new AppBarConfiguration.Builder(fragmentIds)
                .setOpenableLayout(drawerLayout)
                .build();

        // Link the nav controller and the menu of navigation items
        NavigationUI.setupWithNavController(navView, navController);
        // Link the material io toolbar, the navigation controller, and the app bar
        NavigationUI.setupWithNavController(materialToolbar, navController, appBarConfiguration);
    }
}