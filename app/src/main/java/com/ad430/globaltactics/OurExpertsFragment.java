package com.ad430.globaltactics;

import android.app.Activity;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

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

                    ourExpertsAdapter = new OurExpertsAdapter(activity, experts);

                    ourExpertsRecyclerView.setAdapter(ourExpertsAdapter);
                }
        );
    }
}