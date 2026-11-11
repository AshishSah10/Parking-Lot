package services;

import enums.SlotStatus;
import enums.Type;
import models.*;
import repositories.BillRepository;
import repositories.SlotRepository;
import repositories.TicketRepository;
import repositories.VehicleRepository;

import java.util.*;

public class ParkingLotService {
    private  ParkingLot parkingLot;
    private FloorService floorService;
    private SlotAssignmentStrategy slotAssignmentStrategy;
    private TicketService ticketService;
    private SlotRepository slotRepository;
    private VehicleRepository vehicleRepository;
    private BillService billService;
    private TicketRepository ticketRepository;
    private BillRepository billRepository;

    // Add floor to the parking lot
    public void addFloor(Floor floor) {
        this.parkingLot.getFloors().add(floor);
    }


    // remove floor from top
    public void removeFloors(){
        this.parkingLot.getFloors().removeLast();
    }




//    create the parking lot.

//    Add a parking lot slot to any of the floors.
    public void addSlot(Slot slot, Floor floor){
        this.floorService.addSlot(slot, floor);
    }


    // Given a vehicle, it finds the first available slot, books it, creates a ticket, parks the vehicle, and finally returns the ticket.
    public Ticket parkVehicle(Vehicle vehicle){
        Slot slot = slotAssignmentStrategy.assignSlot(vehicle);
        Type vehicleType = vehicle.getVehicleType();
        if(slot == null){
            System.out.println("No Vacant slot of type "+vehicleType+" is available.");
            return null;
        }

        Ticket ticket = ticketService.generateTicket(slot, vehicle);
        slotRepository.save(slot);
        vehicleRepository.save(vehicle);

        return ticket;
    }


//    Unparks a vehicle given the ticket id.
    public Bill unparkVehicle(Ticket ticket){
        Optional<Slot> slotOptional = slotRepository.findById(ticket.getSlotId());
        if(slotOptional.isEmpty()){
            return null;
        }
        Slot slot = slotOptional.get();

        Optional<Vehicle> vehicleOptional = vehicleRepository.findById(ticket.getVehicleId());
        if(vehicleOptional.isEmpty()){
            return null;
        }
        Vehicle vehicle = vehicleOptional.get();
        if(!Objects.equals(slot.getVehicleId(), vehicle.getId())){
            return null;
        }

        Bill bill = billService.generateBill(ticket, slot);

        slot.setStatus(SlotStatus.VACANT);
        slot.setVehicleId(null);
        slotRepository.save(slot);
        vehicleRepository.deleteById(vehicle.getId());

        return bill;
    }

    // Displays the number of free slots per floor for a specific vehicle type.
    public Map<Floor, Integer> getCountOfFreeSlotsOnEachFloor(Type vehicleType){
        Map<Floor, Integer> floorSlotMap = new HashMap<>();
        List<Floor> floors = parkingLot.getFloors();
        for(Floor floor : floors){
            floorSlotMap.put(floor, floorService.getNoOfVacantSlots(floor, vehicleType));
        }

        return floorSlotMap;
    }

    //  Displays all the free slots per floor for a specific vehicle type.
    public Map<Floor, List<Slot>> getFreeSlotsOnEachFloor(Type vehicleType){
        Map<Floor, List<Slot>> floorSlotMap = new HashMap<>();
        List<Floor> floors = parkingLot.getFloors();
        for(Floor floor : floors){
            floorSlotMap.put(floor, floorService.getVacantSlots(floor, vehicleType));
        }
        return floorSlotMap;
    }

    // Displays all the occupied slots per floor for a specific vehicle type.
    public Map<Floor, List<Slot>> getOccupiedSlotsOnEachFloor(Type vehicleType){
        Map<Floor, List<Slot>> floorSlotMap = new HashMap<>();
        List<Floor> floors = parkingLot.getFloors();
        for(Floor floor : floors){
            floorSlotMap.put(floor, floorService.getOccupiedSlots(floor, vehicleType));
        }
        return floorSlotMap;
    }
}
