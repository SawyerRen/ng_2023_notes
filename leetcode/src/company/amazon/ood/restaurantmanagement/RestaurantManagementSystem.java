package company.amazon.ood.restaurantmanagement;

class Address {
    private String streetAddress;
    private String city;
    private String state;
    private String zipCode;
    private String country;
}

abstract class Account {
    private String id;
    private String password;
    private Address address;
}

class Person extends Account {
    private String name;
    private String email;
    private String phone;
}

public class RestaurantManagementSystem {

}
