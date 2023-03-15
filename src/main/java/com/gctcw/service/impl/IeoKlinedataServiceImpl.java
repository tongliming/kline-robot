package com.gctcw.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.gctcw.common.KlineType;
import com.gctcw.config.ApplicationKlineGenerateService;
import com.gctcw.persistent.entity.IeoKlinedata;
import com.gctcw.persistent.mapper.IeoKlinedataMapper;
import com.gctcw.service.IeoKlinedataService;
import com.gctcw.utils.MathUtil;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

/**
 * <p>
 * IEO 1min/15min kline 实现类
 * </p>
 *
 * @author gctcw
 * @since 2022-11-17
 */
@Service
@Slf4j
@AllArgsConstructor
public class IeoKlinedataServiceImpl extends ServiceImpl<IeoKlinedataMapper, IeoKlinedata> implements IeoKlinedataService {

    private final ApplicationKlineGenerateService klineGenerateService;

    /**
     * 根据ctime判断插入或更新数据
     * 1 5 15 30 60 240 1440 10080
     *
     * @param ieoKlinedata
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public void insertOrUpdate(IeoKlinedata ieoKlinedata) {
        klineGenerateService.resolveKlineData(ieoKlinedata);
    }


}
