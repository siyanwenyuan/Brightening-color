package com.chen.service;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.chen.common.Result;
import com.chen.entity.Inputwarehouse;
import com.chen.mapper.InputwarehouseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InputwarehouseService {

    @Autowired
    private InputwarehouseMapper inputwarehouseMapper;

    public void save(Inputwarehouse inputwarehouse) {
        inputwarehouseMapper.insert(inputwarehouse);
    }

    public void update(Inputwarehouse inputwarehouse){
        inputwarehouseMapper.updateById(inputwarehouse);
    }



    public void deleteById(Long id) {
        inputwarehouseMapper.deleteById(id);

    }

    public IPage<Inputwarehouse> selectPage(IPage<Inputwarehouse> page, String search) {
      return   inputwarehouseMapper.selectPage(page,new LambdaQueryWrapper<Inputwarehouse>().
                like(Inputwarehouse::getInputwarehouseName,search));
    }
}
