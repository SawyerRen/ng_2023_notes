package company.amazon.ood.linkedin;

class Account {

}

class Address {
    private String streetAddress;
    private String city;
    private String state;
    private String zipCode;
    private String country;
}

abstract class Person extends Account {
    private String name;
    private Address address;
    private String email;
    private String phone;
    private Account account;
}

public class LinkedinSystem {
}
