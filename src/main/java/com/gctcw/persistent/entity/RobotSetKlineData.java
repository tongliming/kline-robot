package com.gctcw.persistent.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * <p>
 * 机器人预设的Kline数据
 * </p>
 *
 * @author gctcw
 * @since 2022-11-17
 */
@Getter
@Setter
@TableName("robot_set_kline_data")
@ToString
public class RobotSetKlineData implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * k线数据
     */
    @TableField("kline")
    private String kline;

    /**
     * 时间
     */
    @TableField("kdate")
    private String kdate;

    /**
     * 允许价格浮动比例
     */
    @TableField("pricePencent")
    private Integer pricePencent;

    /**
     * 交易对
     */
    @TableField("symbol")
    private String symbol;

    /**
     * 创建时间
     */
    @TableField("createtime")
    private Integer createtime;

    @TableField("updated_at")
    private LocalDateTime updatedAt;


}
