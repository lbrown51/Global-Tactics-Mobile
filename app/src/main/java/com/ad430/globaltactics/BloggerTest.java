package com.ad430.globaltactics;

import android.os.AsyncTask;
import android.util.Log;

import com.google.api.client.http.HttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.services.blogger.Blogger;
import com.google.api.services.blogger.model.Blog;
import com.google.api.services.blogger.model.Post;
import com.google.api.services.blogger.model.PostList;

import java.io.IOException;
import java.util.List;

public class BloggerTest extends AsyncTask<String, Integer, Long> {
    String TAG = BloggerTest.class.getSimpleName();

    @Override
    protected Long doInBackground(String... strings) {
        String CODE_BLOG_URL = "http://code.blogger.com/";
        String BLOG_URL = "https://www.gtperspectives.com/";

        // Configure the Java API Client for Installed Native App
        HttpTransport HTTP_TRANSPORT = new NetHttpTransport();
        JacksonFactory JSON_FACTORY = new JacksonFactory();

        // Configure the Installed App OAuth2 flow.
        //        Credential credential = OAuth2Native.authorize(HTTP_TRANSPORT,
        //                JSON_FACTORY, new LocalServerReceiver(),
        //                Arrays.asList(BloggerScopes.BLOGGER));`

        // Construct the Blogger API access facade object.
        Blogger blogger = new Blogger(HTTP_TRANSPORT, JSON_FACTORY, null);

        Blogger.Blogs.GetByUrl blogGetByUrlAction = null;
        Blogger.Posts.Get postsGetAction = null;
        Blogger.Posts.Search postsSearchAction = null;
        Blogger.Posts.List postsListAction = null;

        try {
            // The request action object.
            blogGetByUrlAction = blogger.blogs().getByUrl(BLOG_URL);
            blogGetByUrlAction.setKey("AIzaSyCMWpGVYH182Z3FjkmNn-W1qBoldx3Is5E");

            // Restrict the result content to just the data we need.
//            blogGetByUrlAction.setFields("description,name,posts/totalItems,updated");

            // This step sends the request to the server.
            Blog blog = blogGetByUrlAction.execute();
            String blogId = blog.getId();

            postsGetAction = blogger.posts().get(blogId, "");
            postsGetAction.setKey("AIzaSyCMWpGVYH182Z3FjkmNn-W1qBoldx3Is5E");

            Post postsAll = postsGetAction.execute();


            postsSearchAction = blogger.posts().search(blogId, "label=Entrepreneurship");
            postsSearchAction.setKey("AIzaSyCMWpGVYH182Z3FjkmNn-W1qBoldx3Is5E");
            postsSearchAction.setFetchBodies(true);

            PostList postsByLabel = postsSearchAction.execute();


            postsListAction = blogger.posts().list(blogId);
            postsListAction.setKey("AIzaSyCMWpGVYH182Z3FjkmNn-W1qBoldx3Is5E");
            postsListAction.setLabels("Entrepreneurship");
            postsListAction.setMaxResults(5L);
            postsListAction.setFetchBodies(true);

            PostList postsByLabelList = postsListAction.execute();
            // Now we can navigate the response.
            Log.d("TESSSST", "Name: " + blog.getName());
            Log.d(TAG, "Description: " + blog.getDescription());
            Log.d(TAG, "Post Count: " + blog.getPosts().getTotalItems());
            Log.d(TAG, "Last Updated: " + blog.getUpdated());

            // This gets an array list of the posts
            //  posts.get("items");

            // those array maps can basically be accessed using
            // kind, id, blog, published, updated, url,..., title, content author, labels....

            return null;
        } catch (IOException e) {
            e.printStackTrace();
        }

        String bloggerURL = "https://www.googleapis.com/blogger/v3/blogs/5044990419048085041/posts?key=AIzaSyCMWpGVYH182Z3FjkmNn-W1qBoldx3Is5E";

        return null;
    }
}
