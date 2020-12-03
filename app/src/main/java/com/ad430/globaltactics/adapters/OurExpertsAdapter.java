package com.ad430.globaltactics.adapters;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.ad430.globaltactics.objects.Expert;
import com.ad430.globaltactics.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class OurExpertsAdapter extends RecyclerView.Adapter<OurExpertsAdapter.ViewHolder> {
    private ArrayList<Expert> ourExperts;
    Context ourExpertsContext;

    public OurExpertsAdapter(Context context, ArrayList<Expert> ourExpertsList) {
        ourExperts = ourExpertsList;
        ourExpertsContext = context;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView expertImageIV;
        TextView expertNameTV, expertTitleTV, expertLocationTV, expertSpecialtiesTV;

        public ViewHolder(@NonNull final View itemView) {
            super(itemView);

            expertImageIV = itemView.findViewById(R.id.expert_image_iv);
            expertNameTV = itemView.findViewById(R.id.expert_name_tv);
            expertTitleTV = itemView.findViewById(R.id.expert_title_tv);
            expertLocationTV = itemView.findViewById(R.id.expert_location_tv);
            expertSpecialtiesTV = itemView.findViewById(R.id.expert_specialties_tv);
        }
    }

    @NonNull
    @Override
    public OurExpertsAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.expert_list_card, parent, false);

        return new ViewHolder(v);    }

    @Override
    public void onBindViewHolder(@NonNull OurExpertsAdapter.ViewHolder holder, final int position) {
        holder.itemView.setTag(ourExperts.get(position));

        Picasso.get().load(ourExperts.get(position).getImageUrl()).into(holder.expertImageIV);
        holder.expertNameTV.setText(ourExperts.get(position).getName());
        holder.expertTitleTV.setText(ourExperts.get(position).getTitle());
        holder.expertLocationTV.setText(ourExperts.get(position).getLocation());
        holder.expertSpecialtiesTV.setText(ourExperts.get(position).getSpecialties());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Bundle expertBundle = new Bundle();
                expertBundle.putString("name", ourExperts.get(position).getName());
                expertBundle.putString("title", ourExperts.get(position).getTitle());
                expertBundle.putString("location", ourExperts.get(position).getLocation());
                expertBundle.putString("specialties", ourExperts.get(position).getSpecialties());
                expertBundle.putString("description", ourExperts.get(position).getDescription());
                expertBundle.putString("linkedin", ourExperts.get(position).getLinkedin());
                expertBundle.putString("imageUrl", ourExperts.get(position).getImageUrl());

                Navigation.findNavController(v)
                        .navigate(
                                R.id.action_ourExpertsFragment_to_expertDetailsFragment,
                                expertBundle
                        );
            }
        });
    }

    @Override
    public int getItemCount() {
        return ourExperts.size();
    }
}
