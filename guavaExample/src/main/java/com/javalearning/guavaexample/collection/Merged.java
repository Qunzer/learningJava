package com.javalearning.guavaexample.collection;


/**
 * Created by renqun.yuan on 2015/9/8.
 */
public class Merged {
    private String userName;
    private String friendName;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getFriendName() {
        return friendName;
    }

    public void setFriendName(String friendName) {
        this.friendName = friendName;
    }

    @Override
    public String toString() {
        return "Merged{" +
                "userName='" + userName + '\'' +
                ", friendName='" + friendName + '\'' +
                '}';
    }
}
