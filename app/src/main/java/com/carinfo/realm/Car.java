package com.carinfo.realm;

import io.realm.RealmList;
import io.realm.RealmObject;

/**
 * Created by karunamoorthy on 31/5/16.
 */

public class Car extends RealmObject {
    private RealmList<CarMake> makes;
    private boolean isMakeImageDownloaded=false;

    public boolean isMakeImageDownloaded() {
        return isMakeImageDownloaded;
    }

    public void setMakeImageDownloaded(boolean makeImageDownloaded) {
        isMakeImageDownloaded = makeImageDownloaded;
    }

    public RealmList<CarMake> getMakes() {
        return makes;
    }

    public void setMakes(RealmList<CarMake> makes) {
        this.makes = makes;
    }

    public int getMakesCount() {
        return makesCount;
    }

    public void setMakesCount(int makesCount) {
        this.makesCount = makesCount;
    }

    private int makesCount;
}
