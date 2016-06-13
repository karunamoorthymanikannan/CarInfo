package com.carinfo.realm;

import io.realm.RealmObject;

/**
 * Created by karunamoorthy on 9/6/16.
 */

public class RealmString extends RealmObject {
    private String stringValue;

    public RealmString(){}

    public RealmString(String stringValue){
        this.stringValue =  stringValue;
    }


    public String getStringValue() {
        return stringValue;
    }

    public void setStringValue(String stringValue) {
        this.stringValue = stringValue;
    }

}
