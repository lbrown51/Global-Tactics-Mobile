package com.ad430.globaltactics;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.google.api.services.blogger.model.Post;
import com.google.api.services.blogger.model.PostList;

import java.util.ArrayList;
import java.util.HashMap;

public class BlogAdapter extends RecyclerView.Adapter<BlogAdapter.ViewHolder> {
        private PostList post_List;
        Context blogsContext;

        public BlogAdapter(Context context, PostList postList) {
            post_List = postList;
            blogsContext = context;
        }

        public class ViewHolder extends RecyclerView.ViewHolder {
            TextView postTitle, postAuthor, postContent;

            public ViewHolder(@NonNull final View itemView) {
                super(itemView);

                postTitle = itemView.findViewById(R.id.postTitle);
                postAuthor = itemView.findViewById(R.id.postAuthor);
                postContent = itemView.findViewById(R.id.postContent);
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
            holder.postAuthor.setText(post_List.getItems().get(position).getTitle());
            //holder.postContent.setText(post_List.getItems().get(position).getContent());


            holder.itemView.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    Bundle postBundle = new Bundle();
                    postBundle.putString("title", post_List.getItems().get(position).getTitle());
                    postBundle.putString("author", post_List.getItems().get(position).getPublished());
                    //postBundle.putString("content",post_List.getItems().get(position).getContent());
                    Navigation.findNavController(v)
                            .navigate(
                                    R.id.action_fragment_blog_to_blogDetailsFragment, postBundle
                            );
                }
            });
        }

        @Override
        public int getItemCount() {
            return post_List.getItems().size();
        }
    }


