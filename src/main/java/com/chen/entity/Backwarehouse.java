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
@TableName("backwarehouse")
public class Backwarehouse {


    @TableId(value = "id",type = IdType.AUTO)
    private Integer id;
    private String backwarehouseName;
    private Date backwarehouseTime;
    private Integer backwarehouseNumber;
    private String backware;






}
