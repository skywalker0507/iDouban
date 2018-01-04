package com.skywalker.idouban.models;

import android.graphics.Bitmap;

/*******************************
 * Created by liuqiang          *
 *******************************
 * data: 2018/1/4               *
 *******************************/

public class AppItem {
    private Bitmap mIcon;
    private String Name;
    private int mPrice;
    private float mScore;
    private static final String FREE = "Free";

    public AppItem(String name,Bitmap icon) {
        mIcon = icon;
        Name = name;
    }

    public void setPrice(int price) {
        mPrice = price;
    }

    public void setScore(float score) {
        mScore = score;
    }

    public Bitmap getIcon() {
        return mIcon;
    }

    public String getName() {
        return Name;
    }

    public int getPrice() {
        return mPrice;
    }

    public String getDisplayPrice() {
        return mPrice==0?FREE:Float.toString(mPrice);
    }

    public float getScore() {
        return mScore;
    }
}
