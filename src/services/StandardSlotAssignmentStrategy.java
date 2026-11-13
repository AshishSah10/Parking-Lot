package services;

import enums.SlotStatus;
import models.Floor;
import models.Slot;
import models.Vehicle;

import java.util.List;

// Standard slot assignment strategy:
// The slot should be of the same type as the vehicle.
// The slot should be on the lowest possible floor in the parking lot.
// The slot should have the lowest possible slot number on the floor.
public class StandardSlotAssignmentStrategy implements SlotAssignmentStrategy{
    private ParkingLotService parkingLotService;
    private FloorService floorService;
    private SlotService slotService;

    @Override
    public Slot assignSlot(Vehicle vehicle) {
        List<Floor> floors = this.parkingLotService.getParkingLot().getFloors();

        for(Floor floor : floors){
            Slot slot = this.floorService.getFirstVacantSlot(vehicle.getVehicleType(), floor);
            if(slot != null){
                slot.setVehicleId(vehicle.getId());
                slot.setStatus(SlotStatus.OCCUPIED);
                return slotService.saveSlot(slot);
            }
        }
        return null;
    }
}
