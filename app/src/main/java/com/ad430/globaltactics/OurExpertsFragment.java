package com.ad430.globaltactics;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * create an instance of this fragment.
 */
public class OurExpertsFragment extends Fragment {
    RecyclerView ourExpertsRecyclerView;
    RecyclerView.Adapter<OurExpertsAdapter.ViewHolder> ourExpertsAdapter;
    RecyclerView.LayoutManager ourExpertsLayoutManager;
    View ourExpertsView;

    public OurExpertsFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        ourExpertsView = inflater.inflate(R.layout.fragment_our_experts, container, false);
        return ourExpertsView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        ourExpertsRecyclerView = ourExpertsView.findViewById(R.id.our_experts_list);
        ourExpertsRecyclerView.setHasFixedSize(true);

        ourExpertsLayoutManager = new LinearLayoutManager(this.getActivity());
        ourExpertsRecyclerView.setLayoutManager(ourExpertsLayoutManager);

        ArrayList<Expert> testExperts = new ArrayList<>();

        Expert lenny = new Expert(
                "Lenny",
                "Best Manager",
                "Seattle",
                "Management, Testing, Being Cool",
                "Is the best manager on the team, everyone loves Lenny."
        );

        testExperts.add(lenny);

        ourExpertsAdapter = new OurExpertsAdapter(this.getActivity(), testExperts);

        ourExpertsRecyclerView.setAdapter(ourExpertsAdapter);
    }
}