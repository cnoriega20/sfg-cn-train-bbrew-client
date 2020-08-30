package tn.mssvc.client.sfgcntrainbbrewclient.restcient;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import tn.mssvc.client.sfgcntrainbbrewclient.model.Beer;

import java.util.UUID;

@Component
@ConfigurationProperties(value = "cn.brewery", ignoreUnknownFields = false)
public class BeerServiceClient {
    public final String BEER_SERVICE_PATH_V1 = "/api/v1/beerService";
    private String apiHost;

    private final RestTemplate restTemplate;

    // RestTemplate Builder object injected by Spring via Constructor
    public BeerServiceClient(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    // Rest Client GET method
    public Beer getBeerById(UUID uuid){
        return restTemplate.getForObject(apiHost + BEER_SERVICE_PATH_V1
                + uuid.toString(), Beer.class);
    }


}
