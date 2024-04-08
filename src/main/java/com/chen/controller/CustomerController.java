package com.chen.controller;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.chen.common.Result;
import com.chen.entity.Customer;
import com.chen.entity.Customer;
import com.chen.mapper.CustomerMapper;
import com.chen.mapper.CustomerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/customer")
public class CustomerController {


    @Autowired
    private CustomerMapper customerMapper;

    @PostMapping
    public Result<?> save(@RequestBody Customer customer){

        customerMapper.insert(customer);
        return Result.success();
    }

    /**
     * 更新接口
     */
    @PutMapping
    public Result<?> update(@RequestBody Customer customer)
    {

        customerMapper.updateById(customer);
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

        Page<Customer> customerPage = customerMapper.selectPage(new Page<>(pageNumber, pageSize),
                new LambdaQueryWrapper<Customer>().like(Customer::getCustomerName,search));
        return Result.success(customerPage);
    }

    /**
     * 删除接口
     */

    @DeleteMapping("/{id}")
    public Result<?> deleteById(@PathVariable Long id)

    {
        customerMapper.deleteById(id);
        return Result.success();
    }



}
