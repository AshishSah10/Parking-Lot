package services;

import enums.SlotStatus;
import enums.Type;
import models.*;
import repositories.*;

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
    private FloorRepository floorRepository;
    private ParkingLotRepository parkingLotRepository;

    // Add floor to the parking lot
    public void addFloor(Floor floor) {
        this.parkingLot.getFloors().add(floor);
    }


    // remove floor from top
    public void removeFloors(){
        this.parkingLot.getFloors().removeLast();
    }

    public ParkingLot getParkingLot(){
        return this.parkingLot;
    }

    //    create the parking lot.
    public ParkingLot createParkingLot(String name, int noOfFloors, int noOfSlotPerFloor){
        List<Floor> floors = new ArrayList<>(noOfFloors);
        List<Slot> slots = new ArrayList<>(noOfSlotPerFloor);

        for(int i = 1; i <= noOfFloors; i++){
            Floor floor = new Floor(i);
            Long floorId = floorRepository.save(floor).getId();
            int j = 1;
            Slot slot = null;
            while(j <= 5){
                slot = new Slot(name+"_"+i+"_"+j, floorId, Type.TRUCK);
                slots.add(slot);
                slotRepository.save(slot);
                j++;
            }
            while(j > 5 && j <= 35){
                slot = new Slot(name+"_"+i+"_"+j, floorId, Type.BIKE);
                slots.add(slot);
                slotRepository.save(slot);
                j++;
            }
            while(j > 35 && j <= 50){
                slot = new Slot(name+"_"+i+"_"+j, floorId, Type.CAR);
                slots.add(slot);
                slotRepository.save(slot);
                j++;
            }
            floor.setSlots(slots);
            floors.add(floor);
            floorRepository.save(floor);
        }


        ParkingLot parkingLot = new ParkingLot(name, floors);
        return parkingLotRepository.save(parkingLot);
    }

    // Add a parking lot slot to any of the floors.
    public void addSlot(Slot slot, Floor floor){
        this.floorService.addSlot(slot, floor);
    }


//    // Given a vehicle, it finds the first available slot, books it, creates a ticket, parks the vehicle, and finally returns the ticket.
//    public Ticket parkVehicle(Vehicle vehicle){
//        Slot slot = slotAssignmentStrategy.assignSlot(vehicle);
//        Type vehicleType = vehicle.getVehicleType();
//        if(slot == null){
//            System.out.println("No Vacant slot of type "+vehicleType+" is available.");
//            return null;
//        }
//
//        Ticket ticket = ticketService.generateTicket(slot, vehicle);
//        slotRepository.save(slot);
//        vehicleRepository.save(vehicle);
//
//        return ticket;
//    }


    //  Unparks a vehicle given the ticket id.
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
    public Map<Floor, Integer> countFreeSlotsOnEachFloor(Type vehicleType){
        Map<Floor, Integer> floorSlotMap = new HashMap<>();
        List<Floor> floors = parkingLot.getFloors();
        for(Floor floor : floors){
            floorSlotMap.put(floor, floorService.getNoOfVacantSlots(floor, vehicleType));
        }

        return floorSlotMap;
    }

    //  Displays all the free slots per floor for a specific vehicle type.
    public Map<Floor, List<Slot>> getAllFreeSlotsOnEachFloor(Type vehicleType){
        Map<Floor, List<Slot>> floorSlotMap = new HashMap<>();
        List<Floor> floors = parkingLot.getFloors();
        for(Floor floor : floors){
            floorSlotMap.put(floor, floorService.getVacantSlots(floor, vehicleType));
        }
        return floorSlotMap;
    }

    // Displays all the occupied slots per floor for a specific vehicle type.
    public Map<Floor, List<Slot>> getAllOccupiedSlotsOnEachFloor(Type vehicleType){
        Map<Floor, List<Slot>> floorSlotMap = new HashMap<>();
        List<Floor> floors = parkingLot.getFloors();
        for(Floor floor : floors){
            floorSlotMap.put(floor, floorService.getOccupiedSlots(floor, vehicleType));
        }
        return floorSlotMap;
    }
}
