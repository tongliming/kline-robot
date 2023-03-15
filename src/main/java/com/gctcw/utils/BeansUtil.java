package com.gctcw.utils;

import com.gctcw.persistent.entity.IeoKlinedata;
import com.gctcw.persistent.entity.IeoKlinedatas;

public class BeansUtil {

    public static IeoKlinedatas copy(IeoKlinedata ieoKlinedata) {
        IeoKlinedatas ieoKlinedatas = new IeoKlinedatas();
        ieoKlinedatas.setPid(ieoKlinedata.getPid());
        ieoKlinedatas.setCtime(ieoKlinedata.getCtime());
        ieoKlinedatas.setLow(ieoKlinedata.getLow());
        ieoKlinedatas.setHigh(ieoKlinedata.getHigh());
        ieoKlinedatas.setPrice(ieoKlinedata.getPrice());
        ieoKlinedatas.setClose(ieoKlinedata.getClose());
        ieoKlinedatas.setVol(ieoKlinedata.getVol());
        ieoKlinedatas.setTypes(ieoKlinedata.getTypes());
        return ieoKlinedatas;
    }

    public static IeoKlinedata copySelf(IeoKlinedata ieoKlinedata) {
        IeoKlinedata tmp = new IeoKlinedata();
        tmp.setPid(ieoKlinedata.getPid());
        tmp.setCtime(ieoKlinedata.getCtime());
        tmp.setLow(ieoKlinedata.getLow());
        tmp.setHigh(ieoKlinedata.getHigh());
        tmp.setPrice(ieoKlinedata.getPrice());
        tmp.setClose(ieoKlinedata.getClose());
        tmp.setVol(ieoKlinedata.getVol());
        tmp.setTypes(ieoKlinedata.getTypes());
        return tmp;
    }
}
