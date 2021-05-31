package com.test.admin.controller;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.nacos.api.annotation.NacosInjected;
import com.alibaba.nacos.api.config.ConfigService;
import com.alibaba.nacos.api.config.annotation.NacosValue;
import com.test.admin.service.TestService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * only for test internally
 */
@RequestMapping
@Controller
public class TestController {

	private static final Logger LOGGER = LoggerFactory.getLogger(TestController.class);

	@Value("${hs.cms.admin.domain.res}")
	private String admin_domain_res;

	//属性修改后无法 没有刷新成最新值
	@NacosValue(value = "${hs.cms.admin.domain.res}", autoRefreshed = true)
	private String admin_domain_res2;

	@NacosInjected
	private ConfigService configService;

	@Autowired
	Environment env;

	@Autowired
	private ApplicationContext applicationContext;

	@Autowired
	private TestService testService;
	@RequestMapping
	@ResponseBody
	public String index(HttpServletRequest request, HttpServletResponse response) {
		return "success";
	}

	@RequestMapping("/")
	@ResponseBody
	public String nacoseTest(HttpServletRequest request, HttpServletResponse response) {
		JSONObject jo = new JSONObject();
		jo.put("@Value", admin_domain_res+"");
		jo.put("@NacosValue", admin_domain_res2+"");

		String resUrl = env.getProperty("hs.cms.admin.domain.res");
		jo.put("TestService.getAdminDomainRes", testService.getAdminDomainRes()+"");

		jo.put("TestService.getAdminDomainRes2",testService.getAdminDomainRes2()+"");

		LOGGER.info("nacos test result: {}", jo.toJSONString());

		return jo.toJSONString();
	}

}
