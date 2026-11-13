package services;

import models.Slot;
import models.Vehicle;
import repositories.SlotRepository;

public class SlotService {
    private SlotAssignmentStrategy slotAssignmentStrategy;
    private SlotRepository slotRepository;

    public Slot saveSlot(Slot slot){
        return slotRepository.save(slot);
    }

    public Slot assignSlot(Vehicle vehicle){
        Slot slot = slotAssignmentStrategy.assignSlot(vehicle);
    }
}
