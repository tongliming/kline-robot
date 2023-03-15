package com.gctcw.utils;

import com.gctcw.common.KlineType;

import java.math.BigDecimal;

public class MathUtil {
    /**
     * 取余
     *
     * @param number
     * @param klineType
     * @return
     */
    public static long remainder(long number, KlineType klineType) {
        return number % klineType.getSecond();
    }

    /**
     * 判断是否是倍数
     *
     * @param number
     * @param klineType
     * @return
     */
    public static boolean isMultiple(long number, KlineType klineType){
        return remainder(number, klineType) == 0L;
    }

    /**
     * 取变化率
     *
     * @param open
     * @param close
     * @return
     */
    public static BigDecimal getRate(String open, String close) {
        BigDecimal openDecimal = new BigDecimal(open);
        BigDecimal closeDecimal = new BigDecimal(close);
        BigDecimal diffPrice = closeDecimal.subtract(openDecimal);
        return diffPrice.divide(openDecimal, 4, BigDecimal.ROUND_HALF_UP).multiply(new BigDecimal("100"));
    }

}
