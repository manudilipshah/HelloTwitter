package com.learn.start.hellotwitter;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import org.codelearn.twitter.models.Tweet;

import java.util.ArrayList;
import java.util.List;

//import android.app.ListActivity;
//import android.widget.TextView;


public class TweetListActivity extends ListActivity {

    //private ListView tweetListView;
    //private String[] stringArray;
    private ArrayAdapter tweetListAdapter;
    List<Tweet> Tweet = new ArrayList<Tweet>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_tweet_list);

        //stringArray = new String[10];
        /*for (int i=0;i<stringArray.length;i++) {

            stringArray[i] = "String" + i;
        }*/

        //tweetListAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, stringArray);

        for (int i = 0; i < 20; i++) {
            Tweet tweet = new Tweet();
            tweet.setTitle("A nice header for Tweet # " + i);
            tweet.setBody("Some random body text for the tweet # " + i);
            tweet.setId(Integer.toString(i));
            Tweet.add(tweet);
        }

        tweetListAdapter = new TweetAdapter(this, Tweet);

        //tweetListView = (ListView) findViewById(R.id.tweetlist);

        setListAdapter(tweetListAdapter);
    }

    @Override
    public void onListItemClick(ListView l, View v, int pos, long id) {

        Intent intent = new Intent(this, TweetDetailActivity.class);

        startActivity(intent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.tweet_list, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
