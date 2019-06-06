package io.renren.modules.devops.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 服务管理
 * 
 * @author Chase
 * @email pangcq699885@126.com
 * @date 2019-05-06 16:11:24
 */
@Data
@TableName("tb_machine")
public class MachineEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private Long machineId;
	/**
	 * 云ID
	 */
	private String cloudId;
	/**
	 * 服务器名
	 */
	private String name;
	/**
	 * CPU
	 */
	private String cpu;
	/**
	 * 内存
	 */
	private String ram;
	/**
	 * 操作系统
	 */
	private String oprSystem;
	/**
	 * 私网IP
	 */
	private String privateIp;
	/**
	 * 公网IP
	 */
	private String publicIp;
	/**
	 * 到期时间
	 */
	private String expires;
	/**
	 * 带宽
	 */
	private String bandwidth;
	/**
	 * 介绍
	 */
	private String intro;

}
