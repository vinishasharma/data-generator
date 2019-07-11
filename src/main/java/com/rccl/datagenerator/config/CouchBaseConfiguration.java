package com.rccl.datagenerator.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.couchbase.CouchbaseProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.couchbase.config.AbstractReactiveCouchbaseConfiguration;

import java.util.List;

@Configuration
@Slf4j
public class CouchBaseConfiguration extends AbstractReactiveCouchbaseConfiguration {

    private CouchbaseProperties couchbaseProperties;
    private final String username;
    private final String crewBucketName;

    public CouchBaseConfiguration(CouchbaseProperties couchbaseProperties,
                                  @Value("${spring.couchbase.bucket.username}") String bucketUsername,
                                  @Value("${couchbase.crew.bucket.name}") String crewBucketName) {
        this.couchbaseProperties = couchbaseProperties;
        this.username = bucketUsername;
        this.crewBucketName = crewBucketName;
    }

    @Override
    protected List<String> getBootstrapHosts() {
        return couchbaseProperties.getBootstrapHosts();
    }

    @Override
    protected String getBucketName() {
        return crewBucketName;
    }

    @Override
    protected String getBucketPassword() {
        return couchbaseProperties.getBucket().getPassword();
    }

    @Override
    protected String getUsername() {
        return username;
    }

    @Override
    public String typeKey() {
        return "type";
    }
}
