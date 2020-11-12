package com.ad430.globaltactics;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.google.api.services.blogger.model.PostList;

public class BlogViewModel extends ViewModel {
    private final String TAG = BlogViewModel.class.getSimpleName();
    private BlogModel blogModel;
    private MutableLiveData<PostList> postList;

    public BlogViewModel() {
        blogModel = new BlogModel();
        postList = blogModel.getPostList();
    }

    MutableLiveData<PostList> getPostList() { return postList; }
}
