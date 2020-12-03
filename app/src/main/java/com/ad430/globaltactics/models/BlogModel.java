package com.ad430.globaltactics.models;

import androidx.annotation.Nullable;
import androidx.lifecycle.MutableLiveData;

import com.ad430.globaltactics.BlogAsyncTask;
import com.ad430.globaltactics.TaskRunner;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.services.blogger.Blogger;
import com.google.api.services.blogger.model.PostList;

import java.io.IOException;
import java.util.HashMap;

public class BlogModel {
    private final String TAG = BlogModel.class.getSimpleName();
    String BLOG_ID = "5044990419048085041";

    private final MutableLiveData<PostList> postList;
    private final HashMap<String, PostList> postRecord;

    private Blogger blogger;
    private TaskRunner taskRunner;
    HttpTransport HTTP_TRANSPORT;
    JacksonFactory JSON_FACTORY;

    public BlogModel() {
        postList = new MutableLiveData<>();
        postRecord = new HashMap<>();

        taskRunner = new TaskRunner();

        String BLOG_URL = "https://www.gtperspectives.com/";

        // Configure the Java API Client for Installed Native App
        HTTP_TRANSPORT = new NetHttpTransport();
        JSON_FACTORY = new JacksonFactory();
        blogger = new Blogger(HTTP_TRANSPORT, JSON_FACTORY, null);

        createAndExecuteGetPostListAction(null);
    }

    public MutableLiveData<PostList> getPostList() {
        return postList;
    }

    public void updatePostListLabelSelection(@Nullable String label) {
        createAndExecuteGetPostListAction(label);
    }

    private void createAndExecuteGetPostListAction(@Nullable String label) {
        if (postRecord.containsKey(label)) {
            postList.setValue(postRecord.get(label));
        } else {
            Blogger.Posts.List getPostListAction = null;

            try {
                getPostListAction = blogger.posts().list(BLOG_ID);
                //add labels to postListGetByLabelAction
                getPostListAction.setKey("AIzaSyC_B6br4L6-nP2F-R-4mLycGmfxddyX3Bg");

                if (label != null) {
                    if(label.equals("risks") || label.equals("leadership")) {
                        String uncappedLabel = label.substring(0, 1).toLowerCase() + label.substring(1);
                        getPostListAction.setLabels(uncappedLabel);
                    }
                    else {
                        getPostListAction.setLabels(label);
                    }
                }

                getPostListAction.setMaxResults(5L);

                taskRunner.executeAsync(new BlogAsyncTask(getPostListAction), result -> {
                    postList.setValue(result);
                    postRecord.put(label, result);
                });
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
