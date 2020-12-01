package com.ad430.globaltactics;

import com.google.api.services.blogger.Blogger;
import com.google.api.services.blogger.model.PostList;

import java.util.concurrent.Callable;

public class BlogAsyncTask implements Callable<PostList> {
    private final Blogger.Posts.List listAction;

    public BlogAsyncTask(Blogger.Posts.List listAction) {
        this.listAction = listAction;
    }

    @Override
    public PostList call() throws Exception {
        return this.listAction.execute();
    }
}
