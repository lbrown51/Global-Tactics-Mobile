package com.ad430.globaltactics;

import android.app.Activity;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * create an instance of this fragment.
 */
public class BlogFragment extends Fragment {
    private final String TAG = BlogFragment.class.getSimpleName();
    RecyclerView blogsRecyclerView;
    RecyclerView.Adapter<BlogAdapter.ViewHolder> blogsAdapter;
    RecyclerView.LayoutManager blogsLayoutManager;
    View blogsView;
    private BlogViewModel blogViewModel;

    public BlogFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        blogsView = inflater.inflate(R.layout.fragment_blog, container, false);

        // Inflate the layout for this fragment
        return blogsView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        final Activity activity = this.getActivity();

        blogViewModel = new BlogViewModel();

        blogViewModel.getPostList().observe(getViewLifecycleOwner(), postList -> {
            Log.d(TAG, postList.getItems().get(0).getTitle());
            blogsRecyclerView = blogsView.findViewById(R.id.blogs_list);
            blogsRecyclerView.setHasFixedSize(true);

            blogsLayoutManager = new LinearLayoutManager(activity);
            blogsRecyclerView.setLayoutManager(blogsLayoutManager);

            blogsAdapter = new BlogAdapter(activity, postList);

            blogsRecyclerView.setAdapter(blogsAdapter);
        }
        );
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
       // blogViewModel.clear();
    }
}