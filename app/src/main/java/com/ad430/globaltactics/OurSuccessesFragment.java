package com.ad430.globaltactics;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.os.Parcelable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

import com.google.android.material.tabs.TabLayout;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

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

        ourSuccessesViewPagerAdapter.addFragment(ourSuccessesCorporateTab, getString(R.string.corporates));
        ourSuccessesViewPagerAdapter.addFragment(ourSuccessesGovernmentTab, getString(R.string.governments));

        ourSuccessesViewPager.setAdapter(ourSuccessesViewPagerAdapter);

        return ourSuccessesView;
    }
}