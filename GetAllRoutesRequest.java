package src.Model.Request;

import src.Model.Customer;
import src.Model.Delivery;
import src.Model.Order;
import src.Model.Restaurant;

import java.util.List;

public interface GetAllRoutesRequest {
    List<Order> orders();
    Delivery deliveryPerson();
}
