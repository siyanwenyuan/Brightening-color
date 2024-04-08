package com.chen.service;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.chen.entity.Outwarehouse;
import com.chen.mapper.OutwarehouseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OutwarehouseService {

    @Autowired
    private OutwarehouseMapper outwarehouseMapper;

    public void save(Outwarehouse outwarehouse) {
        outwarehouseMapper.insert(outwarehouse);
    }

    public void update(Outwarehouse outwarehouse) {
        outwarehouseMapper.updateById(outwarehouse);
    }

    public IPage<Outwarehouse> selectPage(IPage<Outwarehouse> page, String search) {
        IPage<Outwarehouse> outwarehouseIPage = outwarehouseMapper.selectPage(page, new LambdaQueryWrapper<Outwarehouse>().like(Outwarehouse::getOutwarehouseName, search));
        return outwarehouseIPage;
    }

    public void deleteById(Long id) {
        outwarehouseMapper.deleteById(id);
    }
}
