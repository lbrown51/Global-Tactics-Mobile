package com.ad430.globaltactics;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;

public class EventAdapter extends RecyclerView.Adapter<EventAdapter.ViewHolder> {

    Context context;
    ArrayList<HashMap<String,String>> list = new ArrayList<>();

    public EventAdapter(Context con,ArrayList<HashMap<String,String>> dataList) {
        context = con;
        list = dataList;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView ivEventCalendar;
        TextView tvEventDate, tvEventDescription;

        public ViewHolder(@NonNull final View itemView) {
            super(itemView);

            ivEventCalendar = itemView.findViewById(R.id.ivEventCalendar);
            tvEventDate = itemView.findViewById(R.id.tvEventDate);
            tvEventDescription = itemView.findViewById(R.id.tvEventDescription);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(list.get((Integer) v.getTag()).get("url")));
                    context.startActivity(intent);
                }
            });
        }
    }

    @NonNull
    @Override

    public EventAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.event_list, parent, false);

        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        HashMap<String,String> dataMap = list.get(position);
        holder.itemView.setTag(position);
        holder.tvEventDate.setText(dataMap.get("date"));
        holder.tvEventDescription.setText(dataMap.get("description"));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
