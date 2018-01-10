package com.skywalker.idouban.models;

/*******************************
 * Created by liuqiang          *
 *******************************
 * data: 2018/1/9               *
 *******************************/

public class Rating {
    private int max;
    private int numRaters;
    private float average;
    private int min;

    public int getMax() {
        return max;
    }

    public void setMax(int max) {
        this.max = max;
    }

    public int getNumRaters() {
        return numRaters;
    }

    public void setNumRaters(int numRaters) {
        this.numRaters = numRaters;
    }

    public float getAverage() {
        return average;
    }

    public void setAverage(float average) {
        this.average = average;
    }

    public int getMin() {
        return min;
    }

    public void setMin(int min) {
        this.min = min;
    }
}
