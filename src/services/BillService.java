package services;

import enums.PaymentStatus;
import enums.SlotStatus;
import models.Bill;
import models.Slot;
import models.Ticket;
import models.Vehicle;
import repositories.BillRepository;
import repositories.SlotRepository;
import repositories.VehicleRepository;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.Optional;

public class BillService {
    private SlotRepository slotRepository;
    private VehicleRepository vehicleRepository;
    private FeeCalculationStrategy feeCalculationStrategy;
    private BillRepository billRepository;

    public Bill generateBill(Ticket ticket, Slot slot){

        LocalDateTime exitTime = LocalDateTime.now();
        Duration duration = Duration.between(exitTime, ticket.getInTime());
        double amount = feeCalculationStrategy.calculateFees(duration, slot.getSlotType());
        Bill bill = new Bill(ticket.getId(), exitTime, duration, amount, PaymentStatus.UNPAID);
        billRepository.save(bill);
        return bill;

    }
}
