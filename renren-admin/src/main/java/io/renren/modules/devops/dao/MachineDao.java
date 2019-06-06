package io.renren.modules.devops.dao;

import io.renren.modules.devops.entity.MachineEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 服务管理
 * 
 * @author Chase
 * @email pangcq699885@126.com
 * @date 2019-05-06 16:11:24
 */
@Mapper
public interface MachineDao extends BaseMapper<MachineEntity> {
	
}
