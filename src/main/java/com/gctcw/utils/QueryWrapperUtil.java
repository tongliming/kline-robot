package com.gctcw.utils;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.gctcw.persistent.entity.IeoKlinedata;
import com.gctcw.persistent.entity.IeoKlinedatas;
import com.gctcw.persistent.mapper.IeoKlinedataMapper;
import com.gctcw.persistent.mapper.IeoKlinedatasMapper;

public class QueryWrapperUtil {

    public static IeoKlinedata selectOne(IeoKlinedata ieoKlinedata, IeoKlinedataMapper ieoKlinedataMapper) {
        QueryWrapper<IeoKlinedata> queryWrapper = new QueryWrapper();
        queryWrapper.eq("pid", ieoKlinedata.getPid())
                .eq("types", ieoKlinedata.getTypes())
                .eq("ctime", ieoKlinedata.getCtime())
                .last("limit 1");
        return ieoKlinedataMapper.selectOne(queryWrapper);
    }

    public static IeoKlinedatas selectOne(IeoKlinedata ieoKlinedata, IeoKlinedatasMapper ieoKlinedatasMapper) {
        QueryWrapper<IeoKlinedatas> queryWrapper = new QueryWrapper();
        queryWrapper.eq("pid", ieoKlinedata.getPid())
                .eq("types", ieoKlinedata.getTypes())
                .eq("ctime", ieoKlinedata.getCtime())
                .last("limit 1");
        return ieoKlinedatasMapper.selectOne(queryWrapper);
    }
}
