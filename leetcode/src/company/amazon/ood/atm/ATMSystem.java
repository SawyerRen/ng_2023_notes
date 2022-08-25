package company.amazon.ood.atm;

import javax.xml.crypto.Data;

public class ATMSystem {
    class Address {
    }

    class User {
        Address address;
        Account account;
        Card card;
    }

    class Account {
        String number;
        int balance;
    }

    class Card {
        int id;
        Account account;
    }

    class Bank {

    }

    class ATM {
        int id;
        Address location;

        void makeTransaction(User user, Transaction transaction) {
        }
    }

    class Transaction {
        int id;
        Data createdAt;
        int status;
    }

}
