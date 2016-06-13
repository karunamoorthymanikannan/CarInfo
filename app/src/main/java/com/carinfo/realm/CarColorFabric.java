package com.carinfo.realm;

import io.realm.RealmObject;

/**
 * Created by karunamoorthy on 9/6/16.
 */

public class CarColorFabric extends RealmObject {
    private String name;
    private String value;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
