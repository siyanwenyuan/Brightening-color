package com.chen.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.chen.common.Result;
import com.chen.entity.Inputwarehouse;
import com.chen.entity.Outwarehouse;
import com.chen.service.OutwarehouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/outwarehouse")
@CrossOrigin
public class OutwarehouseController {


    @Autowired
    private OutwarehouseService outwarehouseService;



    @PostMapping
    public Result<?> save(@RequestBody Outwarehouse outwarehouse){

        outwarehouseService.save(outwarehouse);
        return Result.success();
    }

    /**
     * 更新接口
     */
    @PutMapping
    public Result<?> update(@RequestBody Outwarehouse outwarehouse)
    {

        outwarehouseService.update(outwarehouse);
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

        IPage<Outwarehouse> page=new Page<>(pageNumber,pageSize);
        IPage<Outwarehouse> outwarehouseIPage = outwarehouseService.selectPage(page, search);
        return Result.success(outwarehouseIPage);

    }

    /**
     * 删除接口
     */

    @DeleteMapping("/{id}")
    public Result<?> deleteById(@PathVariable Long id)

    {

        outwarehouseService.deleteById(id);
        return Result.success();
    }



}
