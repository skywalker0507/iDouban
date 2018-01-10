package com.skywalker.idouban.models.movie;

/*******************************
 * Created by liuqiang          *
 *******************************
 * data: 2018/1/10               *
 *******************************/

public class Top250 {
    private int count;
    private int start;
    private int total;
    private Movie[] subjects;
    private String title;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public Movie[] getSubjects() {
        return subjects;
    }

    public void setSubjects(Movie[] subjects) {
        this.subjects = subjects;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
