package org.spring.springcloud.service;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Date: 2017/9/21
 * Time: 下午4:09
 * Author: xieqinghe .
 */

//使用@FeignClient注解来指定这个接口所要调用的服务名称
@FeignClient(value = "provider-service",fallback = ClientServiceImpl.class)
public interface ClientService {
    //接口中定义的各个函数使用Spring MVC的注解就可以来绑定服务提供方的REST接口

    @GetMapping("/provider")
    String provider();

    @RequestMapping(method = RequestMethod.GET, value = "/add")
    Integer add(@RequestParam(value = "a") Integer a, @RequestParam(value = "b") Integer b);




}
