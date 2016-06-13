package com.carinfo.realm;

import io.realm.RealmObject;

/**
 * Created by karunamoorthy on 9/6/16.
 */

public class CarMPG extends RealmObject {
    private String city;

    public String getHighway() {
        return highway;
    }

    public void setHighway(String highway) {
        this.highway = highway;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    private String highway;
}
