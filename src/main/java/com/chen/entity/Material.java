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
@TableName("material")
public class Material {

    @TableId(value = "id",type = IdType.AUTO)
    private Integer id;
    private String  materialName;
    private String  materialPrice;
    private String  materialSource;
    private String  materialTarget;
    private String  materialLevel;
    private String  materialDescription;



}
