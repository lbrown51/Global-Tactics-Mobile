package com.ad430.globaltactics.viewmodels;

import androidx.annotation.Nullable;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.ad430.globaltactics.models.BlogModel;
import com.google.api.services.blogger.model.PostList;

public class BlogViewModel extends ViewModel {
    private final String TAG = BlogViewModel.class.getSimpleName();
    private BlogModel blogModel;
    private MutableLiveData<PostList> postList;

    public BlogViewModel() {
        blogModel = new BlogModel();
        postList = blogModel.getPostList();
    }

    public MutableLiveData<PostList> getPostList() { return postList; }

    public void updatePostListLabelSelection(@Nullable String label) {
        blogModel.updatePostListLabelSelection(label);
    }

}
