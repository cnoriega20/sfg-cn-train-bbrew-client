package tn.mssvc.client.sfgcntrainbbrewclient.restclient;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import tn.mssvc.client.sfgcntrainbbrewclient.model.Beer;

import java.net.URI;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class BeerServiceClientTest {

    @Autowired
    private BeerServiceClient beerServiceClient;

    @Test
    void testGetBeerById() {
        Beer beer = beerServiceClient.getBeerById(UUID.randomUUID());
        assertNotNull(beer);
    }

    @Test
    void testSaveBeer(){
        //Given
        Beer beer = Beer.builder().beerName("Polks").build();

        URI uri = beerServiceClient.saveBeer(beer);
        assertNotNull(uri);
        System.out.println("Post save Beer uri: " + uri.toString());
    }

    @Test
    void testUpdateBeer(){
        Beer beer = Beer.builder().beerName("Juninho").build();
        beerServiceClient.updateBeer(UUID.randomUUID(), beer);
    }

    @Test
    void testDeleteBeer(){
        beerServiceClient.deleteBeer(UUID.randomUUID());
    }


}