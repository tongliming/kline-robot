package com.gctcw.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.gctcw.common.Constants;
import com.gctcw.persistent.entity.Ieos;
import com.gctcw.persistent.entity.RobotSetKlineData;
import com.gctcw.persistent.mapper.IeosMapper;
import com.gctcw.service.IeosService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * IEO币种实现类
 * </p>
 *
 * @author gctcw
 * @since 2022-11-17
 */
@Service
public class IeosServiceImpl extends ServiceImpl<IeosMapper, Ieos> implements IeosService {
    /**
     * 查询所有正常状态IEO币种
     *
     * @return List<Ieos>
     */
    @Override
    public List<Ieos> selectIeosListNormal() {
        QueryWrapper<Ieos> ieosQueryWrapper = new QueryWrapper();
        ieosQueryWrapper.eq("status", Constants.IEO_STATUS_NORMAL);
        return list(ieosQueryWrapper);
    }
}
