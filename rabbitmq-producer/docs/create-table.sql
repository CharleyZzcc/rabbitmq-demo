# 表 order 订单结构 
CREATE TABLE IF NOT EXISTS `t_order` (
	`id` varchar(128) NOT NULL comment '订单ID',
	`name` varchar(128) comment '订单名称 其他业务熟悉忽略',
	`message_id` varchar(128) NOT NULL comment '消息唯一ID',
	PRIMARY KEY (`id`) 
) ENGINE=InnoDB DEFAULT CHARSET=utf8 comment '订单结构';

# 表 broker_message_log 消息记录结构
CREATE TABLE IF NOT EXISTS `broker_message_log` (
	`message_id` varchar(128) NOT NULL comment '消息唯一ID',
	`message` varchar(4000) DEFAULT NULL comment '消息内容',
	`try_count` int(4) DEFAULT '0' comment '重试次数',
	`status` varchar(10) DEFAULT '' comment '消息投递状态#0-投递中；1-投递成功；2-投递失败',
	`create_time` timestamp NOT NULL comment '创建时间',
	`update_time` timestamp NOT NULL comment '更新时间',
	`next_retry` timestamp NOT NULL comment '下一次重试时间或超时时间',
	PRIMARY KEY (`message_id`) 
) ENGINE=InnoDB DEFAULT CHARSET=utf8 comment '消息记录结构';