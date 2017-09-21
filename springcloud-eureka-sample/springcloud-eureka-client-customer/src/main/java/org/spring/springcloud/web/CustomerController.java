package org.spring.springcloud.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.spring.springcloud.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.handler.UserRoleAuthorizationInterceptor;

/**
 * Customer HelloWorld 案例
 * <p>
 * Created by bysocket on 06/22/17.
 */
@RestController
public class CustomerController {

    private static final Logger LOGGER = LoggerFactory.getLogger(CustomerController.class);

    @Autowired
    private RestTemplate restTemplate; // HTTP 访问操作类

    @RequestMapping("/customer")
    public String customer() {
        String providerMsg = restTemplate.getForEntity("http://PROVIDER-SERVICE/provider",
                String.class).getBody();

        return "Hello,Customer! msg from provider : <br/><br/> " + providerMsg;
    }

    //LoadBalancerClient 负载均衡客户端的抽象定义
    // 提供的负载均衡器客户端接口来实现服务的消费。
    @Autowired
    private LoadBalancerClient loadBalancerClient;

    @RequestMapping("/customer2")
    public String customer2() {

        ServiceInstance serviceInstance = loadBalancerClient.choose("provider-service");
        String url = "http://" + serviceInstance.getHost() + ":" + serviceInstance.getPort() + "/provider";
        System.out.println("/n"+"  123456  " + serviceInstance);
        System.out.println(url);
        //restTemplate.getForObject(url,String.class);

        return "Hello,Customer2! msg from provider : <br/><br/> "+restTemplate.getForEntity(url,String.class);
    }

    @Autowired
    private ClientService clientService;

    //通过定义的feign客户端来调用服务提供方的接口：
    @RequestMapping("/customer3")
    public String customer3() {
        System.out.println(clientService);

        return "Hello,Customer3! msg from provider : <br/><br/> "+clientService.provider();
    }


    @RequestMapping("/customer4")
    public String customer4() {
        return "Hello,Customer4! msg from provider : <br/><br/> "+clientService.add(1,3);
    }
}