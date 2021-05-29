package com.test.ingestion.config;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties
public class AppProperties {

    private String mongoUri;

    public String getMongoUri() {
        return mongoUri;
    }

    public void setMongoUri(String mongoUri) {
        this.mongoUri = mongoUri;
    }
}
