package com.skywalker.idouban.models;

/*******************************
 * Created by liuqiang          *
 *******************************
 * data: 2018/1/10               *
 *******************************/

public class TagItem<T> {
    private String title;
    private T value;

    public TagItem(String title, T value) {
        this.title = title;
        this.value = value;
    }

    public String getTitle() {
        return title;
    }

    public T getValue() {
        return value;
    }

}
