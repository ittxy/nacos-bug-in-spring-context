package com.test.admin.config;

import com.alibaba.nacos.spring.context.annotation.config.EnableNacosConfig;
import com.alibaba.nacos.spring.context.annotation.config.NacosPropertySource;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@EnableWebMvc
@ComponentScan(
	basePackages = {
		"com.test.admin.controller"
	},
	includeFilters = {
		@ComponentScan.Filter(value = Controller.class)
	}
)
@EnableNacosConfig
@NacosPropertySource(dataId = "hs-cms-admin-env.properties", groupId = "${nacos.group-id}", autoRefreshed = true)
public class MvcConfig extends WebMvcConfigurerAdapter {
}
