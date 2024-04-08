package com.chen.entity;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("customer")
public class Customer {


    @TableId(value = "id",type = IdType.AUTO)
    private Integer id;
    private String customerName;
    private String customerAge;
    private String customerSex;
    private String customerAddress;
    private String customerPhone;
    private String customerCompany;
    private String customerWechat;



}
