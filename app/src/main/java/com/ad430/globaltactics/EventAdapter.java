package com.ad430.globaltactics;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

public class EventAdapter extends RecyclerView.Adapter<EventAdapter.ViewHolder> {

    private ArrayList<Event> events;
    EventClicked activity;

    public interface EventClicked {
        void onEventClicked(int index);
    }

    public EventAdapter (Context context, ArrayList<Event> eventList) {
        events = eventList;
        activity = (EventClicked) context;
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
                    activity.onEventClicked(events.indexOf((Event) v.getTag()));
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
    public void onBindViewHolder(@NonNull EventAdapter.ViewHolder holder, int position) {
        holder.itemView.setTag(events.get(position));
        holder.tvEventDate.setText(events.get(position).getDate());
        holder.tvEventDescription.setText(events.get(position).getTitle());
    }

    @Override
    public int getItemCount() {
        return events.size();
    }
}
