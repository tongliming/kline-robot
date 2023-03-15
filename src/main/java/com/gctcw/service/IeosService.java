package com.gctcw.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.gctcw.persistent.entity.Ieos;

import java.util.List;

/**
 * <p>
 * IEO币种服务类
 * </p>
 *
 * @author gctcw
 * @since 2022-11-17
 */
public interface IeosService extends IService<Ieos> {

    /**
     * 查询所有正常状态IEO币种
     * @return
     */
    List<Ieos> selectIeosListNormal();

}
