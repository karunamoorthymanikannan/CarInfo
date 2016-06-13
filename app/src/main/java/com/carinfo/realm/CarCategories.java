package com.carinfo.realm;

import io.realm.RealmObject;

/**
 * Created by karunamoorthy on 9/6/16.
 */

public class CarCategories extends RealmObject {
    private String EPAClass;
    private String market;
    private String primaryBodyType;
    private String vehicleSize;
    private String vehicleStyle;

    public String getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

    public String getVehicleStyle() {
        return vehicleStyle;
    }

    public void setVehicleStyle(String vehicleStyle) {
        this.vehicleStyle = vehicleStyle;
    }

    public String getVehicleSize() {
        return vehicleSize;
    }

    public void setVehicleSize(String vehicleSize) {
        this.vehicleSize = vehicleSize;
    }

    public String getPrimaryBodyType() {
        return primaryBodyType;
    }

    public void setPrimaryBodyType(String primaryBodyType) {
        this.primaryBodyType = primaryBodyType;
    }

    public String getMarket() {
        return market;
    }

    public void setMarket(String market) {
        this.market = market;
    }

    public String getEPAClass() {
        return EPAClass;
    }

    public void setEPAClass(String EPAClass) {
        this.EPAClass = EPAClass;
    }

    private String vehicleType;
}
