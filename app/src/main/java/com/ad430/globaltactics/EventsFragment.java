package com.ad430.globaltactics;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.HashMap;
import butterknife.BindView;


public class EventsFragment extends Fragment {
    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    View myView;

//    @BindView(R.id.eventList)
    ArrayList<HashMap<String,String>> dataList = new ArrayList<>();

    public EventsFragment() {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        myView = inflater.inflate(R.layout.fragment_events, container, false);

        return myView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        getData();

        recyclerView = myView.findViewById(R.id.eventList);
        recyclerView.setHasFixedSize(true);

        layoutManager = new LinearLayoutManager(this.getActivity());
        recyclerView.setLayoutManager(layoutManager);

        EventAdapter dataAdapter = new EventAdapter(this.getActivity(),dataList);
        recyclerView.setAdapter(dataAdapter);

        RecyclerItemDecoration recyclerItemDecoration = new RecyclerItemDecoration(this.getActivity(),getResources().getDimensionPixelSize(R.dimen.header_height),true,getSectionCallback(dataList));
        recyclerView.addItemDecoration(recyclerItemDecoration);
    }

    private RecyclerItemDecoration.SectionCallback getSectionCallback(final ArrayList<HashMap<String,String>> list) {
        return new RecyclerItemDecoration.SectionCallback() {
            @Override
            public boolean isSection(int pos) {
                return pos==0 || list.get(pos).get("Title")!=list.get(pos-1).get("Title");
            }

            @Override
            public String getSectionHeaderName(int pos) {
                HashMap<String,String> dataMap = list.get(pos);
                return dataMap.get("Title");
            }
        };
    }

    private void getData() {
        HashMap<String,String> dataMAp1 = new HashMap<>();
        dataMAp1.put("Title","October 2020");
        dataMAp1.put("date","Oct. 27-29");
        dataMAp1.put("description","\"GSMA Thrive North America featuring the CTIA 5G Summit");
        dataMAp1.put("url","http://www.gsmathrive.com/northamerica/");
        dataList.add(dataMAp1);

        HashMap<String,String> dataMAp2 = new HashMap<>();
        dataMAp2.put("Title","October 2020");
        dataMAp2.put("date","Oct. 28, 2020");
        dataMAp2.put("description","Preparing for the next globalisation: International business after covid-19");
        dataMAp2.put("url","http://www.gsmathrive.com/northamerica/");
        dataList.add(dataMAp2);

        HashMap<String,String> dataMAp3 = new HashMap<>();
        dataMAp3.put("Title","November 2020");
        dataMAp3.put("date","Nov. 28");
        dataMAp3.put("description","Preparing for the next globalisation: International business after covid-19");
        dataMAp3.put("url","http://www.gsmathrive.com/northamerica/");
        dataList.add(dataMAp3);

        HashMap<String,String> dataMAp4 = new HashMap<>();
        dataMAp4.put("Title","November 2020");
        dataMAp4.put("date","Nov. 29");
        dataMAp4.put("description","Preparing for the next globalisation: International business after covid-19");
        dataMAp4.put("url","http://www.gsmathrive.com/northamerica/");
        dataList.add(dataMAp4);

        HashMap<String,String> dataMAp5 = new HashMap<>();
        dataMAp5.put("Title","November 2020");
        dataMAp5.put("date","Nov. 30");
        dataMAp5.put("description","Preparing for the next globalisation: International business after covid-19");
        dataMAp5.put("url","http://www.gsmathrive.com/northamerica/");
        dataList.add(dataMAp5);

        HashMap<String,String> dataMAp6 = new HashMap<>();
        dataMAp6.put("Title","December 2020");
        dataMAp6.put("date","Dec. 1");
        dataMAp6.put("description","Preparing for the next globalisation: International business after covid-19");
        dataMAp6.put("url","http://www.gsmathrive.com/northamerica/");
        dataList.add(dataMAp6);

        HashMap<String,String> dataMAp7 = new HashMap<>();
        dataMAp7.put("Title","January 2021");
        dataMAp7.put("date","Jan. 1");
        dataMAp7.put("description","Preparing for the next globalisation: International business after covid-19");
        dataMAp7.put("url","http://www.gsmathrive.com/northamerica/");
        dataList.add(dataMAp7);

        HashMap<String,String> dataMAp8 = new HashMap<>();
        dataMAp8.put("Title","January 2021");
        dataMAp8.put("date","Jan. 8");
        dataMAp8.put("description","Preparing for the next globalisation: International business after covid-19");
        dataMAp8.put("url","http://www.gsmathrive.com/northamerica/");
        dataList.add(dataMAp8);

        HashMap<String,String> dataMAp9 = new HashMap<>();
        dataMAp9.put("Title","January 2021");
        dataMAp9.put("date","Jan. 10");
        dataMAp9.put("description","Preparing for the next globalisation: International business after covid-19");
        dataMAp9.put("url","http://www.gsmathrive.com/northamerica/");
        dataList.add(dataMAp9);

        HashMap<String,String> dataMAp10 = new HashMap<>();
        dataMAp10.put("Title","February 2021");
        dataMAp10.put("date","Feb. 10");
        dataMAp10.put("description","Preparing for the next globalisation: International business after covid-19");
        dataMAp10.put("url","http://www.gsmathrive.com/northamerica/");
        dataList.add(dataMAp10);

        HashMap<String,String> dataMAp11 = new HashMap<>();
        dataMAp11.put("Title","February 2021");
        dataMAp11.put("date","Feb. 15");
        dataMAp11.put("description","Preparing for the next globalisation: International business after covid-19");
        dataMAp11.put("url","http://www.gsmathrive.com/northamerica/");
        dataList.add(dataMAp11);
    }
}
