package com.gctcw.strategy;

import com.gctcw.common.KlineType;
import com.gctcw.persistent.entity.IeoKlinedata;
import com.gctcw.persistent.entity.IeoKlinedatas;
import com.gctcw.persistent.mapper.IeoKlinedatasMapper;
import com.gctcw.utils.BeansUtil;
import com.gctcw.utils.MathUtil;
import com.gctcw.utils.QueryWrapperUtil;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
@Slf4j
@AllArgsConstructor
public class Min30KlineResolve implements KlineStrategy{

    private final IeoKlinedatasMapper ieoKlinedatasMapper;

    /**
     * 获取K线类型
     *
     * @return KlineType
     */
    @Override
    public KlineType getType() {
        return KlineType.MIN30;
    }

    /**
     * 生成K线数据
     *
     * @param ieoKlinedata
     */
    @Override
    public void generateData(IeoKlinedata ieoKlinedata) {
        long ctime = Long.parseLong(ieoKlinedata.getCtime());
        ieoKlinedata.setCtime(String.valueOf(ctime - MathUtil.remainder(ctime, KlineType.MIN30)));
        IeoKlinedatas ieoKlinedatas = QueryWrapperUtil.selectOne(ieoKlinedata, ieoKlinedatasMapper);
        if (ieoKlinedatas == null) {
            ieoKlinedatas = BeansUtil.copy(ieoKlinedata);
            BigDecimal rateDecimal = MathUtil.getRate(ieoKlinedatas.getPrice(), ieoKlinedatas.getClose());
            ieoKlinedatas.setRate(rateDecimal.toPlainString());
            log.info("Save 30 min -> {}", ieoKlinedatas);
            ieoKlinedatasMapper.insert(ieoKlinedatas);
        } else {
            ieoKlinedatas.setClose(ieoKlinedata.getClose());
            ieoKlinedatas.setVol(new BigDecimal(ieoKlinedatas.getVol()).add(new BigDecimal(ieoKlinedata.getVol())).toPlainString());
            String lowPrice = ieoKlinedatas.getLow().compareTo(ieoKlinedata.getLow()) < 0 ? ieoKlinedatas.getLow() : ieoKlinedata.getLow();
            ieoKlinedatas.setLow(lowPrice);
            String highPrice = ieoKlinedatas.getHigh().compareTo(ieoKlinedata.getHigh()) > 0 ? ieoKlinedatas.getHigh() : ieoKlinedata.getHigh();
            ieoKlinedatas.setHigh(highPrice);
            BigDecimal rateDecimal = MathUtil.getRate(ieoKlinedatas.getPrice(), ieoKlinedatas.getClose());
            ieoKlinedatas.setRate(rateDecimal.toPlainString());
            log.info("Update 30 min -> {}", ieoKlinedatas);
            ieoKlinedatasMapper.updateById(ieoKlinedatas);
        }
    }
}
