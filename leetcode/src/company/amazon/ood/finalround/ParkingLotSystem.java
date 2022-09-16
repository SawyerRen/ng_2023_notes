package company.amazon.ood.finalround;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ParkingLotSystem {
    enum VehicleSize {
        SMALL, MEDIUM, LARGE
    }

    enum ParkingSlotSize {
        SMALL, MEDIUM, LARGE
    }

    abstract class Vehicle {
        String id;
        VehicleSize size;

        public Vehicle(String id, VehicleSize size) {
            this.id = id;
            this.size = size;
        }
    }

    class Location {
        int floor;
        int row;
        int col;

        public Location(int floor, int row, int col) {
            this.floor = floor;
            this.row = row;
            this.col = col;
        }
    }

    class ParkingSlot {
        String id;
        Location location;
        Vehicle vehicle;
        ParkingSlotSize size;

        public ParkingSlot(String id, Location location, ParkingSlotSize size) {
            this.id = id;
            this.location = location;
            this.size = size;
        }

        boolean canFitVehicle(Vehicle v) {
            return true;
        }

        boolean isEmpty() {
            return vehicle == null;
        }

        boolean assignVehicle(Vehicle vehicle) {
            if (!canFitVehicle(vehicle)) return false;
            this.vehicle = vehicle;
            return true;
        }
    }

    class Parking {
        ParkingSlot slot;
        Vehicle vehicle;
    }

    class ParkingLot {
        Map<String, ParkingSlot> fullMap = new HashMap<>();
        Map<String, ParkingSlot> emptyMap = new HashMap<>();
        Set<Parking> parkingSet = new HashSet<>();

        ParkingSlot findSlot(Vehicle vehicle) {
            return null;
        }

        boolean assignVehicle(Vehicle vehicle, ParkingSlot slot) {
            return true;
        }

        void removeVehicle(Parking parking) {
        }
    }
}
