package models;

import enums.Type;

import java.util.Date;

public class Vehicle extends BaseEntity{
    final private String regNo;

    final private Type vehicleType;
    private String color;

    public Vehicle(String regNo, Type vehicleType, String color) {
        this.regNo = regNo;
        this.vehicleType = vehicleType;
        this.color = color;
    }

    public String getRegNo() {
        return regNo;
    }

    public Type getVehicleType() {
        return vehicleType;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
