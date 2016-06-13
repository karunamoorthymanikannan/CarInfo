package com.carinfo.realm;

import io.realm.RealmList;
import io.realm.RealmObject;

/**
 * Created by karunamoorthy on 31/5/16.
 */

public class CarYear extends RealmObject {
    private int id;
    private int year;
    private Make make;
    private String path;


    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
    private RealmList<CarStyles> styles;

    public RealmList<CarStyles> getStyles() {
        return styles;
    }

    public void setStyles(RealmList<CarStyles> styles) {
        this.styles = styles;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public Make getMake() {
        return make;
    }

    public void setMake(Make make) {
        this.make = make;
    }
}
