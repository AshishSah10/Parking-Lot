package services;

import enums.Type;
import models.Slot;
import models.Ticket;
import models.Vehicle;
import repositories.SlotRepository;
import repositories.VehicleRepository;

public class VehicleService {
    private SlotAssignmentStrategy slotAssignmentStrategy;
    private TicketService ticketService;
    private SlotRepository slotRepository;
    private VehicleRepository vehicleRepository;
    private SlotService slotService;

    // Given a vehicle, it finds the first available slot, books it, creates a ticket, parks the vehicle, and finally returns the ticket.
    public Ticket parkVehicle(Vehicle vehicle){
        Slot slot = slotService.assignSlot(vehicle);
        Type vehicleType = vehicle.getVehicleType();
        if(slot == null){
            System.out.println("No Vacant slot of type "+vehicleType+" is available.");
            return null;
        }

        Ticket ticket = ticketService.generateTicket(slot, vehicle);
        vehicleRepository.save(vehicle);
        return ticket;
    }
}
