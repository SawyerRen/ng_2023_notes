package company.amazon.ood.carrental;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

class Address {
    private String streetAddress;
    private String city;
    private String state;
    private String zipCode;
    private String country;
}

class Person {
    private String name;
    private Address address;
    private String email;
    private String phone;
}

class Account {
    private String id;
    private String password;
    private Person person;
}

class Member extends Account {
    int totalVehicle;

    List<VehicleReservation> getReservations() {
        return new ArrayList<>();
    }
}

abstract class Vehicle {
    String number;
    int capacity;
}

class VehicleReservation {
    private String reservationNumber;
    private Date creationDate;
    private Date dueDate;
    private Date returnDate;
    private String pickupLocationName;
    private String returnLocationName;
    private int customerID;
    private Vehicle vehicle;
}

public class CarRentalSystem {
}
