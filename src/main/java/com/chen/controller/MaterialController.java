package com.chen.controller;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.chen.common.Result;
import com.chen.entity.Customer;
import com.chen.entity.Material;
import com.chen.mapper.CustomerMapper;
import com.chen.mapper.MaterialMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/material")
@CrossOrigin
public class MaterialController {


    @Autowired
    private MaterialMapper materialMapper;

    @PostMapping
    public Result<?> save(@RequestBody Material material){

        materialMapper.insert(material);
        return Result.success();
    }

    /**
     * 更新接口
     */
    @PutMapping
    public Result<?> update(@RequestBody Material material)
    {

        materialMapper.updateById(material);
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

        Page<Material> materialPage = materialMapper.selectPage(new Page<>(pageNumber, pageSize),
                new LambdaQueryWrapper<Material>().like(Material::getMaterialName,search));
        return Result.success(materialPage);
    }

    /**
     * 删除接口
     */

    @DeleteMapping("/{id}")
    public Result<?> deleteById(@PathVariable Long id)

    {
        materialMapper.deleteById(id);
        return Result.success();
    }


}
