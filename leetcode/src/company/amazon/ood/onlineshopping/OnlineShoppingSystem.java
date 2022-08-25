package company.amazon.ood.onlineshopping;

import org.omg.CORBA.UNKNOWN;
import org.omg.PortableInterceptor.ACTIVE;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

public class OnlineShoppingSystem {
    class Address {
        private String streetAddress;
        private String city;
        private String state;
        private String zipCode;
        private String country;
    }

    enum OrderStatus {
        UNSHIPPED, PENDING, SHIPPED, COMPLETED, CANCELED, REFUND_APPLIED
    }

    enum AccountStatus {
        ACTIVE, BLOCKED, BANNED, COMPROMISED, ARCHIVED, UNKNOWN
    }


    enum ShipmentStatus {
        PENDING, SHIPPED, DELIVERED, ON_HOLD
    }


    enum PaymentStatus {
        UNPAID, PENDING, COMPLETED, FILLED, DECLINED, CANCELLED, ABANDONED, SETTLING, SETTLED, REFUNDED
    }

    class Account {
        String username;
        String password;
        String name;
        String email;
        String phone;
        Address shippingAddress;
    }

    class ProductCategory {
        String name;
        String description;
    }

    class ProductReview {
        double rating;
        String content;
        int reviewerId;
    }

    class Product {
        int id;
        String name;
        String description;
        double price;
        ProductCategory category;
        int inventory;
        int sellerCount;
    }

    class ShoppingCartItem {
        int productId;
        int count;
        double price;
    }

    class ShoppingCart {
        int customerId;
        List<ShoppingCartItem> items = new ArrayList<>();

        void checkout() {

        }
    }

    class Order {
        int id;
        int customerId;
        OrderStatus status;
        Date date;

        public void sendForShipment() {
        }
    }

    interface Search {
        public List<Product> searchProductsByName(String name);

        public List<Product> searchProductsByCategory(String category);
    }

    class Catalog implements Search {
        HashMap<String, List<Product>> productNames;
        HashMap<String, List<Product>> productCategories;

        public List<Product> searchProductsByName(String name) {
            return productNames.get(name);
        }

        public List<Product> searchProductsByCategory(String category) {
            return productCategories.get(category);
        }
    }
}
