package com.carinfo.realm;

import io.realm.RealmList;
import io.realm.RealmObject;

/**
 * Created by karunamoorthy on 9/6/16.
 */

public class CarColors extends RealmObject {
    private String category;
    private RealmList<CarColorOptions> options;
}
