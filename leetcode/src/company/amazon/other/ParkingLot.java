package company.amazon.other;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Design an OO parking lot. What classes and functions will it have. It should say, full,
 * empty and also be able to find spot for Valet parking. The lot has 3 different types of
 * parking: regular, handicapped and compact.
 */
public class ParkingLot {
    Map<Integer, ParkingSlot> vacantSlots = new HashMap<>();
    Map<Integer, ParkingSlot> fullSlots = new HashMap<>();
    Map<Vehicle, ParkingSlot> vehicleParkingSlotMap = new HashMap<>();

    int slotCount = 0;

    boolean isEmpty;
    boolean isFull;

    ParkingSlot findVacantSlot(ParkingType type) {
        for (ParkingSlot vacantSlot : vacantSlots.values()) {
            if (vacantSlot.parkingType == type) {
                return vacantSlot;
            }
        }
        return null;
    }

    void parkVehicle(ParkingType type, Vehicle vehicle) {
        if (!isFull) {
            ParkingSlot slot = findVacantSlot(type);
            if (slot != null) {
                slot.vehicle = vehicle;
                slot.isVacant = false;
                vacantSlots.remove(slot.id);
                fullSlots.put(slot.id, slot);
                if (fullSlots.size() == this.slotCount) {
                    isFull = true;
                }
                isEmpty = false;
            }
        }
    }

    void releaseVehicle(Vehicle vehicle) {
        ParkingSlot slot = vehicleParkingSlotMap.get(vehicle);
        slot.vehicle = null;
        slot.isVacant = true;
        fullSlots.remove(slot.id);
        vacantSlots.put(slot.id, slot);
        if (vacantSlots.size() == this.slotCount) {
            isEmpty = true;
        }
        isFull = false;
    }
}

class ParkingSlot {
    boolean isVacant;
    Vehicle vehicle;
    ParkingType parkingType;
    int distance;
    int id;
}

class Vehicle {
    int num;
}

enum ParkingType {
    REGULAR,
    HANDICAPPED,
    COMPACT,
    MAX_PARKING_TYPE,
}