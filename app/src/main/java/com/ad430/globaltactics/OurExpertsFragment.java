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

import com.ad430.globaltactics.adapters.OurExpertsAdapter;
import com.ad430.globaltactics.objects.Expert;
import com.ad430.globaltactics.viewmodels.OurExpertsViewModel;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * create an instance of this fragment.
 */
public class OurExpertsFragment extends Fragment {
    final String TAG = OurExpertsFragment.class.getSimpleName();
    RecyclerView ourExpertsRecyclerView;
    RecyclerView.Adapter<OurExpertsAdapter.ViewHolder> ourExpertsAdapter;
    RecyclerView.LayoutManager ourExpertsLayoutManager;
    View ourExpertsView;

    private OurExpertsViewModel ourExpertsViewModel;


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

        final Activity activity = this.getActivity();

        ourExpertsViewModel = new OurExpertsViewModel();

        ourExpertsViewModel.getExperts(
                (ArrayList<Expert> experts) -> {
                    ourExpertsRecyclerView = ourExpertsView.findViewById(R.id.our_experts_list);
                    ourExpertsRecyclerView.setHasFixedSize(true);

                    ourExpertsLayoutManager = new LinearLayoutManager(activity);
                    ourExpertsRecyclerView.setLayoutManager(ourExpertsLayoutManager);

                    experts.sort((e1, e2) -> {
                      int e1ID = e1.getId();
                      int e2ID = e2.getId();
                      return Integer.compare(e1ID, e2ID);
                    });

                    experts.removeIf(expert -> {
                        Log.d(TAG, String.valueOf(expert.getId()));
                        return expert.getId() == -1;
                    });

                    ourExpertsAdapter = new OurExpertsAdapter(activity, experts);

                    ourExpertsRecyclerView.setAdapter(ourExpertsAdapter);
                }
        );
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        ourExpertsViewModel.clear();
    }
}