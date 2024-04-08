package com.chen.entity;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("outwarehouse")
public class Outwarehouse {


    @TableId(value = "id",type = IdType.AUTO)
    private Integer id;
    private String outwarehouseOrder;
    private String outwarehouseName;
    private String outwarehouseSpecification;
    private String outwarehouseNumber;
    private String outwarehousePrice;
    private Date outwarehouseTime;
    private String outwarehouseDescription;
}
