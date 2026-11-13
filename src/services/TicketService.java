package services;

import models.Slot;
import models.Ticket;
import models.Vehicle;
import repositories.TicketRepository;

import java.time.LocalDateTime;

public class TicketService {
    private String PARKINGLOTID = "PR1234";
    private TicketRepository ticketRepository;
    public Ticket generateTicket(Slot slot, Vehicle vehicle){
        Ticket ticket = new Ticket(PARKINGLOTID+"_"+slot.getSlotName(), slot.getId(), vehicle.getId(), LocalDateTime.now());
        return ticketRepository.save(ticket);
    }

    public boolean validateTicket(Ticket ticket){
        return true;
    }
}