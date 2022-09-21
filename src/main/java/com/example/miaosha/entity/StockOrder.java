package com.example.miaosha.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.time.LocalDateTime;
import lombok.Data;

/**
 * StockOrderDO
 * 
 * @author wcy
 */

@Data
@TableName(value = "stock_order")
public class StockOrder {
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 库存ID
     */
    @TableField(value = "sid")
    private Integer sid;

    /**
     * 商品名称
     */
    @TableField(value = "`name`")
    private String name;

    /**
     * 创建时间
     */
    @TableField(value = "create_time")
    private LocalDateTime createTime;
}