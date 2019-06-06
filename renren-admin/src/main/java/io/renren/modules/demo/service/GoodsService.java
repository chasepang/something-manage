package io.renren.modules.demo.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.renren.common.utils.PageUtils;
import io.renren.modules.demo.entity.GoodsEntity;

import java.util.Map;

/**
 * 商品管理
 *
 * @author Mark
 * @email sunlightcs@gmail.com
 * @date 2019-05-06 14:09:10
 */
public interface GoodsService extends IService<GoodsEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

