package src.Model.Request;

import src.Model.Delivery;
import src.Model.Order;

import java.util.List;

 class GetAllRoutesRequestBuilderImpl implements GetAllRoutesRequestBuilder {

    private List<Order> orders;

    private Delivery deliveryPerson;
    private String fieldValidationErrorMsg = "DeLivery GetDeliveryRouteRequestBuilder: ";

    public GetAllRoutesRequestBuilder withOrders(List<Order> orders) {
        this.orders = orders;
        return this;
    }

     public GetAllRoutesRequestBuilder withDeliveryPerson(Delivery deliveryPerson) {
         this.deliveryPerson = deliveryPerson;
         return this;
     }


    public GetAllRoutesRequest build() {
        validateList(orders);
        GetAllRoutesRequestImpl request = new GetAllRoutesRequestImpl();
        request.setOrders(orders);
        return request;
    }

    private boolean validateList(List<Order> orders) {
        if (!orders.isEmpty()) {
            return true;
        } else {
            decorateErrorMsg();
            return false;
        }
    }
    private void decorateErrorMsg() {
        this.fieldValidationErrorMsg = this.fieldValidationErrorMsg + "Orders List is blank";
    }
}
