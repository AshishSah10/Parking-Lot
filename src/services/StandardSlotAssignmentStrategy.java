package services;

import enums.SlotStatus;
import models.Floor;
import models.ParkingLot;
import models.Slot;
import models.Vehicle;

import java.util.List;

// Standard slot assignment strategy:
// The slot should be of the same type as the vehicle.
// The slot should be on the lowest possible floor in the parking lot.
// The slot should have the lowest possible slot number on the floor.
public class StandardSlotAssignmentStrategy implements SlotAssignmentStrategy{
    private ParkingLot parkingLot;
    private FloorService floorService;

    @Override
    public Slot assignSlot(Vehicle vehicle) {
        List<Floor> floors = this.parkingLot.getFloors();

        for(Floor floor : floors){
            Slot slot = this.floorService.getFirstVacantSlot(vehicle.getVehicleType(), floor);
            if(slot != null){
                slot.setVehicleId(vehicle.getId());
                slot.setStatus(SlotStatus.OCCUPIED);
                return slot;
            }
        }
        return null;
    }
}
