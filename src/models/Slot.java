package models;

import enums.SlotStatus;
import enums.Type;

public class Slot extends BaseEntity{
    // <floorNo>_<slotNo>
    final private String slotName;
    final private Long floorId;
    final private Type slotType;
    private SlotStatus status;
    private Long vehicleId;

    public Slot(String slotName, Long floorId, Type slotType, Long vehicleId){
        this.slotName = slotName;
        this.floorId = floorId;
        this.slotType = slotType;
        this.vehicleId = vehicleId;
        this.status = SlotStatus.VACANT;
    }

    public String getSlotName() {
        return slotName;
    }


    public Long getFloorId() {
        return floorId;
    }


    public Type getSlotType() {
        return slotType;
    }

    public SlotStatus getStatus() {
        return status;
    }

    public void setStatus(SlotStatus status) {
        this.status = status;
    }

    public Long getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(Long vehicleId) {
        this.vehicleId = vehicleId;
    }
}
