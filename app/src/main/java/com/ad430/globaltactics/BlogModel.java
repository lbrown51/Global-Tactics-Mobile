package com.ad430.globaltactics;

import androidx.lifecycle.MutableLiveData;

import com.google.api.client.http.HttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.services.blogger.Blogger;
import com.google.api.services.blogger.model.PostList;

import java.io.IOException;
import java.util.ArrayList;

public class BlogModel {
    private final String TAG = BlogModel.class.getSimpleName();
    private final MutableLiveData<PostList> postList;
    private Blogger blogger;
    private TaskRunner taskRunner;
    private ArrayList <String> labels;
    private String [] listOfLabels = {"Entrepreneurship","Leadership", "Risks", "Africa", "China", "Europe", "India", "Latin America", "MENA"};
    BlogModel() {
        postList = new MutableLiveData<>();
        taskRunner = new TaskRunner();


        String BLOG_URL = "https://www.gtperspectives.com/";
        String BLOG_ID = "5044990419048085041";

        // Configure the Java API Client for Installed Native App
        HttpTransport HTTP_TRANSPORT = new NetHttpTransport();
        JacksonFactory JSON_FACTORY = new JacksonFactory();
        blogger = new Blogger(HTTP_TRANSPORT, JSON_FACTORY, null);

        Blogger.Posts.List postListGetAllAction = null;

        try {
            postListGetAllAction = blogger.posts().list(BLOG_ID);
            //add labels to postListGetAllAction
            addLabelsToPostListGetAllAction(postListGetAllAction);
            postListGetAllAction.setKey("AIzaSyC_B6br4L6-nP2F-R-4mLycGmfxddyX3Bg");
            postListGetAllAction.setMaxResults(5L);



            taskRunner.executeAsync(new BlogAsyncTask(postListGetAllAction), postList::setValue);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    MutableLiveData<PostList> getPostList() {
        return postList;
    }
    private void addLabelsToPostListGetAllAction(Blogger.Posts.List postListGetAllAction) {
        for (String label:listOfLabels
             )  postListGetAllAction.setLabels(label);
    }
}
