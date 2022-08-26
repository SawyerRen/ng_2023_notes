package company.amazon.ood;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

enum VehicleSize {
    SMALL,
    MEDIUM,
    LARGE,
}

class ParkingTicket {
    String number;

    public ParkingTicket(ParkingSpot spot, Vehicle vehicle) {
        this.number = spot.getId() + "_" + vehicle.getId();
    }
}

abstract class Vehicle {
    protected VehicleSize size;
    private String id;
    private ParkingTicket ticket;

    public String getId() {
        return id;
    }

    public Vehicle(VehicleSize size) {
        this.size = size;
    }

    public VehicleSize getSize() {
        return size;
    }

    public void assignTicket(ParkingTicket parkingTicket) {
        this.ticket = parkingTicket;
    }

    abstract public boolean canFitInSpot(ParkingSpot spot);
}

class LargeVehicle extends Vehicle {
    public LargeVehicle() {
        super(VehicleSize.LARGE);
    }

    @Override
    public boolean canFitInSpot(ParkingSpot spot) {
        return spot.getSize() == VehicleSize.LARGE;
    }
}

class MediumVehicle extends Vehicle {
    public MediumVehicle() {
        super(VehicleSize.MEDIUM);
    }

    @Override
    public boolean canFitInSpot(ParkingSpot spot) {
        return spot.getSize() == VehicleSize.LARGE || spot.getSize() == VehicleSize.MEDIUM;
    }
}

class SmallVehicle extends Vehicle {
    public SmallVehicle() {
        super(VehicleSize.SMALL);
    }

    @Override
    public boolean canFitInSpot(ParkingSpot spot) {
        return true;
    }
}

abstract class ParkingSpot {
    private Vehicle vehicle;
    private VehicleSize size;
    private String id;

    public ParkingSpot(VehicleSize size, String id) {
        this.size = size;
        this.id = id;
    }

    public VehicleSize getSize() {
        return size;
    }

    boolean isVacant() {
        return this.vehicle == null;
    }

    boolean canFitVehicle(Vehicle vehicle) {
        return isVacant() && vehicle.canFitInSpot(this);
    }

    boolean assignVehicle(Vehicle vehicle) {
        if (!canFitVehicle(vehicle)) return false;
        this.vehicle = vehicle;
        return true;
    }

    void removeVehicle() {
        this.vehicle = null;
    }

    public String getId() {
        return id;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }
}

public class ParkingLot {
    private Map<String, ParkingSpot> parkingSpotMap = new HashMap<>();
    private Map<String, ParkingSpot> fullLargeParkingSpotMap = new HashMap<>();
    private Map<String, ParkingSpot> vacantLargeParkingSpotMap = new HashMap<>();
    private Map<String, ParkingSpot> fullMediumParkingSpotMap = new HashMap<>();
    private Map<String, ParkingSpot> vacantMediumParkingSpotMap = new HashMap<>();
    private Map<String, ParkingSpot> fullSmallParkingSpotMap = new HashMap<>();
    private Map<String, ParkingSpot> vacantSmallParkingSpotMap = new HashMap<>();
    Set<ParkingTicket> ticketSet = new HashSet<>();

    public boolean assignVehicle(Vehicle vehicle) {
        ParkingSpot parkingSpot = findParkingSpot(vehicle);
        if (parkingSpot == null) return false;
        assignVehicleToSpot(parkingSpot, vehicle);
        return true;
    }

    private void assignVehicleToSpot(ParkingSpot parkingSpot, Vehicle vehicle) {
        ParkingTicket ticket = new ParkingTicket(parkingSpot, vehicle);
        ticketSet.add(ticket);
        parkingSpot.assignVehicle(vehicle);
        vehicle.assignTicket(ticket);
        if (parkingSpot.getSize() == VehicleSize.LARGE) {
            vacantLargeParkingSpotMap.remove(parkingSpot.getId());
            fullLargeParkingSpotMap.put(parkingSpot.getId(), parkingSpot);
        } else if (parkingSpot.getSize() == VehicleSize.MEDIUM) {
            vacantMediumParkingSpotMap.remove(parkingSpot.getId());
            fullMediumParkingSpotMap.put(parkingSpot.getId(), parkingSpot);
        } else {
            vacantSmallParkingSpotMap.remove(parkingSpot.getId());
            fullSmallParkingSpotMap.put(parkingSpot.getId(), parkingSpot);
        }
    }

    private ParkingSpot findParkingSpot(Vehicle vehicle) {
        if (vehicle.getSize() == VehicleSize.LARGE) {
            if (vacantLargeParkingSpotMap.isEmpty()) return null;
            for (String id : vacantLargeParkingSpotMap.keySet()) {
                return vacantLargeParkingSpotMap.get(id);
            }
        } else if (vehicle.getSize() == VehicleSize.MEDIUM) {
            if (vacantLargeParkingSpotMap.isEmpty() && vacantMediumParkingSpotMap.isEmpty()) return null;
            for (String id : vacantMediumParkingSpotMap.keySet()) {
                return vacantMediumParkingSpotMap.get(id);
            }
            for (String id : vacantLargeParkingSpotMap.keySet()) {
                return vacantLargeParkingSpotMap.get(id);
            }
        } else {
            if (vacantLargeParkingSpotMap.isEmpty() && vacantMediumParkingSpotMap.isEmpty()
                    && vacantSmallParkingSpotMap.isEmpty()) return null;
            for (String id : vacantMediumParkingSpotMap.keySet()) {
                return vacantMediumParkingSpotMap.get(id);
            }
            for (String id : vacantLargeParkingSpotMap.keySet()) {
                return vacantLargeParkingSpotMap.get(id);
            }
            for (String id : vacantSmallParkingSpotMap.keySet()) {
                return vacantSmallParkingSpotMap.get(id);
            }
        }
        return null;
    }

    public Vehicle removeVehicle(ParkingTicket ticket) {
        if (!ticketSet.contains(ticket)) return null;
        String parkingSpotId = ticket.number.split("_")[0];
        String vehicleId = ticket.number.split("_")[1];
        ParkingSpot parkingSpot = parkingSpotMap.get(parkingSpotId);
        Vehicle vehicle = parkingSpot.getVehicle();
        parkingSpot.removeVehicle();
        return vehicle;
    }
}
