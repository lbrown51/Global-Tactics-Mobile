package com.ad430.globaltactics;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class OurExpertsAdapter extends RecyclerView.Adapter<OurExpertsAdapter.ViewHolder> {
    private ArrayList<Expert> ourExperts;
    Context ourExpertsContext;

    public OurExpertsAdapter(Context context, ArrayList<Expert> ourExpertsList) {
        ourExperts = ourExpertsList;
        ourExpertsContext = context;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView expertNameTV, expertTitleTV, expertLocationTV, expertSpecialtiesTV;

        public ViewHolder(@NonNull final View itemView) {
            super(itemView);

            expertNameTV = itemView.findViewById(R.id.expert_name_tv);
            expertTitleTV = itemView.findViewById(R.id.expert_title_tv);
            expertLocationTV = itemView.findViewById(R.id.expert_location_tv);
            expertSpecialtiesTV = itemView.findViewById(R.id.expert_specialties_tv);

//            itemView.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(EventRecords.events.get(events.indexOf((Event) v.getTag())).getUrl()));
//                    myContext.startActivity(intent);
//                }
//            });
        }
    }

    @NonNull
    @Override
    public OurExpertsAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.expert_list_card, parent, false);

        return new ViewHolder(v);    }

    @Override
    public void onBindViewHolder(@NonNull OurExpertsAdapter.ViewHolder holder, int position) {
        holder.itemView.setTag(ourExperts.get(position));


        holder.expertNameTV.setText(ourExperts.get(position).getName());
        holder.expertTitleTV.setText(ourExperts.get(position).getTitle());
        holder.expertLocationTV.setText(ourExperts.get(position).getLocation());
        holder.expertSpecialtiesTV.setText(ourExperts.get(position).getSpecialties());
    }

    @Override
    public int getItemCount() {
        return ourExperts.size();
    }
}
