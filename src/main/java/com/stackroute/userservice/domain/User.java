package com.stackroute.userservice.domain;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class User {
    @Id
    int trackid;
    String trackName;
    String trackComment;

    public int getTrackid() {
        return trackid;
    }

    public void setTrackid(int trackid) {
        this.trackid = trackid;
    }

    public User()
    {

    }
    public User(int trackid, String trackName, String trackComment) {
        this.trackid = trackid;
        this.trackName = trackName;
        this.trackComment = trackComment;
    }


    public String getTrackName() {
        return trackName;
    }

    public void setTrackName(String trackName) {
        this.trackName = trackName;
    }

    public String getTrackComment() {
        return trackComment;
    }

    public void setTrackComment(String trackComment) {
        this.trackComment = trackComment;
    }

    @Override
    public String toString() {
        return "User{" +
                "trackid=" + trackid +
                ", trackName='" + trackName + '\'' +
                ", trackComment='" + trackComment + '\'' +
                '}';
    }
}

