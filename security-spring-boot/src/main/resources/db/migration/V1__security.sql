/* 创建t_user表 */

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
VALUES(1, 'zhangsan', '$2a$10$NlBC84MVb7F95EXYTXwLneXgCca6/GipyWR5NHm8K0203bSQMLpvm', '张三', '18551608976');

INSERT INTO `t_user` (`id`, `username`, `password`, `fullname`, `mobile`)
VALUES(2, 'lisi', '$2a$10$jKb/5EUit2Oqrt6WLlbZRuSJGpvZq6zwEzip2ZKR2mloHjkkW1Xz2', '李四', '18523508976');