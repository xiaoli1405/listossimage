##  作者：list
### 项目需求：通过Http协议上传1个图片和文本信息，图片现存Oss，然后文本+url，先过redis->mq->写入db，再提供http接口读出来写入的信息

#项目架构  
springboot 框架  
JPA 实体数据库映射  
Redis 缓存数据  
RocketMQ 消息队列  
PGSQL 数据库  
OSS 阿里云对象存储  
Swagger 接口文档工具  

  
  #BUG:  
  1.数据在redis缓存没有被删除，导致consumer一直调用缓存数据插入数据库
  方案：在从redis缓存中拿出数据的同时，清理掉缓存即可
  
  2.插入数据库时，使用的是原生的SQL，数据库报返回结果错误，导致消费者无法消费消息，无法把ACK信号发送给服务器，导致重复消费消息。解决方案：把原生的SQL换成JPA的HQL（面向对象的SQL）
  
  #安装部署（假设环境已经搭建）
  
  一、修改OSS对象存储的accessKeyId、accessKeySecret、endpoint、lst-oss （根据配置文件修改） 
  
  二、创建数据库st-test，并修改用户和密码（可根据配置文件修改）
  
  三、修改配置文件的redis缓存数据库信息（根据配置文件修改）
  
  四、编译运行项目run
  
  五、启动redis
  
  六、启动rocket MQ的nameserver和broker，再启动MQ控制台
  
  七、项目启动成功