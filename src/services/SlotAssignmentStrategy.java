package services;

import models.Slot;
import models.Vehicle;

public interface SlotAssignmentStrategy {
    Slot assignSlot(Vehicle vehicle);
}
