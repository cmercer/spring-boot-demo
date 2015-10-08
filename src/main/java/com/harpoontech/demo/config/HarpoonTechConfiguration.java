package com.harpoontech.demo.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

@Configuration
@EnableConfigurationProperties
public class HarpoonTechConfiguration {

    private final Logger log = LoggerFactory.getLogger(HarpoonTechConfiguration.class);


    @Bean
    @Lazy(false)
    public HarpoonTechProperties harpoonTechProperties() {
        log.debug("Configuring {}", HarpoonTechProperties.class.getSimpleName());
        return new HarpoonTechProperties();
    }
}
