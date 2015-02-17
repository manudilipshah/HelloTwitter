package com.learn.start.hellotwitter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.view.View;

/**
 * Created by manushah on 15/02/15.
 */
public class TweetAdapter extends ArrayAdapter{

    public LayoutInflater inflater;

    public TweetAdapter (Activity activity, String [] items) {

        super (activity, R.layout.row_tweet, items);

        inflater = activity.getWindow().getLayoutInflater();
    }

    @Override
    public View getView (int position, View convertView, ViewGroup parent) {

        return inflater.inflate(R.layout.row_tweet, parent, false);

    }
}
