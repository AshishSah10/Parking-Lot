package models;

import java.time.LocalDateTime;
import java.util.Date;

public class Ticket extends BaseEntity{
    // <parking_lot_id>_<floor_no>_<slot_no>
    final private String ticketId;

    private LocalDateTime inTime;

    private Long slotId;
    private Long vehicleId;

    public Ticket(String ticketId, Long slotId, Long vehicleId, LocalDateTime inTime) {
        this.ticketId = ticketId;
        this.slotId = slotId;
        this.vehicleId = vehicleId;
        this.inTime = inTime;
    }

    public String getTicketId() {
        return ticketId;
    }

    public LocalDateTime getInTime() {
        return inTime;
    }

    public void setInTime(LocalDateTime inTime) {
        this.inTime = inTime;
    }

    public Long getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(Long vehicleId) {
        this.vehicleId = vehicleId;
    }

    public Long getSlotId() {
        return slotId;
    }

    public void setSlotId(Long slotId) {
        this.slotId = slotId;
    }
}
