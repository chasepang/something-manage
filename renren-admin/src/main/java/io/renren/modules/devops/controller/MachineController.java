package io.renren.modules.devops.controller;

import java.util.Arrays;
import java.util.Map;

import io.renren.common.validator.ValidatorUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.renren.modules.devops.entity.MachineEntity;
import io.renren.modules.devops.service.MachineService;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;



/**
 * 服务管理
 *
 * @author Chase
 * @email pangcq699885@126.com
 * @date 2019-05-06 16:11:24
 */
@RestController
@RequestMapping("devops/machine")
public class MachineController {
    @Autowired
    private MachineService machineService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("devops:machine:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = machineService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{machineId}")
    @RequiresPermissions("devops:machine:info")
    public R info(@PathVariable("machineId") Long machineId){
        MachineEntity machine = machineService.getById(machineId);

        return R.ok().put("machine", machine);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("devops:machine:save")
    public R save(@RequestBody MachineEntity machine){
        machineService.save(machine);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("devops:machine:update")
    public R update(@RequestBody MachineEntity machine){
        ValidatorUtils.validateEntity(machine);
        machineService.updateById(machine);
        
        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("devops:machine:delete")
    public R delete(@RequestBody Long[] machineIds){
        machineService.removeByIds(Arrays.asList(machineIds));

        return R.ok();
    }

}
