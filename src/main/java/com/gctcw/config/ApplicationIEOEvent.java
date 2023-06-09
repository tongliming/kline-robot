package com.gctcw.config;

import com.gctcw.common.KlineParams;
import com.gctcw.rest.IeoAutoGeneratedOrderExplain;
import com.gctcw.service.IeosService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
@Slf4j
public class ApplicationIEOEvent implements ApplicationListener<ContextRefreshedEvent> {

    private final IeosService ieosService;
    private final IeoAutoGeneratedOrderExplain ieoAutoGeneratedOrderExplain;

    public ApplicationIEOEvent(IeosService ieosService, IeoAutoGeneratedOrderExplain ieoAutoGeneratedOrderExplain) {
        this.ieosService = ieosService;
        this.ieoAutoGeneratedOrderExplain = ieoAutoGeneratedOrderExplain;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        log.info("==================== 应用启动初始化 ====================");
        ieosService.selectIeosListNormal().forEach(
                ieos -> {
                    KlineParams klineParams = new KlineParams();
                    klineParams.setKlinePriceArr(new BigDecimal[97]);       // 每天k线96个点数据
                    klineParams.setLastPrice(BigDecimal.ZERO);              // 上次价格，这个价格主要用于获取不到最新K线的情况
                    klineParams.setMinuteIndex(0);                          // 价格浮动计算分钟级
                    klineParams.setPricePercent(BigDecimal.ONE);            // 价格波动参数，默认1%
                    klineParams.setRandPricePercent(BigDecimal.ZERO);       // 价格浮动计算分钟级波动参数
                    klineParams.setLastIndexStart(-1);                      // 上次获取价格取件点
                    klineParams.setTendIndex(0);                            // 随机策略
                    ieoAutoGeneratedOrderExplain.addKlineParams(ieos, klineParams);
                }
        );
    }
}
