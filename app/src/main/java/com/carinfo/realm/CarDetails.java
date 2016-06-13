package com.carinfo.realm;

import io.realm.RealmList;
import io.realm.RealmObject;

/**
 * Created by karunamoorthy on 9/6/16.
 */

public class CarDetails extends RealmObject {
    private Make make;
    private String drivenWheels;
    private String numOfDoors;
    private String name;
    private long id;
    private String styleId;
    private CarRatings carRatings;

    public CarRatings getCarRatings() {
        return carRatings;
    }

    public void setCarRatings(CarRatings carRatings) {
        this.carRatings = carRatings;
    }

    public String getStyleId() {
        return styleId;
    }

    public void setStyleId(String styleId) {
        this.styleId = styleId;
    }

    private String trim;
    private CarEngine engine;

    public Make getMake() {
        return make;
    }

    public void setMake(Make make) {
        this.make = make;
    }

    public String getDrivenWheels() {
        return drivenWheels;
    }

    public void setDrivenWheels(String drivenWheels) {
        this.drivenWheels = drivenWheels;
    }

    public String getNumOfDoors() {
        return numOfDoors;
    }

    public void setNumOfDoors(String numOfDoors) {
        this.numOfDoors = numOfDoors;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTrim() {
        return trim;
    }

    public void setTrim(String trim) {
        this.trim = trim;
    }

    public CarEngine getEngine() {
        return engine;
    }

    public void setEngine(CarEngine engine) {
        this.engine = engine;
    }

    public CarTransmission getTransmission() {
        return transmission;
    }

    public void setTransmission(CarTransmission transmission) {
        this.transmission = transmission;
    }

    public CarPrice getPrice() {
        return price;
    }

    public void setPrice(CarPrice price) {
        this.price = price;
    }

    public CarCategories getCategories() {
        return categories;
    }

    public void setCategories(CarCategories categories) {
        this.categories = categories;
    }

    public CarMakeYear getYear() {
        return year;
    }

    public void setYear(CarMakeYear year) {
        this.year = year;
    }

    public CarSubModel getSubmodel() {
        return submodel;
    }

    public void setSubmodel(CarSubModel submodel) {
        this.submodel = submodel;
    }

    public CarMPG getMPG() {
        return MPG;
    }

    public void setMPG(CarMPG MPG) {
        this.MPG = MPG;
    }

    public RealmList<RealmString> getStates() {
        return states;
    }

    public void setStates(RealmList<RealmString> states) {
        this.states = states;
    }

    public RealmList<RealmString> getSquishVins() {
        return squishVins;
    }

    public void setSquishVins(RealmList<RealmString> squishVins) {
        this.squishVins = squishVins;
    }

    public RealmList<CarColors> getColors() {
        return colors;
    }

    public void setColors(RealmList<CarColors> colors) {
        this.colors = colors;
    }

    private CarTransmission transmission;
    private CarPrice price;
    private CarCategories categories;
    private CarMakeYear year;
    private CarSubModel submodel;
    private CarMPG MPG;
    private RealmList<RealmString> states;
    private RealmList<RealmString> squishVins;
    private RealmList<CarColors> colors;
}
