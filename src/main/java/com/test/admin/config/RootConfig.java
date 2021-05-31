package com.test.admin.config;

import com.alibaba.nacos.spring.context.annotation.config.EnableNacosConfig;
import com.alibaba.nacos.spring.context.annotation.config.NacosPropertySource;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.context.annotation.Import;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;

@Configuration
@ComponentScan(
        basePackages = {"com.test.admin",},
        excludeFilters = {
                @Filter(type = FilterType.ANNOTATION, value = Controller.class),
                @Filter(type = FilterType.ANNOTATION, value = ControllerAdvice.class)}
)
@Import(DevConfig.class)
@EnableAsync
@EnableNacosConfig
@NacosPropertySource(dataId = "admin-env.properties", groupId = "${nacos.group-id}", autoRefreshed = true)
public class RootConfig {

}
