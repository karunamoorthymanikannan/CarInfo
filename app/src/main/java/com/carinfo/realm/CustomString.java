package com.carinfo.realm;

import io.realm.RealmObject;
import io.realm.annotations.RealmClass;

/**
 * Created by karunamoorthy on 9/6/16.
 */
@RealmClass
public class CustomString extends RealmObject{
    private String path;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    private String title;

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
