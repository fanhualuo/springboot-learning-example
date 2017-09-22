package org.spring.springcloud;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * Spring Cloud构建微服务架构：分布式配置中心
 * Date: 2017/9/22
 * Time: 下午1:26
 * Author: xieqinghe .
 */
@EnableConfigServer
@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        new SpringApplicationBuilder(Application.class).web(true).run(args);
    }
}
