package com.ad430.globaltactics.adapters;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.ad430.globaltactics.R;
import com.google.api.services.blogger.model.PostList;

public class BlogAdapter extends RecyclerView.Adapter<BlogAdapter.ViewHolder> {
        private PostList post_List;
        Context blogsContext;

        public BlogAdapter(Context context, PostList postList) {
            post_List = postList;
            blogsContext = context;
        }

        public class ViewHolder extends RecyclerView.ViewHolder {
            TextView postTitle;

            public ViewHolder(@NonNull final View itemView) {
                super(itemView);

                postTitle = itemView.findViewById(R.id.postTitle);
            }
        }

        @NonNull
        @Override
        public BlogAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.post_list_card, parent, false);

            return new ViewHolder(v);
        }

        @Override
        public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
            holder.itemView.setTag(post_List.getItems().get(position));

            holder.postTitle.setText(post_List.getItems().get(position).getTitle());

            holder.itemView.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    String url = post_List.getItems().get(position).getUrl();
                    Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                    v.getContext().startActivity(i);
                }
            });
        }

        @Override
        public int getItemCount() {
            return post_List.getItems().size();
        }
    }


