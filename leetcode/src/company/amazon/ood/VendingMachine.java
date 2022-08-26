package company.amazon.ood;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Product {
    double price;
}

class Water extends Product {
}

abstract class Payment {
    abstract double checkout(Product product);
}

class CardPayment extends Payment {

    @Override
    double checkout(Product product) {
        return product.price * 0.8;
    }
}

class CashPayment extends Payment {

    @Override
    double checkout(Product product) {
        return product.price;
    }
}

public class VendingMachine {
    Map<Integer, Product> slots = new HashMap<>();
    List<Product> products = new ArrayList<>();
    int capacity;

    public VendingMachine(int capacity) {
        this.capacity = capacity;
    }

    boolean addProduct(int index, Product product) {
        if (slots.size() >= capacity) return false;
        slots.put(index, product);
        return true;
    }

    Product order(int index) {
        Product product = slots.get(index);
        if (product != null) products.add(product);
        return product;
    }

    double checkout(Payment payment) {
        double total = 0;
        for (Product product : this.products) {
            total += payment.checkout(product);
        }
        products.clear();
        return total;
    }
}

class Customer {
    boolean select(VendingMachine vendingMachine, int index) {
        Product product = vendingMachine.order(index);
        if (product == null) return false;
        return true;
    }

    double checkout(VendingMachine vm, Payment payment) {
        return vm.checkout(payment);
    }
}