# rabbitmq-demo
rabbitmq的demo，包含服务端（生产者）和消费端两块。

项目源码主要从<br>
https://www.imooc.com/article/49814?tdsourcetag=s_pcqq_aiomsg<br>
整理而来，基本一致，略有不同。<br>
经测试，消费端可以正常接收服务端的消息并反馈；服务端也有消息发送失败后的重发机制。
