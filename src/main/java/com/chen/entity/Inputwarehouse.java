package com.chen.entity;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("inputwarehouse")
public class Inputwarehouse {

    @TableId(value = "id",type = IdType.AUTO)
    private Integer id;
    private String inputwarehouseName;
    private String inputwarehouseOrder;
    private String inputwarehouseSpecifications;
    private Integer inputwarehouseNumber;
    private BigDecimal inputwarehousePrice;
    private Date  inputwarehouseTime;
    private String inputwarehouseDesc;


}
