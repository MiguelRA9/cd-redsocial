package com.campusdual.poo.ex8_red_social;

import java.util.ArrayList;
import java.util.List;

public class User {

    private String name;
    private List<User> followingList = new ArrayList<>();
    private List<Post> userPostsList = new ArrayList<>();

    public User (String name) {

        this.name = name;

    }

    public String getName() {

        return name;

    }

    public List<Post> getUserPostList() {

        return userPostsList;

    }

    public List<User> getFollowingList() {

        return followingList;

    }

}