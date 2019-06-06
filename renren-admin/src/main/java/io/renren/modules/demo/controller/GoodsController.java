package io.renren.modules.demo.controller;

import java.util.Arrays;
import java.util.Map;

import io.renren.common.validator.ValidatorUtils;
import io.renren.modules.demo.entity.GoodsEntity;
import io.renren.modules.demo.service.GoodsService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;


/**
 * 商品管理
 *
 * @author Mark
 * @email sunlightcs@gmail.com
 * @date 2019-05-06 14:09:10
 */
@RestController
@RequestMapping("demo/goods")
public class GoodsController {
    @Autowired
    private GoodsService goodsService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("demo:goods:list")
    public R list(@RequestParam Map<String, Object> params) {
        PageUtils page = goodsService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{goodsId}")
    @RequiresPermissions("demo:goods:info")
    public R info(@PathVariable("goodsId") Long goodsId) {
        GoodsEntity goods = goodsService.getById(goodsId);

        return R.ok().put("goods", goods);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("demo:goods:save")
    public R save(@RequestBody GoodsEntity goods) {
        goodsService.save(goods);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("demo:goods:update")
    public R update(@RequestBody GoodsEntity goods) {
        ValidatorUtils.validateEntity(goods);
        goodsService.updateById(goods);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("demo:goods:delete")
    public R delete(@RequestBody Long[] goodsIds) {
        goodsService.removeByIds(Arrays.asList(goodsIds));

        return R.ok();
    }

}
