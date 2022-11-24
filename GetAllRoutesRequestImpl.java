package src.Model.Request;

import src.Model.Delivery;
import src.Model.Order;

import java.util.List;

 class GetAllRoutesRequestImpl implements GetAllRoutesRequest {

    List<Order> orders;

     Delivery deliveryPerson;

    public List<Order> orders() {
        return this.orders;
    }
     public Delivery deliveryPerson() {
         return this.deliveryPerson;
     }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }
     public void setDeliveryPerson(Delivery deliveryPerson) { this.deliveryPerson = deliveryPerson; }

 }
