package com.ad430.globaltactics;

import android.app.Activity;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ad430.globaltactics.adapters.EventAdapter;
import com.ad430.globaltactics.adapters.OurSuccessTabListAdapter;
import com.ad430.globaltactics.objects.OurSuccess;
import com.ad430.globaltactics.viewmodels.OurSuccessesViewModel;

import java.util.ArrayList;
import java.util.HashMap;

public class OurSuccessesNonProfitTab extends Fragment {
    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    View myView;
    OurSuccessesViewModel ourSuccessesViewModel;
    ArrayList<HashMap<String,String>> nonProfitTabDataList = new ArrayList<>();

    public OurSuccessesNonProfitTab() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        myView = inflater.inflate(R.layout.fragment_our_successes_nonprofit_tab, container, false);

        return myView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        final Activity activity = this.getActivity();

        ourSuccessesViewModel = new OurSuccessesViewModel();

        ourSuccessesViewModel.getOurSuccesses(
            (ArrayList<OurSuccess> ourSuccesses) -> {
                recyclerView = myView.findViewById(R.id.ourSuccessesNonProfitList);
                recyclerView.setHasFixedSize(true);

                layoutManager = new LinearLayoutManager(this.getActivity());
                recyclerView.setLayoutManager(layoutManager);

                for (OurSuccess ourSuccess : ourSuccesses) {
                    if (ourSuccess.getParent().equals(getString(R.string.nonprofit))) {
                        HashMap<String, String> dataMap = new HashMap<>();

                        dataMap.put(getString(R.string.title), ourSuccess.getTitle());
                        dataMap.put(getString(R.string.description), ourSuccess.getDescription());
                        dataMap.put(getString(R.string.imageUrl), ourSuccess.getImageUrl());

                        nonProfitTabDataList.add(dataMap);
                    }
                }

                OurSuccessTabListAdapter ourSuccessTabListAdapter = new OurSuccessTabListAdapter(activity, nonProfitTabDataList);
                recyclerView.setAdapter(ourSuccessTabListAdapter);
            }
        );
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        ourSuccessesViewModel.clear();
    }
}