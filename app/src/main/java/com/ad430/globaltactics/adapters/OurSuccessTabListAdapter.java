package com.ad430.globaltactics.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.ad430.globaltactics.R;

import java.util.ArrayList;
import java.util.HashMap;

public class OurSuccessTabListAdapter extends RecyclerView.Adapter<OurSuccessTabListAdapter.ViewHolder> {

    Context context;
    ArrayList<HashMap<String,String>> list = new ArrayList<>();

    public OurSuccessTabListAdapter(Context con,ArrayList<HashMap<String,String>> dataList) {
        context = con;
        list = dataList;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView ivOurSuccessFlag, ivOurSuccessBackground;
        TextView tvOurSuccessTitle, tvOurSuccessDescription;

        public ViewHolder(@NonNull final View itemView) {
            super(itemView);

            ivOurSuccessFlag = itemView.findViewById(R.id.ivOurSuccessFlag);
            tvOurSuccessTitle = itemView.findViewById(R.id.tvOurSuccessTitle);
            tvOurSuccessDescription = itemView.findViewById(R.id.tvOurSuccessDescription);
        }
    }

    @NonNull
    @Override
    public OurSuccessTabListAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_our_successes_list, parent, false);

        return new OurSuccessTabListAdapter.ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        HashMap<String,String> dataMap = list.get(position);
        holder.itemView.setTag(position);

        int imageId = context.getResources().getIdentifier(dataMap.get("resource"), "drawable", context.getPackageName());

        holder.ivOurSuccessFlag.setImageResource(imageId);
        holder.tvOurSuccessTitle.setText(dataMap.get("title"));
        holder.tvOurSuccessDescription.setText(dataMap.get("description"));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
