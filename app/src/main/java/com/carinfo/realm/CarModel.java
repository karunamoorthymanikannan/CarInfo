package com.carinfo.realm;

import io.realm.RealmList;
import io.realm.RealmObject;

/**
 * Created by karunamoorthy on 3/6/16.
 */

public class CarModel extends RealmObject {
    private String id;
    private String name;
    private String niceName;
    private Make make;
    private RealmList<CarYear> years;

    private String path;


    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public Make getMake() {
        return make;
    }

    public void setMake(Make make) {
        this.make = make;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNiceName() {
        return niceName;
    }

    public void setNiceName(String niceName) {
        this.niceName = niceName;
    }

    public RealmList<CarYear> getYears() {
        return years;
    }

    public void setYears(RealmList<CarYear> years) {
        this.years = years;
    }

}
