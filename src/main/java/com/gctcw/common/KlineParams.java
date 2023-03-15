package com.gctcw.common;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class KlineParams {
    private BigDecimal[] klinePriceArr;   // 每天k线96个点数据
    private LocalDate lastDate;           // k线日期
    private BigDecimal lastPrice;         // 上次价格，这个价格主要用于获取不到最新K线的情况
    private int minuteIndex;              // 价格浮动计算分钟级
    private BigDecimal pricePercent;      // 价格波动参数，默认1%
    private BigDecimal randPricePercent;  // 价格浮动计算分钟级波动参数
    private int lastIndexStart ;          // 上次获取价格取件点
    private int tendIndex;                // 随机策略
}
