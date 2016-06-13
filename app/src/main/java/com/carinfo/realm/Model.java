package com.carinfo.realm;

import io.realm.RealmObject;

/**
 * Created by karunamoorthy on 3/6/16.
 */

public class Model extends RealmObject {
    private String id;
    private String name;
    private String niceName;

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
}
