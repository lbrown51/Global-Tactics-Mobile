package com.ad430.globaltactics;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;

import com.ad430.globaltactics.adapters.BlogAdapter;
import com.ad430.globaltactics.viewmodels.BlogViewModel;

import java.util.Objects;

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
                    blogsRecyclerView = blogsView.findViewById(R.id.blogs_list);
                    blogsRecyclerView.setHasFixedSize(true);

                    blogsLayoutManager = new LinearLayoutManager(activity);
                    blogsRecyclerView.setLayoutManager(blogsLayoutManager);

                    blogsAdapter = new BlogAdapter(activity, postList);

                    blogsRecyclerView.setAdapter(blogsAdapter);

                }
        );

        String[] Labels = new String[] {
                "Entrepreneurship", "Leadership", "Risks",
                "Africa", "China", "Europe", "India", "Latin America", "MENA"
        };

        ArrayAdapter<String> labelAdapter =
                new ArrayAdapter<>(
                        Objects.requireNonNull(getContext()),
                        R.layout.dropdown_menu_blog_post_label_popup_item,
                        Labels
                );

        AutoCompleteTextView blogPostLabelsExposedDropdown =
                blogsView.findViewById(R.id.blog_post_label_dropdown);

        blogPostLabelsExposedDropdown.setAdapter(labelAdapter);
        blogPostLabelsExposedDropdown.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                blogViewModel.updatePostListLabelSelection(Labels[position]);
                hideSoftKeyboard(view.getContext(), blogPostLabelsExposedDropdown);
            }
        });
    }

    private static void hideSoftKeyboard(Context context, AutoCompleteTextView labelView){
        if(((Activity) context).getCurrentFocus()!=null && ((Activity) context).getCurrentFocus() != null){
            InputMethodManager imm = (InputMethodManager) context.getSystemService(Context.INPUT_METHOD_SERVICE);
            assert imm != null;
            imm.hideSoftInputFromWindow(labelView.getWindowToken(), 0);
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }
}