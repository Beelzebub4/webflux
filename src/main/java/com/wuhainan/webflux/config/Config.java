package com.wuhainan.webflux.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author wuhainan
 */
@Data
@ConfigurationProperties(prefix = "config")
public class Config {
    /**
     * name要与consul上面的title写的一样
     */
    private String title;

}
