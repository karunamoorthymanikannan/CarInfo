package com.carinfo.utils;

import com.carinfo.realm.CustomString;

import io.realm.RealmList;

/**
 * Created by karunamoorthy on 2/6/16.
 */
public class ObjectHandling {
    private static ObjectHandling ourInstance = new ObjectHandling();

    public static ObjectHandling getInstance() {
        return ourInstance;
    }

    private ObjectHandling() {
    }

    private String makeName;
    private String styleName;

    public String getStyleName() {
        return styleName;
    }

    public void setStyleName(String styleName) {
        this.styleName = styleName;
    }

    public String getMakeName() {
        return makeName;
    }

    public void setMakeName(String makeName) {
        this.makeName = makeName;
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public long getStyleId() {
        return styleId;
    }

    public void setStyleId(long styleId) {
        this.styleId = styleId;
    }

    public RealmList<CustomString> getAllPathList() {
        return allPathList;
    }

    public void setAllPathList(RealmList<CustomString> allPathList) {
        this.allPathList = allPathList;
    }

    private RealmList<CustomString> allPathList;


    private String modelName;
    private int year;
    private long styleId;

}
