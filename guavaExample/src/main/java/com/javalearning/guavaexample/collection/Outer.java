package com.javalearning.guavaexample.collection;

import java.util.List;

/**
 * Created by renqun.yuan on 2015/9/8.
 */
public class Outer {
    private String userName;
    private List<Inner> frieds;

    public Outer(String userName, List<Inner> frieds) {
        this.userName = userName;
        this.frieds = frieds;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public List<Inner> getFrieds() {
        return frieds;
    }

    public void setFrieds(List<Inner> frieds) {
        this.frieds = frieds;
    }
}
