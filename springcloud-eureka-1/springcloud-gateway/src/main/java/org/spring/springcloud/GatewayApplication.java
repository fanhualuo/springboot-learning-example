package org.spring.springcloud;

import org.spring.springcloud.filter.MyZuulFilter;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

/**
 * 服务网关
 * Date: 2017/9/22
 * Time: 下午4:50
 * Author: xieqinghe .
 */
@EnableZuulProxy   //服务网关注解
@SpringCloudApplication   //多个注解集合
public class GatewayApplication {
    public static void main(String[] args){
        new SpringApplicationBuilder(GatewayApplication.class).web(true).run(args);
    }

    @Bean
    public MyZuulFilter myZuulFilter(){
        return new  MyZuulFilter();
    }
}
