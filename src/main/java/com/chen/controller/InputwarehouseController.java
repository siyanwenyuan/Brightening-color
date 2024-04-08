package com.chen.controller;


import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.chen.common.Result;
import com.chen.entity.Customer;
import com.chen.entity.Inputwarehouse;
import com.chen.mapper.CustomerMapper;
import com.chen.mapper.InputwarehouseMapper;
import com.chen.service.InputwarehouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/inputwarehouse")
@CrossOrigin
public class InputwarehouseController {



    @Autowired
    private InputwarehouseService inputwarehouseService;
    @Autowired
    private InputwarehouseMapper inputwarehouseMapper;

    @PostMapping
    public Result<?> save(@RequestBody Inputwarehouse inputwarehouse){

        inputwarehouseService.save(inputwarehouse);
        return Result.success();
    }

    /**
     * 更新接口
     */
    @PutMapping
    public Result<?> update(@RequestBody Inputwarehouse inputwarehouse)
    {

        inputwarehouseService.update(inputwarehouse);
        return Result.success();


    }



    /**
     * 模糊分页查询
     * @param pageNumber
     * @param pageSize
     * @param search
     * @return
     */
    @GetMapping
    public Result<?> selectPage(@RequestParam(defaultValue = "1")Integer pageNumber,
                                @RequestParam(defaultValue = "10") Integer pageSize,
                                @RequestParam(defaultValue = "") String search)
    {

        IPage<Inputwarehouse> page=new Page<>(pageNumber,pageSize);
        IPage<Inputwarehouse> inputwarehouseIPage = inputwarehouseService.selectPage(page, search);
        return Result.success(inputwarehouseIPage);
      /*  Page<Inputwarehouse> inputwarehousePage = inputwarehouseMapper.selectPage(new Page<>(pageNumber, pageSize), new LambdaQueryWrapper<Inputwarehouse>().eq(Inputwarehouse::getInputwarehouseName, search));
        return Result.success(inputwarehousePage);
*/
    }

    /**
     * 删除接口
     */

    @DeleteMapping("/{id}")
    public Result<?> deleteById(@PathVariable Long id)

    {

        inputwarehouseService.deleteById(id);
        return Result.success();
    }


}
