package com.arana.guitar.notebook.practice.infrastructure.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import lombok.Data;

@Data
@Component
@ConfigurationProperties(prefix = "frontend")
public class FrontEndProperties {
    private String url;
}
