package org.spring.springcloud.service;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Date: 2017/9/21
 * Time: 下午4:30
 * Author: xieqinghe .
 * 这样写失效，ClientService接口会调用外部接口
 */
@Service
public class ClientServiceImpl implements ClientService{

    @Override
    public String provider() {
        return "6666";
    }

    @Override
    public Integer add(@RequestParam(value = "a") Integer a, @RequestParam(value = "b") Integer b) {
        return -9999;
    }
}
