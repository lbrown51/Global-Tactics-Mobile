package com.ad430.globaltactics.adapters;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.ad430.globaltactics.R;
import com.squareup.picasso.Picasso;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;

import io.opencensus.internal.Utils;

public class OurSuccessTabListAdapter extends RecyclerView.Adapter<OurSuccessTabListAdapter.ViewHolder> {

    Context context;
    ArrayList<HashMap<String,String>> list = new ArrayList<>();

    public OurSuccessTabListAdapter(Context con,ArrayList<HashMap<String,String>> dataList) {
        context = con;
        list = dataList;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView ivOurSuccessFlag;
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

        String imageUrl = dataMap.get("imageUrl");

        Picasso.get().load(imageUrl).into(holder.ivOurSuccessFlag);

        holder.tvOurSuccessTitle.setText(dataMap.get("title").trim());
        holder.tvOurSuccessDescription.setText(dataMap.get("description").trim());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
