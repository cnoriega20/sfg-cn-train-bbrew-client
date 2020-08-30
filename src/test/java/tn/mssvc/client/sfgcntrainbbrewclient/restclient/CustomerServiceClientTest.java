package tn.mssvc.client.sfgcntrainbbrewclient.restclient;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import tn.mssvc.client.sfgcntrainbbrewclient.model.Customer;

import java.net.URI;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CustomerServiceClientTest {

    @Autowired
    private CustomerServiceClient customerServiceClient;

    @Test
    void testGetCustomerById(){
        Customer customer = customerServiceClient.getCustomerByID(UUID.randomUUID());
        assertNotNull(customer);
    }

    @Test
    void testSaveCustomer(){
        Customer customer = Customer.builder().name("Victor").build();
        URI uri = customerServiceClient.saveCustomer(customer);
        assertNotNull(uri);
    }

    @Test
    void testUpdateCustomer(){
        Customer customer = Customer.builder().name("Cesar").build();
        customerServiceClient.updateCustomer(UUID.randomUUID(), customer);

    }

    @Test
    void testDeleteCustomer(){
        customerServiceClient.deleteCustomer(UUID.randomUUID());
    }
}