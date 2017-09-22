## 服务网关功能

## 一、项目结构

#### springcloud-eureka-sample (Spring Cloud 之 Eureka 入门案例)
- springcloud-eureka-server (Spring Cloud Eureka 注册中心服务)
- springcloud-eureka-client-provider (Spring Cloud 服务提供者）
- springcloud-eureka-client-customer (Spring Cloud 服务消费者)

对应教程：
- [《Spring Cloud Eureka 入门 （一）服务注册中心详解》](http://spring4all.com/article/101)<br>
- [《Spring Cloud Eureka 入门 （二）服务提供者详解》](http://spring4all.com/article/122)<br>
- [《Spring Cloud Eureka 入门 （三）服务消费者详解》](http://spring4all.com/article/131)<br>

- - -
服务网关是微服务架构中一个不可或缺的部分。通过服务网关统一向外系统提供REST API的过程中，
除了具备服务路由、均衡负载功能之外，它还具备了权限控制等功能。Spring Cloud Netflix中的
Zuul就担任了这样的一个角色，为微服务架构提供了前门保护的作用，同时将权限控制这些较重的非业
务逻辑内容迁移到服务路由层面，使得服务集群主体能够具备更高的可复用性和可测试性。





<br><br><br><br>
参考作者<br>
作者：[泥瓦匠BYSocket](http://www.bysocket.com/ "泥瓦匠BYSocket")<br>
源码地址：[GitHub地址](https://github.com/JeffLi1993 "GitHub")<br>