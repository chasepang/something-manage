package io.renren.modules.devops.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.renren.common.utils.PageUtils;
import io.renren.modules.devops.entity.MachineEntity;

import java.util.Map;

/**
 * 服务管理
 *
 * @author Chase
 * @email pangcq699885@126.com
 * @date 2019-05-06 16:11:24
 */
public interface MachineService extends IService<MachineEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

