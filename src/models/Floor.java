package models;

import java.util.List;

public class Floor extends BaseEntity{
    int number;

    List<Slot> slots;

    public Floor(int number) {
        this.number = number;
    }

    public Floor(int number, List<Slot> slots) {
        this.number = number;
        this.slots = slots;
    }

    public int getNumber() {
        return number;
    }

    public List<Slot> getSlots() {
        return slots;
    }

    public void setSlots(List<Slot> slots) {
        this.slots = slots;
    }
}
