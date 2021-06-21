##  作者：list
### 项目需求：通过Http协议上传1个图片和文本信息，图片现存Oss，然后文本+url，先过redis->mq->写入db，再提供http接口读出来写入的信息

项目架构  
springboot 框架  
JPA 实体数据库映射  
Redis 缓存数据  
RocketMQ 消息队列  
PGSQL 数据库  
OSS 阿里云对象存储  
Swagger 接口文档工具  

  
  BUG:数据在redis缓存没有被删除，导致consumer一直调用缓存数据插入数据库
  方案：在从redis缓存中拿出数据的同时，清理掉缓存即可