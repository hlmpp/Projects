/* 创建t_user用户表 */
DROP TABLE IF EXISTS `t_user`;

CREATE TABLE `t_user` (
`id` bigint(20) NOT NULL COMMENT '用户id',
`username` varchar(64) NOT NULL,
`password` varchar(64) NOT NULL,
`fullname` varchar(255) NOT NULL COMMENT '用户姓名',
`mobile` varchar(11) DEFAULT NULL COMMENT '手机号',
PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

INSERT INTO `t_user` (`id`, `username`, `password`, `fullname`, `mobile`)
VALUES(1, 'zhangsan', '$2a$10$NlBC84MVb7F95EXYTXwLneXgCca6/GipyWR5NHm8K0203bSQMLpvm', '张三', '18551608976'),
(2, 'lisi', '$2a$10$jKb/5EUit2Oqrt6WLlbZRuSJGpvZq6zwEzip2ZKR2mloHjkkW1Xz2', '李四', '18523508976');

/* 创建角色表 */
CREATE TABLE `t_role` (
`id` varchar(32) NOT NULL,
`role_name` varchar(255) DEFAULT NULL,
`description` varchar(255) DEFAULT NULL,
`create_time` datetime DEFAULT NULL,
`update_time` datetime DEFAULT NULL,
`status` char(1) NOT NULL,
PRIMARY KEY (`id`),
UNIQUE KEY `unique_role_name` (`role_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO `t_role`(`id`,`role_name`,`description`,`create_time`,`update_time`,`status`) VALUES
('1','管理员',NULL,NULL,NULL,'');

/* 创建用户角色关联表 */
CREATE TABLE `t_user_role` (
`user_id` varchar(32) NOT NULL,
`role_id` varchar(32) NOT NULL,
`create_time` datetime DEFAULT NULL,
`creator` varchar(255) DEFAULT NULL,
PRIMARY KEY (`user_id`,`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO `t_user_role`(`user_id`,`role_id`,`create_time`,`creator`) VALUES
('1','1',NULL,NULL);

/* 创建权限表 */
CREATE TABLE `t_permission` (
`id` varchar(32) NOT NULL,
`code` varchar(32) NOT NULL COMMENT '权限标识符',
`description` varchar(64) DEFAULT NULL COMMENT '描述',
`url` varchar(128) DEFAULT NULL COMMENT '请求地址',
PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO `t_permission`(`id`,`code`,`description`,`url`) VALUES ('1','p1','测试资源
1','/r/r1'),('2','p2','测试资源2','/r/r2');

/* 角色权限关系表 */
CREATE TABLE `t_role_permission` (
`role_id` varchar(32) NOT NULL,
`permission_id` varchar(32) NOT NULL,
PRIMARY KEY (`role_id`,`permission_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO `t_role_permission`(`role_id`,`permission_id`) VALUES ('1','1'),('1','2');