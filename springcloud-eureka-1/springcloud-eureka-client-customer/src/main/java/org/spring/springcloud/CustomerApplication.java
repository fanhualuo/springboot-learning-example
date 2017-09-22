package org.spring.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * Spring Boot Eureka Server 应用启动类
 *
 * Created by bysocket on 21/06/17.
 */

//@EnableDiscoveryClient 标志该应用作为 Eureka Client ，并会自动化读取
// Eureka 相关配置。还有向服务注册中心发现服务并进行调用。
//通过@EnableFeignClients注解开启扫描Spring Cloud Feign客户端的功能：
@EnableFeignClients
@EnableDiscoveryClient // Eureka Discovery Client 标识
@SpringBootApplication // Spring Boot 应用标识
@EnableCircuitBreaker   //@EnableCircuitBreaker注解开启断路器功能：
public class CustomerApplication {

    //@LoadBalanced 标志着 RestTemplate 是通过 Ribbon 客户端负载均衡去调用服务提供者集群的。
    // 即可以在获取的服务提供者实例列表中，通过 Ribbon 进行选择某实例，然后调用该服务实例。

    //RestTemplate 对象，它是 HTTP 访问操作类。然后 customer 方法，
    // 通过 restTemplate 通过 HTTP 协议调用服务提供者暴露的 provider
    // 接口，并获取服务提供者的结果。然后组装输出。
    @Bean
    @LoadBalanced
    RestTemplate restTemplate() {
        return new RestTemplate();
    }

    public static void main(String[] args) {
        // 程序启动入口
        // 启动嵌入式的 Tomcat 并初始化 Spring 环境及其各 Spring 组件
        SpringApplication.run(CustomerApplication.class,args);
    }
}
