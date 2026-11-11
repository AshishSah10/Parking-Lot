package models;

import java.util.List;

public class ParkingLot extends BaseEntity{
    private final String name;

    private List<Floor> floors;

    public ParkingLot(String name, List<Floor> floors) {
        this.name = name;
        this.floors = floors;
    }

    public ParkingLot(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public List<Floor> getFloors() {
        return floors;
    }
}
