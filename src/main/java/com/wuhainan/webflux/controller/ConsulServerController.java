package com.wuhainan.webflux.controller;

import com.ecwid.consul.v1.ConsulClient;
import com.ecwid.consul.v1.Response;
import com.ecwid.consul.v1.agent.model.NewService;
import com.ecwid.consul.v1.agent.model.Service;
import com.wuhainan.webflux.config.Config;
import org.springframework.cloud.consul.serviceregistry.ConsulRegistration;
import org.springframework.cloud.consul.serviceregistry.ConsulServiceRegistry;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Map;

/**
 * @author wuhainan
 */
@RestController
public class ConsulServerController {
    @Resource
    private ConsulClient discoveryClient;
    @Resource
    private ConsulServiceRegistry consulServiceRegistry;

    /**
     * 获取所有服务
     */
    @GetMapping("/consul/services")
    public Response<Map<String, Service>> services() {
        return discoveryClient.getAgentServices();
    }

    @GetMapping("/consul/register/{serviceId}")
    public void register(@PathVariable("serviceId") String serviceId) {
        NewService newService = new NewService();
        newService.setId(serviceId);
        ConsulRegistration consulRegistration = new ConsulRegistration(newService, null);
        consulServiceRegistry.register(consulRegistration);
    }

    @GetMapping("/consul/deregister/{serviceId}")
    public void deregister(@PathVariable("serviceId") String serviceId) {
        NewService newService = new NewService();
        newService.setId(serviceId);
        ConsulRegistration consulRegistration = new ConsulRegistration(newService, null);
        consulServiceRegistry.deregister(consulRegistration);
    }

    @Resource
    private Config config;

    @RequestMapping(value = "/getConfig")
    public String getConfig() {
        return config.toString();
    }

    @RequestMapping(value = "/getTitle")
    public String getTitle() {
        return config.getTitle();
    }
}
