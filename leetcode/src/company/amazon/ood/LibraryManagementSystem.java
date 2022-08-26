package company.amazon.ood;

import java.time.LocalDateTime;
import java.util.*;

class BookDetails {
    String title;
    String id;
    String authorName;
    LocalDateTime publicationDate;

    public BookDetails(String id, String authorName, LocalDateTime publicationDate) {
        this.id = id;
        this.authorName = authorName;
        this.publicationDate = publicationDate;
    }
}

class BookItem {
    String bookItemId;
    BookDetails bookDetail;

    public BookItem(String bookItemId, BookDetails bookDetail) {
        this.bookItemId = bookItemId;
        this.bookDetail = bookDetail;
    }
}

enum UserType {
    LIBRARIAN, MEMBER
}

class User {
    String barcode;
    String name;
    UserType userType;

    public User(String barcode, String name, UserType userType) {
        this.barcode = barcode;
        this.name = name;
        this.userType = userType;
    }
}

class UserRepository {
    Map<String, User> userMap = new HashMap<>();

    User getUserByBarCode(String barCode) {
        return userMap.get(barCode);
    }

    void addUser(User user) {
        userMap.put(user.barcode, user);
    }

    void removeUser(String barCode) {
        userMap.remove(barCode);
    }
}

class BookCatalog {
    Map<String, LinkedList<BookDetails>> titleBookMap = new HashMap<>();
    Map<String, LinkedList<BookDetails>> authorBookMap = new HashMap<>();
    Map<LocalDateTime, LinkedList<BookDetails>> publicationBookMap = new HashMap<>();
    Map<String, BookItem> bookItemMap = new HashMap<>();

    void addBookItem(BookItem bookItem) {
//        titleBookMap.putIfAbsent(bookItem.bookDetail.title, new LinkedList<>());
//        titleBookMap.get(bookItem.bookDetail.title).add(bookItem);
//        authorBookMap.putIfAbsent(bookItem.bookDetail.authorName, new LinkedList<>());
//        authorBookMap.get(bookItem.bookDetail.authorName).add(bookItem);
//        publicationBookMap.putIfAbsent(bookItem.bookDetail.publicationDate, new LinkedList<>());
//        publicationBookMap.get(bookItem.bookDetail.publicationDate).add(bookItem);
    }

    void removeBookItem(String bookItemID) {
        BookItem bookItem = bookItemMap.get(bookItemID);
        titleBookMap.get(bookItem.bookDetail.title).remove(bookItem);
    }

    List<BookDetails> searchByTitle(String title) {
        return titleBookMap.get(title);
    }

    List<BookDetails> searchByAuthor(String name) {
        return authorBookMap.get(name);
    }

    List<BookDetails> searchByPublicationDate(LocalDateTime publicationDate) {
        return publicationBookMap.get(publicationDate);
    }
}

interface LendingService {
    Map<User, List<BookItem>> borrowMap = new HashMap<>();

    List<BookItem> getCheckedOutBooks(User user);

    List<User> getLendingUsers(String bookID);

    int getOverdueFineAmount(User user);

    BookItem checkout(User user, String bookID);

    boolean renew(User user, BookItem bookItem);

    boolean returnBook(User user, BookItem bookItem);
}

public class LibraryManagementSystem {
    User user;
    UserRepository userRepository;
    BookCatalog bookCatalog;
    LendingService lendingService;

    void loginUser(String barcode) {
        this.user = userRepository.getUserByBarCode(barcode);
    }

    void userLogOut() {
        this.user = null;
    }

    List<BookDetails> searchByTitle(String title) {
        return bookCatalog.searchByTitle(title);
    }

    public List<BookDetails> searchByAuthor(String name) {
        return bookCatalog.searchByAuthor(name);
    }

    public List<BookDetails> searchByPublicationDate(LocalDateTime publicationDate) {
        return bookCatalog.searchByPublicationDate(publicationDate);
    }

    public List<BookItem> getCheckoutBooks() {
        return lendingService.getCheckedOutBooks(user);
    }

    public List<User> getLendingUsers(String bookID) {
        return lendingService.getLendingUsers(bookID);
    }

    public int getOverdueFines() {
        return lendingService.getOverdueFineAmount(user);
    }

    public BookItem checkout(String bookID) {
        return lendingService.checkout(user, bookID);
    }

    public boolean renew(BookItem item) {

        return lendingService.renew(user, item);
    }

    public boolean returnBookItem(BookItem item) {

        return lendingService.returnBook(user, item);
    }
}
