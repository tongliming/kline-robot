package com.gctcw.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.gctcw.persistent.entity.RobotSetKlineData;

/**
 * <p>
 * 机器人预设的Kline数据服务类
 * </p>
 *
 * @author gctcw
 * @since 2022-11-17
 */
public interface RobotSetKlineDataService extends IService<RobotSetKlineData> {
    /**
     * 获取指定币种Kline数据
     * @param symbol
     * @return RobotSetKlineData
     */
    RobotSetKlineData selectTodayKlineDataBySymbol(String symbol);
}
