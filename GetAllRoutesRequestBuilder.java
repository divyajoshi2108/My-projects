package src.Model.Request;

import lombok.NonNull;
import src.Model.Delivery;
import src.Model.Order;

import java.util.List;

public interface GetAllRoutesRequestBuilder {


    GetAllRoutesRequestBuilder withOrders(@NonNull List<Order> orders);
    GetAllRoutesRequestBuilder withDeliveryPerson(@NonNull Delivery deliveryPerson);

    GetAllRoutesRequest build();
}
