package com.gctcw.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.gctcw.common.Constants;
import com.gctcw.persistent.entity.RobotSetKlineData;
import com.gctcw.persistent.mapper.RobotSetKlineDataMapper;
import com.gctcw.service.RobotSetKlineDataService;
import com.gctcw.utils.DateTimeUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

/**
 * <p>
 * 机器人预设的Kline数据实现类
 * </p>
 *
 * @author gctcw
 * @since 2022-11-17
 */
@Service
@Slf4j
public class RobotSetKlineDataServiceImpl extends ServiceImpl<RobotSetKlineDataMapper, RobotSetKlineData>
        implements RobotSetKlineDataService {

    /**
     * 获取指定币种Kline数据
     *
     * @param symbol
     * @return RobotSetKlineData
     */
    @Override
    public RobotSetKlineData selectTodayKlineDataBySymbol(String symbol) {
        String strDate = DateTimeUtil.str(LocalDateTime.now(), Constants.DATE_PATTEN);
        QueryWrapper<RobotSetKlineData> klineDataQueryWrapper = new QueryWrapper();
        klineDataQueryWrapper
                .eq("symbol", symbol)
                .eq("kdate", strDate)
                .last("limit 1");
        return getOne(klineDataQueryWrapper);
    }
}
