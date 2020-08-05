package com.coder.myrule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author : JQK
 * @date : 2020-07-24 17:01
 * @description :
 */
@Configuration
public class MyRule {
    @Bean
    public IRule getMyRule() {
        return new RandomRule();//定义为随机
    }
}
