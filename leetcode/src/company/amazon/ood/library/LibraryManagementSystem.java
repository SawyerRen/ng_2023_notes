package company.amazon.ood.library;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

enum BookFormat {
    HARDCOVER, PAPERBACK, AUDIO_BOOK, EBOOK, NEWSPAPER, MAGAZINE, JOURNAL
}

enum BookStatus {
    AVAILABLE, RESERVED, LOANED, LOST
}

enum ReservationStatus {
    WAITING, PENDING, CANCELED, COMPLETED, NONE
}

enum AccountStatus {
    ACTIVE, CLOSED, CANCELED, BLACKLISTED, NONE
}

class Address {
    String streetAddress;
    String city;
    String state;
    String zipcode;
    String country;
}

class Person {
    String name;
    Address address;
    String email;
    String phone;
}

class Constants {
    public static final int MAX_BOOKS_ISSUED_TO_A_USER = 5;
    public static final int MAX_LENDING_DAYS = 10;
}

abstract class Account {
    int id;
    String pwd;
    AccountStatus status;
    Person person;

    void resetPassword() {

    }
}

class Librarian extends Account {
    void addBookItem(BookItem bookItem) {
    }
}

class Member extends Account {
    Date membershipDate;
    int totalBooksCheckout;

    public int getTotalBooksCheckout() {
        return totalBooksCheckout;
    }

    void reserveBookItem(BookItem bookItem) {
    }

    void renewBookItem(BookItem bookItem) {
    }

    boolean checkOutBookItem(BookItem bookItem) {
        if (this.totalBooksCheckout >= Constants.MAX_BOOKS_ISSUED_TO_A_USER) {
            return false;
        }
        BookReservation bookReservation = BookReservation.fetchReservationDetails(bookItem.barcode);
        if (bookReservation != null && bookReservation.memberId != this.id) {
            return false;
        } else if (bookReservation != null) {
            bookReservation.updateStatus(ReservationStatus.COMPLETED);
        }
        if (!bookItem.checkout(this.id)) return false;
        this.totalBooksCheckout++;
        return true;
    }

    public void returnBookItem(BookItem bookItem) {
        BookReservation bookReservation =
                BookReservation.fetchReservationDetails(bookItem.barcode);
        if (bookReservation != null) {
            bookItem.updateBookItemStatus(BookStatus.RESERVED);
            bookReservation.sendBookAvailableNotification();
        }
        bookItem.updateBookItemStatus(BookStatus.AVAILABLE);
    }
}

class Book {
    String ISBN;
    String title;
    String publisher;
    String[] authors;
}

class BookItem extends Book {
    String barcode;
    boolean borrowed;
    BookStatus status;
    BookFormat format;

    boolean checkout(int memberId) {
        return true;
    }

    public void updateBookItemStatus(BookStatus status) {

    }
}

class BookReservation {
    Date creationDate;
    ReservationStatus status;
    String bookItemBarcode;
    int memberId;

    public static BookReservation fetchReservationDetails(String barcode) {
        return null;
    }

    public void updateStatus(ReservationStatus status) {

    }

    public void sendBookAvailableNotification() {
    }
}

class BookLending {
    Date creationDate;
    Date dueDate;
    Date returnDate;
    String bookItemBarcode;
    int memberId;

    boolean lendBook(String barCode, int memberId) {
        return true;
    }

    public static BookLending fetchLendingDetails(String barcode) {
        return null;
    }
}

class Fine {
    Date creationDate;
    String bookItemBarcode;
    int memberId;
}

interface Search {
    public List<Book> searchByTitle(String title);

    public List<Book> searchByAuthor(String author);

    public List<Book> searchBySubject(String subject);

    public List<Book> searchByPubDate(Date publishDate);
}

class Catalog implements Search {
    private HashMap<String, List<Book>> bookTitles;
    private HashMap<String, List<Book>> bookAuthors;
    private HashMap<String, List<Book>> bookSubjects;
    private HashMap<String, List<Book>> bookPublicationDates;

    public List<Book> searchByTitle(String query) {
// return all books containing the string query in their title.
        return bookTitles.get(query);
    }

    public List<Book> searchByAuthor(String query) {
// return all books containing the string query in their author's name.
        return bookAuthors.get(query);
    }

    @Override
    public List<Book> searchBySubject(String subject) {
        return null;
    }

    @Override
    public List<Book> searchByPubDate(Date publishDate) {
        return null;
    }
}

public class LibraryManagementSystem {

}
