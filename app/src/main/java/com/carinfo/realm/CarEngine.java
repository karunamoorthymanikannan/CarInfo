package com.carinfo.realm;

import io.realm.RealmObject;

/**
 * Created by karunamoorthy on 9/6/16.
 */

public class CarEngine extends RealmObject {
    private String id;
    private String code;
    private String compressorType;
    private String configuration;
    private String equipmentType;
    private String fuelType;
    private String name;
    private String type;
    private int cylinder;
    private int displacement;
    private int horsepower;
    private int torque;
    private int totalValves;
    private float compressionRatio;
    private CarEngineRPM rpm;
    private CarEngineValue value;

    public CarEngineRPM getRpm() {
        return rpm;
    }

    public void setRpm(CarEngineRPM rpm) {
        this.rpm = rpm;
    }

    public CarEngineValue getValue() {
        return value;
    }

    public void setValue(CarEngineValue value) {
        this.value = value;
    }

    public float getSize() {
        return size;
    }

    public void setSize(float size) {
        this.size = size;
    }

    public float getCompressionRatio() {
        return compressionRatio;
    }

    public void setCompressionRatio(float compressionRatio) {
        this.compressionRatio = compressionRatio;
    }

    public int getTotalValves() {
        return totalValves;
    }

    public void setTotalValves(int totalValves) {
        this.totalValves = totalValves;
    }

    public int getTorque() {
        return torque;
    }

    public void setTorque(int torque) {
        this.torque = torque;
    }

    public int getHorsepower() {
        return horsepower;
    }

    public void setHorsepower(int horsepower) {
        this.horsepower = horsepower;
    }

    public int getDisplacement() {
        return displacement;
    }

    public void setDisplacement(int displacement) {
        this.displacement = displacement;
    }

    public int getCylinder() {
        return cylinder;
    }

    public void setCylinder(int cylinder) {
        this.cylinder = cylinder;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFuelType() {
        return fuelType;
    }

    public void setFuelType(String fuelType) {
        this.fuelType = fuelType;
    }

    public String getEquipmentType() {
        return equipmentType;
    }

    public void setEquipmentType(String equipmentType) {
        this.equipmentType = equipmentType;
    }

    public String getConfiguration() {
        return configuration;
    }

    public void setConfiguration(String configuration) {
        this.configuration = configuration;
    }

    public String getCompressorType() {
        return compressorType;
    }

    public void setCompressorType(String compressorType) {
        this.compressorType = compressorType;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    private float size;
}
