package company.amazon.ood2;

import java.util.HashMap;
import java.util.Map;

public class ParkingLotSystem {
    enum VehicleSize {
        LARGE, MEDIUM, SMALL
    }

    abstract class Vehicle {
        private String id;
        private VehicleSize size;

        public Vehicle(String id) {
            this.id = id;
        }

        public Vehicle(String id, VehicleSize size) {
            this.id = id;
            this.size = size;
        }
    }

    class LargeVehicle extends Vehicle {
        public LargeVehicle(String id) {
            super(id, VehicleSize.LARGE);
        }
    }

    class MediumVehicle extends Vehicle {
        public MediumVehicle(String id) {
            super(id, VehicleSize.MEDIUM);
        }
    }

    class SmallVehicle extends Vehicle {
        public SmallVehicle(String id) {
            super(id, VehicleSize.SMALL);
        }
    }

    class Location {
        int level;
        int row;
        int col;
    }

    class ParkingSlot {
        Location location;
        String slotId;
        Vehicle vehicle;
        VehicleSize size;

        boolean isEmpty() {
            return this.vehicle == null;
        }

        boolean canFitVehicle(Vehicle vehicle) {
            if (!isEmpty()) return false;
            switch (vehicle.size) {
                case LARGE:
                    return this.size == VehicleSize.LARGE;
                case MEDIUM:
                    return this.size == VehicleSize.LARGE || this.size == VehicleSize.MEDIUM;
                default:
                    return true;
            }
        }

        boolean assignVehicle(Vehicle vehicle) {
            if (!canFitVehicle(vehicle)) return false;
            this.vehicle = vehicle;
            return true;
        }

        void removeVehicle(Vehicle vehicle) {
            this.vehicle = null;
        }
    }

    class Parking {
        Vehicle vehicle;
        ParkingSlot slot;

        public Parking(Vehicle vehicle, ParkingSlot slot) {
            this.vehicle = vehicle;
            this.slot = slot;
        }
    }

    class ParkingLot {
        Map<String, ParkingSlot> emptySlots = new HashMap<>();
        Map<String, ParkingSlot> fullSlots = new HashMap<>();
        Map<String, Parking> parkingMap = new HashMap<>();

        public ParkingSlot findParkingSlot(Vehicle vehicle) {
            if (emptySlots.isEmpty()) return null;
            for (String slotId : emptySlots.keySet()) {
                ParkingSlot slot = emptySlots.get(slotId);
                if (slot.canFitVehicle(vehicle)) return slot;
            }
            return null;
        }

        public void assignVehicle(ParkingSlot slot, Vehicle vehicle) {
            String slotId = slot.slotId;
            slot.assignVehicle(vehicle);
            emptySlots.remove(slotId);
            fullSlots.put(slotId, slot);
            parkingMap.put(vehicle.id, new Parking(vehicle, slot));
        }

        public void removeVehicle(String vehicleId) {
            Parking parking = parkingMap.get(vehicleId);
            ParkingSlot slot = parking.slot;
            Vehicle vehicle = parking.vehicle;
            slot.removeVehicle(vehicle);
            fullSlots.remove(slot.slotId);
            emptySlots.put(slot.slotId, slot);
            parkingMap.remove(vehicleId);
        }
    }
}
