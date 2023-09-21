package com.campusdual.poo.ex8_red_social;

import java.time.LocalDateTime;

public class Comment {

    private User user;
    private Post post;
    private LocalDateTime date;
    private String content;

    public Comment (User user, Post post, LocalDateTime date, String content) {

        this.user = user;
        this.post = post;
        this.date = date;
        this.content = content;

    }

    public User getUser() {

        return user;

    }

    public LocalDateTime getDate() {

        return date;

    }

    public String getContent() {

        return content;

    }

}