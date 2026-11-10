package models;

import java.util.List;

public class ParkingLot extends BaseEntity{
    String name;

    List<Floor> floors;

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

    // add floor at top
    public void addFloor(Floor floor) {
        this.floors.add(floor);
    }


    // remove floor from top
    public void removeFloors(){
        this.floors.removeLast();
    }
}
