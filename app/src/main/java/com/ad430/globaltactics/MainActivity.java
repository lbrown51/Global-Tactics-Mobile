package com.ad430.globaltactics;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        AboutUsFragment aboutUsFragment = new AboutUsFragment();
        fragmentTransaction.add(R.id.about_fragment_container, aboutUsFragment);

        BlogFragment blogFragment = new BlogFragment();
        fragmentTransaction.add(R.id.blog_fragment_container, blogFragment);

        EventsFragment eventsFragment = new EventsFragment();
        fragmentTransaction.add(R.id.events_fragment_container, eventsFragment);

        PrivacyPolicyFragment privacyPolicyFragment = new PrivacyPolicyFragment();
        fragmentTransaction.add(R.id.privacy_fragment_container, privacyPolicyFragment);

        fragmentTransaction.commit();
    }
}