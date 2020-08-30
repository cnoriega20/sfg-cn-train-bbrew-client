package tn.mssvc.client.sfgcntrainbbrewclient.restclient;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import tn.mssvc.client.sfgcntrainbbrewclient.model.Customer;

import java.net.URI;
import java.util.UUID;

@Component
@ConfigurationProperties(value = "cn.brewery", ignoreUnknownFields = false)
public class CustomerServiceClient {
    public final String CUSTOMER_SERVICE_PATH_V1 = "/api/v1/customerService/";
    private String apiHost;

    private final RestTemplate restTemplate;

    public CustomerServiceClient(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    public void setApiHost(String apiHost) {
        this.apiHost = apiHost;
    }

   // Rest Client GET Method
    public Customer getCustomerByID(UUID uuid){
       return restTemplate.getForObject(apiHost + CUSTOMER_SERVICE_PATH_V1
       + uuid.toString(), Customer.class);
    }

    //REST Client POST Method
    public URI saveCustomer(Customer customer){
        return restTemplate.postForLocation(apiHost + CUSTOMER_SERVICE_PATH_V1, customer);
    }

    //REST Client Update Method
    public void updateCustomer(UUID uuid, Customer customer){
        restTemplate.put(apiHost + CUSTOMER_SERVICE_PATH_V1 +
                "/" + uuid.toString(), customer);
    }

    // REST Client Delete Method
    public void deleteCustomer(UUID uuid){
        restTemplate.delete(apiHost + CUSTOMER_SERVICE_PATH_V1 +
                "/" + uuid);
    }
}
