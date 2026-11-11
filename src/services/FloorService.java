package services;

import enums.SlotStatus;
import enums.Type;
import models.Floor;
import models.Slot;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FloorService {

    // Get the 1st vacant slot of this floor of given type
    public Slot getFirstVacantSlot(Type type, Floor floor){
        List<Slot> slots = floor.getSlots();
        for(Slot slot : slots){
            if(slot.getStatus() == SlotStatus.VACANT && slot.getSlotType() == type){
                return slot;
            }
        }
        return null;
    }

    // Add a slot to the floor.
    public void addSlot(Slot slot, Floor floor){
        floor.getSlots().add(slot);
    }

    // Get count of vacant slots for given floor and vehicle type.
    public int getNoOfVacantSlots(Floor floor, Type vehicleType){
        List<Slot> slots = floor.getSlots();
        int count = 0;
        for(Slot slot : slots){
            if(slot.getStatus() == SlotStatus.VACANT && slot.getSlotType().equals(vehicleType)){
                count++;
            }
        }
        return count;
    }

    // Get List of Vacant slots for given floor and vehicle type.
    public List<Slot> getVacantSlots(Floor floor, Type vehicleType){
        List<Slot> slots = floor.getSlots();
        List<Slot> vacantSlots = new ArrayList<>();
        for(Slot slot : slots){
            if(slot.getStatus() == SlotStatus.VACANT && slot.getSlotType().equals(vehicleType)){
                vacantSlots.add(slot);
            }
        }
        return vacantSlots;
    }

    // Get List of Occupied slots for given floor and vehicle type.
    public List<Slot> getOccupiedSlots(Floor floor, Type vehicleType){
        List<Slot> slots = floor.getSlots();
        List<Slot> occupiedSlots = new ArrayList<>();
        for(Slot slot : slots){
            if(slot.getStatus() == SlotStatus.OCCUPIED && slot.getSlotType().equals(vehicleType)){
                occupiedSlots.add(slot);
            }
        }
        return occupiedSlots;
    }
}
