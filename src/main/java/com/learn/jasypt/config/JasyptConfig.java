package com.learn.jasypt.config;

import com.learn.jasypt.config.properties.JasyptProperties;
import lombok.RequiredArgsConstructor;
import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;
import org.jasypt.iv.RandomIvGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class JasyptConfig {
    private final JasyptProperties jasyptProperties;

    @Bean
    public StandardPBEStringEncryptor stringEncryptor() {
        StandardPBEStringEncryptor encryptor = new StandardPBEStringEncryptor();

        encryptor.setPassword(jasyptProperties.getPassword());
        encryptor.setAlgorithm(jasyptProperties.getAlgorithm());
        encryptor.setIvGenerator(new RandomIvGenerator());
        return encryptor;
    }
}
