package com.ad430.globaltactics;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.navigation.NavigationView;
//import com.google.firebase.firestore.DocumentReference;
//import com.google.firebase.firestore.FirebaseFirestore;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    final String TAG = "MAIN ACTIVITY";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        FirebaseFirestore db = FirebaseFirestore.getInstance();
//
//        Map<String, Object> contactFormInfo = new HashMap<>();
//        contactFormInfo.put("firstName", "Lenny");
//        contactFormInfo.put("lastName", "Brown");
//        contactFormInfo.put("topic", "Consultancy");
//        contactFormInfo.put("email", "penn2014@gmail.com");
//        contactFormInfo.put("message", "I'm contacting you about possible consulting I need done in the near future");
//
//        db.collection("requests")
//                .add(contactFormInfo)
//                .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
//                    @Override
//                    public void onSuccess(DocumentReference documentReference) {
//                        Log.d(TAG, "DocumentSnapshot added with ID: " + documentReference.getId());
//                    }
//                })
//                .addOnFailureListener(new OnFailureListener() {
//                    @Override
//                    public void onFailure(@NonNull Exception e) {
//                        Log.w(TAG, "Error adding document", e);
//                    }
//                });
//
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