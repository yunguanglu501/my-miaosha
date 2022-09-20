package com.example.miaosha.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * StockDO
 * 
 * @author wcy
 */

@Data
@TableName(value = "stock")
public class Stock {
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 名称
     */
    @TableField(value = "`name`")
    private String name;

    /**
     * 库存
     */
    @TableField(value = "`count`")
    private Integer count;

    /**
     * 已售
     */
    @TableField(value = "sale")
    private Integer sale;

    /**
     * 乐观锁，版本号
     */
    @TableField(value = "version")
    private Integer version;
}