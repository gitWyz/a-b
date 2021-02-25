/**用户表*/
CREATE TABLE `user` (
                           `id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
                           `user_code` varchar(40)  NOT NULL COMMENT '用户编号(snowflake)',
                           `user_name` varchar(60)  NOT NULL COMMENT '用户姓名',
                           `password_salt` varchar(50)  NOT NULL COMMENT '加盐密码',
                           `password_hash` varchar(50)  NOT NULL COMMENT '密码hash值',
                           `phone` varchar(15)  NOT NULL COMMENT '手机号',
                           `email` varchar(70)  DEFAULT NULL COMMENT '邮箱',
                           `user_status` tinyint(3) unsigned NOT NULL DEFAULT '1' COMMENT '状态0停用1启用',
                           `create_by` varchar(40)  DEFAULT NULL COMMENT '创建人',
                           `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
                           `update_by` varchar(40)  DEFAULT NULL COMMENT '更新人',
                           `update_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
                           PRIMARY KEY (`id`),
                           UNIQUE KEY `idx_ws_user_idx2` (`phone`,`user_status`),
                           KEY `idx_ws_user_1` (`user_code`,`user_name`,`phone`)
) ENGINE=InnoDB AUTO_INCREMENT=1 COMMENT='用户表';