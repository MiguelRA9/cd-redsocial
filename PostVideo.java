package com.campusdual.poo.ex8_red_social;

import java.time.LocalDateTime;

public class PostVideo extends Post {

    private String quality;
    private int duration;

    public PostVideo (int id, User user, String title, LocalDateTime date, String quality, int duration) {

        super(id, user, title, date);
        this.quality = quality;
        this.duration = duration;

    }

}