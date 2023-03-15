package com.gctcw.strategy;

import com.gctcw.common.KlineType;
import com.gctcw.persistent.entity.IeoKlinedata;

/**
 * 1 5 15 30 60 240 1440 10080
 * K线处理
 */
public interface KlineStrategy {

    /**
     * 获取K线类型
     * @return KlineType
     */
    KlineType getType();

    /**
     * 生成K线数据
     * @param ieoKlinedata
     */
    void generateData(IeoKlinedata ieoKlinedata);
}
