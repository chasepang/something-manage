CREATE TABLE `tb_machine` (
        `machine_id` bigint NOT NULL AUTO_INCREMENT,
        `cloud_id` varchar(50) COMMENT '云ID',
        `name` varchar(50) COMMENT '服务器名',
        `cpu` varchar(50) COMMENT 'CPU',
        `ram` varchar(50) COMMENT '内存',
        `opr_system` varchar(50) COMMENT '操作系统',
        `private_ip` varchar(50) COMMENT '私网IP',
        `public_ip` varchar(50) COMMENT '公网IP',
        `expires` date COMMENT '到期时间',
        `bandwidth` varchar(50) COMMENT '带宽',
        `intro` varchar(500) COMMENT '介绍',
        PRIMARY KEY (`machine_id`)
      ) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='服务管理';