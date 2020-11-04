package com.ad430.globaltactics;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;

public class EventsFragment extends Fragment {
    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    View myView;
    EventViewModel eventViewModel;
    ArrayList<HashMap<String,String>> dataList = new ArrayList<>();

    ArrayList<Event> list = new ArrayList<>();

    public EventsFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        myView = inflater.inflate(R.layout.fragment_events, container, false);

        return myView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        final Activity activity = this.getActivity();

        eventViewModel = new EventViewModel();

        eventViewModel.getEvents(
            (ArrayList<Event> events) -> {
                recyclerView = myView.findViewById(R.id.eventList);
                recyclerView.setHasFixedSize(true);

                layoutManager = new LinearLayoutManager(this.getActivity());
                recyclerView.setLayoutManager(layoutManager);

                for (Event event : events) {
                    HashMap<String,String> dataMAp = new HashMap<>();
                    dataMAp.put("title", event.getTitle());
                    dataMAp.put("date", event.getDate());
                    dataMAp.put("description", event.getDescription());
                    dataMAp.put("url", event.getHost());
                    dataMAp.put("intDate", String.valueOf(event.getIntDate()));

                    dataList.add(dataMAp);
                }

                Collections.sort(dataList, new Comparator<HashMap<String, String>>() {
                    @Override
                    public int compare(HashMap<String, String> o1, HashMap<String, String> o2) {
                        return o1.get("intDate").compareTo(o2.get("intDate"));
                    }
                });

                EventAdapter dataAdapter = new EventAdapter(activity, dataList);
                recyclerView.setAdapter(dataAdapter);

                RecyclerItemDecoration recyclerItemDecoration = new RecyclerItemDecoration(this.getActivity(),getResources().getDimensionPixelSize(R.dimen.header_height),true,getSectionCallback(dataList));
                recyclerView.addItemDecoration(recyclerItemDecoration);
            }
        );
    }

    private RecyclerItemDecoration.SectionCallback getSectionCallback(final ArrayList<HashMap<String,String>> list) {
        return new RecyclerItemDecoration.SectionCallback() {
            @Override
            public boolean isSection(int pos) {
                return pos==0 || !list.get(pos).get("title").equals(list.get(pos-1).get("title"));
            }

            @Override
            public String getSectionHeaderName(int pos) {
                return String.valueOf(list.get(pos).get("title"));
            }
        };
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        eventViewModel.clear();
    }
}
