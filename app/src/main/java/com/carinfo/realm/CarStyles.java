package com.carinfo.realm;

import io.realm.RealmList;
import io.realm.RealmObject;

/**
 * Created by karunamoorthy on 1/6/16.
 */

public class CarStyles extends RealmObject {
    private String path;

    public CarImage getCarImage() {
        return carImage;
    }

    public void setCarImage(CarImage carImage) {
        this.carImage = carImage;
    }

    private CarImage carImage;

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }


    private long id;
    private String name;
    private String trim;

    public String getTrim() {
        return trim;
    }

    public void setTrim(String trim) {
        this.trim = trim;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    private String makeName;
    private String modelName;
    private String styleId;
    private int year;
    private RealmList<CustomString> pathList;

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

    public String getStyleId() {
        return styleId;
    }

    public void setStyleId(String styleId) {
        this.styleId = styleId;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public RealmList<CustomString> getPathList() {
        return pathList;
    }

    public void setPathList(RealmList<CustomString> pathList) {
        this.pathList = pathList;
    }
}
