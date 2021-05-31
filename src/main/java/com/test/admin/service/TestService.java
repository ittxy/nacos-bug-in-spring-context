package com.test.admin.service;

import com.alibaba.nacos.api.config.annotation.NacosValue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class TestService {
    @Value("${hs.cms.admin.domain.res}")
    private String admin_domain_res;

    @NacosValue(value = "${hs.cms.admin.domain.res}", autoRefreshed = true)
    private String admin_domain_res2;

    public String getAdminDomainRes(){
        return admin_domain_res;
    }
    public String getAdminDomainRes2(){
        return admin_domain_res2;
    }
}
