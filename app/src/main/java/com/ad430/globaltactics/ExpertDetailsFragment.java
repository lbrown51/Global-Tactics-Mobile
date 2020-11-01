package com.ad430.globaltactics;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 * create an instance of this fragment.
 */
public class ExpertDetailsFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_NAME = "name";
    private static final String ARG_TITLE = "title";
    private static final String ARG_LOCATION = "location";
    private static final String ARG_SPECIALTIES = "specialties";
    private static final String ARG_DESCRIPTION = "description";
    private static final String ARG_LINKEDIN = "linkedin";

    // TODO: Rename and change types of parameters
    private String name;
    private String title;
    private String location;
    private String specialties;
    private String description;
    private String linkedin;

    public ExpertDetailsFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            name = getArguments().getString(ARG_NAME);
            title = getArguments().getString(ARG_TITLE);
            location = getArguments().getString(ARG_LOCATION);
            specialties = getArguments().getString(ARG_SPECIALTIES);
            description = getArguments().getString(ARG_DESCRIPTION);
            linkedin = getArguments().getString(ARG_LINKEDIN);
        }
        Log.d("ON_CREATE_EXPERT_DETAILS", title);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_expert_details, container, false);

        TextView expertDetailsNameTV = v.findViewById(R.id.expert_details_name_tv);
        expertDetailsNameTV.setText(name);

        TextView expertDetailsTitleTV = v.findViewById(R.id.expert_details_title_tv);
        expertDetailsTitleTV.setText(title);

        TextView expertDetailsLocationTV = v.findViewById(R.id.expert_details_location_tv);
        expertDetailsLocationTV.setText(location);

        TextView expertDetailsDescriptionTV = v.findViewById(R.id.expert_details_description_tv);
        expertDetailsDescriptionTV.setText(description);

        return v;
    }
}