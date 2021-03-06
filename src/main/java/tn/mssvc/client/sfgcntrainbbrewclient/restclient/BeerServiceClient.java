package tn.mssvc.client.sfgcntrainbbrewclient.restclient;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import tn.mssvc.client.sfgcntrainbbrewclient.model.Beer;

import java.net.URI;
import java.util.UUID;

@Component
@ConfigurationProperties(value = "cn.brewery", ignoreUnknownFields = false)
public class BeerServiceClient {
    public final String BEER_SERVICE_PATH_V1 = "/api/v1/beerService/";
    private String apiHost;

    private final RestTemplate restTemplate;

    // RestTemplate Builder object injected by Spring via Constructor
    public BeerServiceClient(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    public void setApiHost(String apiHost) {
        this.apiHost = apiHost;
    }

    // Rest Client GET method
    public Beer getBeerById(UUID uuid){
        return restTemplate.getForObject(apiHost + BEER_SERVICE_PATH_V1
                + uuid.toString(), Beer.class);
    }

    // REST client POST method returning the Resource URI
    public URI saveBeer(Beer beer){
        System.out.println("Inside client saveBeer: " + apiHost + BEER_SERVICE_PATH_V1);
        return restTemplate.postForLocation(apiHost + BEER_SERVICE_PATH_V1, beer);
    }

    public void updateBeer(UUID uuid, Beer beer){
        restTemplate.put(apiHost + BEER_SERVICE_PATH_V1 + "/" + uuid.toString(), beer);
    }

    public void deleteBeer(UUID uuid){
        restTemplate.delete(apiHost + BEER_SERVICE_PATH_V1 + "/" + uuid);
    }
}
