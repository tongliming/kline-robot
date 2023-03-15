package com.gctcw.persistent.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;

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
@TableName("ieos")
public class Ieos implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId("id")
    private Integer id;

    @TableField("currency_id")
    private Integer currencyId;

    @TableField("pay_currency_id")
    private String payCurrencyId;

    @TableField("title")
    private String title;

    @TableField("logo")
    private String logo;

    @TableField("summary")
    private String summary;

    @TableField("price")
    private BigDecimal price;

    @TableField("amount")
    private String amount;

    @TableField("min")
    private BigDecimal min;

    @TableField("total_sell")
    private BigDecimal totalSell;

    /**
     * 配售数量
     */
    @TableField("sell_amount")
    private BigDecimal sellAmount;

    @TableField("content")
    private String content;

    @TableField("start_at")
    private LocalDateTime startAt;

    @TableField("end_at")
    private LocalDateTime endAt;

    @TableField("sell_begin")
    private LocalDateTime sellBegin;

    @TableField("pdf")
    private String pdf;

    @TableField("videos")
    private String videos;

    /**
     * 1正常 2
     */
    @TableField("status")
    private Integer status;

    @TableField("total_apply")
    private Integer totalApply;

    @TableField("win_rate")
    private BigDecimal winRate;

    @TableField("link")
    private String link;

    @TableField("white_book")
    private String whiteBook;

    @TableField("time_status")
    private Integer timeStatus;

    @TableField("updated_at")
    private String updatedAt;

    @TableField("pro")
    private String pro;

    @TableField("loss")
    private String loss;

    @TableField("setprice")
    private String setprice;


}
