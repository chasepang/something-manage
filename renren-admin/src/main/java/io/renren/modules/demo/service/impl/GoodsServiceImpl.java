package io.renren.modules.demo.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.modules.demo.dao.GoodsDao;
import io.renren.modules.demo.entity.GoodsEntity;
import io.renren.modules.demo.service.GoodsService;
import org.springframework.stereotype.Service;

import java.util.Map;

import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;


@Service("goodsService")
public class GoodsServiceImpl extends ServiceImpl<GoodsDao, GoodsEntity> implements GoodsService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<GoodsEntity> page = this.page(
                new Query<GoodsEntity>().getPage(params),
                new QueryWrapper<GoodsEntity>()
        );

        return new PageUtils(page);
    }

}
