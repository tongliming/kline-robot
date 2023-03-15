package com.gctcw.strategy;

import com.gctcw.common.KlineType;
import com.gctcw.persistent.entity.IeoKlinedata;
import com.gctcw.persistent.mapper.IeoKlinedataMapper;
import com.gctcw.utils.MathUtil;
import com.gctcw.utils.QueryWrapperUtil;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
@Slf4j
@AllArgsConstructor
public class Min15KlineResolve implements KlineStrategy {

    private final IeoKlinedataMapper ieoKlinedataMapper;

    /**
     * 获取K线类型
     *
     * @return KlineType
     */
    @Override
    public KlineType getType() {
        return KlineType.MIN15;
    }

    /**
     * 生成 15Min K线数据
     *
     * @param ieoKlinedata
     */
    @Override
    public void generateData(IeoKlinedata ieoKlinedata) {
        long ctime = Long.parseLong(ieoKlinedata.getCtime());
        ieoKlinedata.setCtime(String.valueOf(ctime - MathUtil.remainder(ctime, KlineType.MIN15)));
        IeoKlinedata databaseKline = QueryWrapperUtil.selectOne(ieoKlinedata, ieoKlinedataMapper);
        if (databaseKline == null) {
            databaseKline = ieoKlinedata;
            BigDecimal rateDecimal = MathUtil.getRate(databaseKline.getPrice(), databaseKline.getClose());
            databaseKline.setRate(rateDecimal.toPlainString());
            log.info("Save 15 min -> {}", databaseKline);
            ieoKlinedataMapper.insert(databaseKline);
        } else {
            databaseKline.setClose(ieoKlinedata.getClose());
            databaseKline.setVol(new BigDecimal(databaseKline.getVol()).add(new BigDecimal(ieoKlinedata.getVol())).toPlainString());
            String lowPrice = databaseKline.getLow().compareTo(ieoKlinedata.getLow()) < 0 ? databaseKline.getLow() : ieoKlinedata.getLow();
            databaseKline.setLow(lowPrice);
            String highPrice = databaseKline.getHigh().compareTo(ieoKlinedata.getHigh()) > 0 ? databaseKline.getHigh() : ieoKlinedata.getHigh();
            databaseKline.setHigh(highPrice);
            BigDecimal rateDecimal = MathUtil.getRate(databaseKline.getPrice(), databaseKline.getClose());
            databaseKline.setRate(rateDecimal.toPlainString());
            log.info("Update 15 min -> {}", databaseKline);
            ieoKlinedataMapper.updateById(databaseKline);
        }
    }
}
