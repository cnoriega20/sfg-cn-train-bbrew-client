package tn.mssvc.client.sfgcntrainbbrewclient.restcient;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import tn.mssvc.client.sfgcntrainbbrewclient.model.Beer;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class BeerServiceClientTest {

    @Autowired
    private BeerServiceClient beerServiceClient;

    @Test
    void getBeerById() {
        Beer beer = beerServiceClient.getBeerById(UUID.randomUUID());
        assertNotNull(beer);
    }
}