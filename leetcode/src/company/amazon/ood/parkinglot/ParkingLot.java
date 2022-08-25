package company.amazon.ood.parkinglot;

import java.util.HashMap;
import java.util.Map;

enum VehicleType {
    CAR,
    TRUCK,
    ELECTRIC,
    VAN,
    MOTORBIKE
}

enum ParkingTicketStatus {
    ACTIVE,
    PAID,
    LOST
}

class Address {
    String streetAddress;
    String city;
    String state;
    String zipCode;
    String country;
}

class Person {
    String name;
    Address address;
    String email;
    String phone;
}

abstract class Account {
    String userName;
    String password;
    Person person;
}

class ParkingSlot {
    boolean isVacant;
    Vehicle vehicle;
    ParkingType parkingType;
    int id;

    void assignVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
        isVacant = false;
    }

    void removeVehicle(Vehicle vehicle) {
        this.vehicle = null;
        isVacant = true;
    }
}

class Vehicle {
    int id;
    VehicleType vehicleType;

    public Vehicle(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }
}

class Car extends Vehicle {
    public Car() {
        super(VehicleType.CAR);
    }
}

class Van extends Vehicle {
    public Van() {
        super(VehicleType.VAN);
    }
}

class Truck extends Vehicle {
    public Truck() {
        super(VehicleType.TRUCK);
    }
}

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
                slot.assignVehicle(vehicle);
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
        slot.removeVehicle(vehicle);
        fullSlots.remove(slot.id);
        vacantSlots.put(slot.id, slot);
        if (vacantSlots.size() == this.slotCount) {
            isEmpty = true;
        }
        isFull = false;
    }
}


enum ParkingType {
    REGULAR,
    HANDICAPPED,
    COMPACT,
    MAX_PARKING_TYPE,
}