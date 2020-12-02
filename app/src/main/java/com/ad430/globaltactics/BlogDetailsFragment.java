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
 * Use the  factory method to
 * create an instance of this fragment.
 */
public class BlogDetailsFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_NAME = "name";
    private static final String ARG_TITLE = "title";
    private static final String ARG_CONTENT = "content";

    // TODO: Rename and change types of parameters
    private String name;
    private String title;
    private String content;


    public BlogDetailsFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            name = getArguments().getString(ARG_NAME);
            title = getArguments().getString(ARG_TITLE);
            content = getArguments().getString(ARG_CONTENT);
        }
        Log.d("ON_CREATE_BLOG_DETAILS", title);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_expert_details, container, false);

        TextView expertDetailsNameTV = v.findViewById(R.id.name);
        expertDetailsNameTV.setText(name);

        TextView expertDetailsTitleTV = v.findViewById(R.id.title);
        expertDetailsTitleTV.setText(title);

        TextView expertDetailsLocationTV = v.findViewById(R.id.content);
        expertDetailsLocationTV.setText(content);

        return v;
    }
}