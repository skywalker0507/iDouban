package com.skywalker.idouban.models.movie;

import com.skywalker.idouban.models.Images;

/*******************************
 * Created by liuqiang          *
 *******************************
 * data: 2018/1/9               *
 *******************************/

public class Casts {
    private String alt;
    private Images avatars;
    private String name;
    private String id;

    public String getAlt() {
        return alt;
    }

    public void setAlt(String alt) {
        this.alt = alt;
    }

    public Images getAvatars() {
        return avatars;
    }

    public void setAvatars(Images avatars) {
        this.avatars = avatars;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
