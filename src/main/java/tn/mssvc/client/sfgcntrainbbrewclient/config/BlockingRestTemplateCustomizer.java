package tn.mssvc.client.sfgcntrainbbrewclient.config;

import org.apache.http.client.config.RequestConfig;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.DefaultConnectionKeepAliveStrategy;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.springframework.boot.web.client.RestTemplateCustomizer;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component// Comment only to test NIORestTemplateCustomizer

public class BlockingRestTemplateCustomizer implements RestTemplateCustomizer {

    private final RestTemplateConfigurationProperties restTemplateConfigurationProperties;

    public BlockingRestTemplateCustomizer(RestTemplateConfigurationProperties restTemplateConfigurationProperties) {
        this.restTemplateConfigurationProperties = restTemplateConfigurationProperties;
    }

    public ClientHttpRequestFactory clientHttpRequestFactory(){
        PoolingHttpClientConnectionManager connectionManager = new PoolingHttpClientConnectionManager();
        connectionManager.setMaxTotal(restTemplateConfigurationProperties.getMaxTotalConnections());
        connectionManager.setDefaultMaxPerRoute(restTemplateConfigurationProperties.getDefaultMaxTotalConnections());

        RequestConfig requestConfig = RequestConfig
                .custom()
                .setConnectionRequestTimeout(restTemplateConfigurationProperties.getConnectionRequestTimeOut())
                .setSocketTimeout(restTemplateConfigurationProperties.getSocketTimeOut())
                .build();

        CloseableHttpClient httpClient = HttpClients
                .custom()
                .setConnectionManager(connectionManager)
                .setKeepAliveStrategy(new DefaultConnectionKeepAliveStrategy())
                .setDefaultRequestConfig(requestConfig)
                .build();
        return new HttpComponentsClientHttpRequestFactory(httpClient);
    }

    @Override
    public void customize(RestTemplate restTemplate) {
        restTemplate.setRequestFactory(this.clientHttpRequestFactory());
    }
}
