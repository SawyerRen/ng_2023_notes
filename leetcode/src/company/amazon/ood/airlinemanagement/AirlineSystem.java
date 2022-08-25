package company.amazon.ood.airlinemanagement;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class AirlineSystem {
    class Address {
    }

    class Account {
        int id;
        String password;
    }

    class User {
        private String name;
        private Address address;
        private String email;
        private String phone;
        private Account account;
        private String passportNumber;
        private Date dateOfBirth;
    }

    class Airport {
        Address address;
        String name;
        String code;

        List<Flight> getFlights() {
            return new ArrayList<>();
        }
    }

    class Aircraft {
        String name;
        String model;
        int manufactureYear;
        Map<Integer, Seat> seats;
    }

    class Seat {
        int id;
        String type;
        int seatClass;
    }

    class Flight {
        int id;
        Address depature;
        Address destination;
        int duration;
        int gate;
        int status;
        Aircraft aircraft;
    }

    class FlightReservation {
        int id;
        Flight flight;
        Map<Integer, Seat> seatMap;
        int status;
        Map<Integer, User> userMap;
    }

    class Itinerary {
        int customerId;
    }
}
