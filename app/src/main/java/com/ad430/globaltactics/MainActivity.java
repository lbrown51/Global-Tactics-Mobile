package com.ad430.globaltactics;

import androidx.appcompat.app.AppCompatActivity;
import androidx.customview.widget.Openable;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.navigation.NavigationView;

import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.HashSet;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setupNavigation();
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
                        R.id.blogFragment,
                        R.id.eventsFragment,
                        R.id.privacyPolicyFragment
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