package com.carinfo.realm;

import io.realm.RealmObject;

/**
 * Created by karunamoorthy on 9/6/16.
 */

public class CarColorChips extends RealmObject {
    private CarColorPrimary primary;

    public CarColorPrimary getPrimary() {
        return primary;
    }

    public void setPrimary(CarColorPrimary primary) {
        this.primary = primary;
    }
}
