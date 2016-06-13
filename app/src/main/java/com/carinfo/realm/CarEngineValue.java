package com.carinfo.realm;

import io.realm.RealmObject;

/**
 * Created by karunamoorthy on 9/6/16.
 */

public class CarEngineValue extends RealmObject {
    private String gear;

    public String getTiming() {
        return timing;
    }

    public void setTiming(String timing) {
        this.timing = timing;
    }

    public String getGear() {
        return gear;
    }

    public void setGear(String gear) {
        this.gear = gear;
    }

    private String timing;
}
