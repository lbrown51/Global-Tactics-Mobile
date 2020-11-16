package com.ad430.globaltactics;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ad430.globaltactics.adapters.OurSuccessesAdapter;
import com.google.android.material.tabs.TabLayout;
import com.google.firebase.auth.FirebaseAuth;

public class OurSuccessesFragment extends Fragment {
    public ViewPager ourSuccessesViewPager;
    public TabLayout ourSuccessesTabs;
    public View ourSuccessesView;
    public OurSuccessesCorporateTab ourSuccessesCorporateTab;
    public OurSuccessesGovernmentTab ourSuccessesGovernmentTab;

    public OurSuccessesFragment() {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (FirebaseAuth.getInstance().getCurrentUser() == null) {
            new SignInHelper();
        }
    }

    @SuppressLint("ResourceType")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        ourSuccessesView = inflater.inflate(R.layout.fragment_our_successes, container, false);

        ourSuccessesViewPager = ourSuccessesView.findViewById(R.id.ourSuccessesViewPager);
        ourSuccessesTabs = ourSuccessesView.findViewById(R.id.ourSuccessesTabs);

        ourSuccessesCorporateTab = new OurSuccessesCorporateTab();
        ourSuccessesGovernmentTab = new OurSuccessesGovernmentTab();

        ourSuccessesTabs.setupWithViewPager(ourSuccessesViewPager);

        OurSuccessesAdapter ourSuccessesViewPagerAdapter = new OurSuccessesAdapter(getChildFragmentManager(), 0);

        ourSuccessesViewPagerAdapter.addFragment(ourSuccessesCorporateTab, getString(R.string.corporate));
        ourSuccessesViewPagerAdapter.addFragment(ourSuccessesGovernmentTab, getString(R.string.government));

        ourSuccessesViewPager.setAdapter(ourSuccessesViewPagerAdapter);

        return ourSuccessesView;
    }
}