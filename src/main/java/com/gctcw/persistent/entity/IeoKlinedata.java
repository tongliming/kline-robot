package com.gctcw.persistent.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * <p>
 * 
 * </p>
 *
 * @author gctcw
 * @since 2022-11-17
 */
@Getter
@Setter
@TableName("ieo_klinedata")
@ToString
public class IeoKlinedata implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * projectid
     */
    @TableField("pid")
    private Integer pid;

    /**
     * 涨跌幅
     */
    @TableField("rate")
    private String rate;

    /**
     * 当前价格
     */
    @TableField("price")
    private String price;

    /**
     * 时间
     */
    @TableField("ctime")
    private String ctime;

    @TableField("high")
    private String high;

    @TableField("low")
    private String low;

    @TableField("vol")
    private String vol;

    @TableField("close")
    private String close;

    /**
     * 分时线
     */
    @TableField("types")
    private Integer types;


}
