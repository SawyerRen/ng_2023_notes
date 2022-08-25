package company.amazon.ood.moviebookingsystem;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

public class TicketBookingSystem {
    enum BookingStatus {
        REQUESTED,
        PENDING,
        CONFIRMED,
        CHECKED_IN, CANCELED, ABONDENDED
    }

    enum PaymentStatus {
        UNPAID,
        PENDING,
        COMPLETED,
        FILLED, DECLINED, CANCELED, ABONDENED, SETTLING, SETTLED, REFUNDED
    }

    class Address {
    }

    class Account {
        private String id;
        private String password;
        private String name;
        private Address address;
        private String email;
        private String phone;

        public boolean makeBooking(Booking booking) {
            return true;
        }

        public List<Booking> getBookings() {
            return new ArrayList<>();
        }
    }

    class Movie {
        private String title;
        private String description;
        private int durationInMins;
        private String language;
        private Date releaseDate;
        private String country;
        private String genre;
        private List<Show> shows;

        public List<Show> getShows() {
            return shows;
        }
    }

    class Show {
        int id;
        Date createdAt;
        Date startTime;
        Date endTime;
        Address theatre;
        Movie movie;
    }

    class Booking {
        int id;
        int numberOfSeats;
        int status;
        Show show;
        List<Seat> seats;
    }

    class Seat {
        int row;
        int id;
        Address theatre;
        boolean isReserved;
    }

    interface Search {
        public List<Movie> searchByTitle(String title);

        public List<Movie> searchByLanguage(String language);

        public List<Movie> searchByGenre(String genre);

        public List<Movie> searchByRekeaseDate(Date delDate);

        public List<Movie> searchByCity(String cityName);
    }

    class Catalog implements Search {
        HashMap<String, List<Movie>> movieTitles;
        HashMap<String, List<Movie>> movieLanguages;
        HashMap<String, List<Movie>> movieGenres;
        HashMap<Date, List<Movie>> movieReleaseDates;
        HashMap<String, List<Movie>> movieCities;

        public List<Movie> searchByTitle(String title) {
            return movieTitles.get(title);
        }

        public List<Movie> searchByLanguage(String language) {
            return movieLanguages.get(language);
        }

        @Override
        public List<Movie> searchByGenre(String genre) {
            return null;
        }

        @Override
        public List<Movie> searchByRekeaseDate(Date delDate) {
            return null;
        }

        @Override
        public List<Movie> searchByCity(String cityName) {
            return null;
        }
    }
}