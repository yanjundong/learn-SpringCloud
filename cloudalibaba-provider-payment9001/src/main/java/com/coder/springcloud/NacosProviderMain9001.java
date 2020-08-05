package com.coder.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author : JQK
 * @date : 2020-08-02 10:42
 * @description :
 */
@SpringBootApplication
@EnableDiscoveryClient
public class NacosProviderMain9001 {

    public static void main(String[] args) {
        SpringApplication.run(NacosProviderMain9001.class, args);
    }

}
