package com.campusdual.poo.ex8_red_social;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public abstract class Post {

    private int id;
    private User user;
    private String title ;
    private LocalDateTime date;
    private List<Comment> postCommentList = new ArrayList<>();

    public Post (int id, User user, String title, LocalDateTime date) {

        this.id = id;
        this.user = user;
        this.title = title;
        this.date = date;

    }

    public User getUser() {

        return user;

    }

    public String getTitle() {

        return title;

    }

    public LocalDateTime getDate() {

        return date;

    }

    public List<Comment> getPostCommentList() {

        return postCommentList;

    }

}