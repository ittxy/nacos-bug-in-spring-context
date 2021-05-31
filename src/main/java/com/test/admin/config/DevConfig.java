package com.test.admin.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

@PropertySources({@PropertySource(value = "classpath:/spring-config.properties")})
@Configuration
public class DevConfig {
}
