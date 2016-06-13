package com.carinfo.realm;

import io.realm.RealmObject;

/**
 * Created by karunamoorthy on 3/6/16.
 */

public class Style extends RealmObject {
    private long id;
    private String name;
    private String trim;
    private CarSubModel submodel;

    public String getTrim() {
        return trim;
    }

    public void setTrim(String trim) {
        this.trim = trim;
    }

    public CarSubModel getSubmodel() {
        return submodel;
    }

    public void setSubmodel(CarSubModel submodel) {
        this.submodel = submodel;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
