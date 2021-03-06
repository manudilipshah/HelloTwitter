package com.learn.start.hellotwitter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import org.codelearn.twitter.models.Tweet;

import java.util.List;

//import java.util.ArrayList;

class TweetAdapter extends ArrayAdapter<Tweet> {

    private final LayoutInflater inflater;

    private final List<Tweet> tweets;

    public TweetAdapter (Activity activity, List <Tweet> pTweets) {

        super (activity, R.layout.row_tweet, pTweets);

        tweets = pTweets;

        inflater = activity.getWindow().getLayoutInflater();
    }

    @Override
    public View getView (int position, View convertView, ViewGroup parent) {

        Tweet tweet = tweets.get(position);

        View tweetView = convertView;

        if (tweetView == null) {

            tweetView = inflater.inflate(R.layout.row_tweet, parent, false);
        }

        TextView tweetData = (TextView) tweetView.findViewById(R.id.tweet_data);
        tweetData.setText(tweet.getBody());

        TextView tweetTitle = (TextView)tweetView.findViewById(R.id.tweetTitle);
        tweetTitle.setText(tweet.getTitle());

        return tweetView;

    }
}
