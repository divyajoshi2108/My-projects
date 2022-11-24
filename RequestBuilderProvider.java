package src.Model.Request;

public class RequestBuilderProvider {
    public static GetAllRoutesRequestBuilder getAllRoutesRequestBuilder() {
        return new GetAllRoutesRequestBuilderImpl();
    }

}
