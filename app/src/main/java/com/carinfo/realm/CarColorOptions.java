package com.carinfo.realm;

import io.realm.RealmList;
import io.realm.RealmObject;

/**
 * Created by karunamoorthy on 9/6/16.
 */

public class CarColorOptions extends RealmObject {
    private String equipmentType;
    private String manufactureOptionCode;

    public String getEquipmentType() {
        return equipmentType;
    }

    public void setEquipmentType(String equipmentType) {
        this.equipmentType = equipmentType;
    }

    public String getManufactureOptionCode() {
        return manufactureOptionCode;
    }

    public void setManufactureOptionCode(String manufactureOptionCode) {
        this.manufactureOptionCode = manufactureOptionCode;
    }

    public String getManufactureOptionName() {
        return manufactureOptionName;
    }

    public void setManufactureOptionName(String manufactureOptionName) {
        this.manufactureOptionName = manufactureOptionName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CarColorChips getColorChips() {
        return colorChips;
    }

    public void setColorChips(CarColorChips colorChips) {
        this.colorChips = colorChips;
    }

    public RealmList<CarColorFabric> getFabricTypes() {
        return fabricTypes;
    }

    public void setFabricTypes(RealmList<CarColorFabric> fabricTypes) {
        this.fabricTypes = fabricTypes;
    }

    private String manufactureOptionName;
    private String id;
    private String name;
    private CarColorChips colorChips;
    private RealmList<CarColorFabric> fabricTypes;
}
