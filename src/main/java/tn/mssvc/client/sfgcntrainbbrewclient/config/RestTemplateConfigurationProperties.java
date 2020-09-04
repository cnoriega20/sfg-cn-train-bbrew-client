package tn.mssvc.client.sfgcntrainbbrewclient.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(value = "cn.customizer")
public class RestTemplateConfigurationProperties {
    private Integer maxTotalConnections;
    private Integer defaultMaxTotalConnections;
    private Integer connectionRequestTimeOut;
    private Integer socketTimeOut;

    public Integer getMaxTotalConnections() {
        return maxTotalConnections;
    }

    public void setMaxTotalConnections(Integer maxTotalConnections) {
        this.maxTotalConnections = maxTotalConnections;
    }

    public Integer getDefaultMaxTotalConnections() {
        return defaultMaxTotalConnections;
    }

    public void setDefaultMaxTotalConnections(Integer defaultMaxTotalConnections) {
        this.defaultMaxTotalConnections = defaultMaxTotalConnections;
    }

    public Integer getConnectionRequestTimeOut() {
        return connectionRequestTimeOut;
    }

    public void setConnectionRequestTimeOut(Integer connectionRequestTimeOut) {
        this.connectionRequestTimeOut = connectionRequestTimeOut;
    }

    public Integer getSocketTimeOut() {
        return socketTimeOut;
    }

    public void setSocketTimeOut(Integer socketTimeOut) {
        this.socketTimeOut = socketTimeOut;
    }
}
