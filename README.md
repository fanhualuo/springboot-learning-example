## 一、项目结构

#### springcloud-eureka-sample (Spring Cloud 之 Eureka 入门案例)
- springcloud-eureka-server (Spring Cloud Eureka 注册中心服务1)
- springcloud-eureka-server2 (Spring Cloud Eureka 注册中心服务2)
- springcloud-eureka-client-provider (Spring Cloud 服务提供者）
- springcloud-eureka-client-customer (Spring Cloud 服务消费者)


- - -
内容：高可用服务注册中心示例

高可用服务注册中心
Eureka Server除了单点运行之外，还可以通过运行多个实例，并进行互相注册的方式来实现高
可用的部署，所以我们只需要将Eureke Server配置其他可用的serviceUrl就能实现高可用部署。

创建两个服务注册中心server1，server2

(1)  server1的配置文件
server.port=8888
eureka.instance.hostname=server1
eureka.client.serviceUrl.defaultZone=http://server2:8889/eureka/

(2)  server2的配置文件
server.port=8889
eureka.instance.hostname=server2
eureka.client.serviceUrl.defaultZone=http://server1:8888/eureka/

(3)  在/etc/hosts文件中添加对server1和server2的转换
127.0.0.1 server1
127.0.0.1 server2

(4)  此时访问peer1的注册中心：http://localhost:8888/，如下图所示，我们可以看到
registered-replicas中已经有peer2节点的eureka-server了。同样地，访问peer2的注
册中心：http://localhost:8889/，能看到registered-replicas中已经有peer1节点，
并且这些节点在可用分片（available-replicase）之中。我们也可以尝试关闭peer1，刷新
http://localhost:8889/，可以看到peer1的节点变为了不可用分片（unavailable-rep
licas）。




<br><br><br><br>
参考作者<br>
作者：[泥瓦匠BYSocket](http://www.bysocket.com/ "泥瓦匠BYSocket")<br>
源码地址：[GitHub地址](https://github.com/JeffLi1993 "GitHub")<br>