package com.gctcw.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.gctcw.persistent.entity.IeoKlinedata;

/**
 * <p>
 * IEO 1min/15min kline 服务类
 * </p>
 *
 * @author gctcw
 * @since 2022-11-17
 */
public interface IeoKlinedataService extends IService<IeoKlinedata> {

    /**
     * 根据ctime判断插入或更新数据
     *
     * @param ieoKlinedata
     */
    void insertOrUpdate(IeoKlinedata ieoKlinedata);
}
