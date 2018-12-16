package com.wuhainan.webflux;

import com.wuhainan.webflux.config.Config;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author wuhainan
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableConfigurationProperties({Config.class})
public class WebfluxApplication {

    public static void main(String[] args) {
        SpringApplication.run(WebfluxApplication.class, args);
    }
}
