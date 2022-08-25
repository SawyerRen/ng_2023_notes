package company.amazon.ood.onlinestock;

import javax.xml.crypto.Data;
import java.util.Map;

enum ReturnStatus {
    SUCCESS,
    FAIL, INSUFFICIENT_FUNDS, INSUFFICIENT_QUANTITY, NO_STOCK_POSITION
}

enum OrderStatus {
    OPEN,
    FILLED, PARTIALLY_FILLED, CANCELLED
}

enum TimeEnforcementType {
    GOOD_TILL_CANCELLED, FILL_OR_KILL,
    IMMEDIATE_OR_CANCEL, ON_THE_OPEN, ON_THE_CLOSE
}

class Constants {
    public static int MONEY_TRANSFER_LIMIT = 100000;
}

class StockExchange {

}

abstract class Order {
    String orderNumber;
    boolean isBuyOrder;
    OrderStatus status;
    TimeEnforcementType timeEnforcementType;
    Data createdAt;
}

class Address {
}

class Account {
    double availableFunds;
    Map<String, Address> stockPositions;
    Map<Integer, Order> activeOrders;


}

public class StockSystem {

}
