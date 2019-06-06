package io.renren.modules.devops.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.modules.devops.dao.MachineDao;
import io.renren.modules.devops.entity.MachineEntity;
import io.renren.modules.devops.service.MachineService;


@Service("machineService")
public class MachineServiceImpl extends ServiceImpl<MachineDao, MachineEntity> implements MachineService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<MachineEntity> page = this.page(
                new Query<MachineEntity>().getPage(params),
                new QueryWrapper<MachineEntity>()
        );

        return new PageUtils(page);
    }

}
