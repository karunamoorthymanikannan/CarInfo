package com.carinfo.realm;

import io.realm.RealmList;
import io.realm.RealmObject;

/**
 * Created by karunamoorthy on 31/5/16.
 */

public class CarMake extends RealmObject {
    private long id;
    private String name;
    private String niceName;
    private String path;
    private boolean isImageDownloaded=false;

    public boolean isImageDownloaded() {
        return isImageDownloaded;
    }

    public void setImageDownloaded(boolean imageDownloaded) {
        isImageDownloaded = imageDownloaded;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    private RealmList<CarModel> models;

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

    public String getNiceName() {
        return niceName;
    }

    public void setNiceName(String niceName) {
        this.niceName = niceName;
    }

    public RealmList<CarModel> getModels() {
        return models;
    }

    public void setModels(RealmList<CarModel> models) {
        this.models = models;
    }
}
