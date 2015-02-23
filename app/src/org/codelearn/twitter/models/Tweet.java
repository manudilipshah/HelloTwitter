package org.codelearn.twitter.models;

public class Tweet {

    String title;
    String tweetBody;
    String id;

    public String getTitle() {
        return title;
    }

    public String getBody() {
        return tweetBody;
    }

    public String getId() {
        return id;
    }

    public void setId(String pId) {
        id = pId;
    }

    public void setTitle(String pTitle) {
        title = pTitle;
    }

    public void setBody(String pTweetBody) {
        tweetBody = pTweetBody;
    }
}