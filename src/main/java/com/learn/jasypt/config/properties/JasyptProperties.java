package com.learn.jasypt.config.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@ConfigurationProperties(prefix = "jasypt.encryptor")
@Component
@Data
public class JasyptProperties {
    private String password;
    private String algorithm;
}
