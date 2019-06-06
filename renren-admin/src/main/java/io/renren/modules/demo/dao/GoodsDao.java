package io.renren.modules.demo.dao;

import io.renren.modules.demo.entity.GoodsEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 商品管理
 *
 * @author Mark
 * @email sunlightcs@gmail.com
 * @date 2019-05-06 14:09:10
 */
@Mapper
public interface GoodsDao extends BaseMapper<GoodsEntity> {

}
