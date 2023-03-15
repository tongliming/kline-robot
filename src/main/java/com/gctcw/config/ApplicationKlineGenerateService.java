package com.gctcw.config;

import com.gctcw.common.KlineType;
import com.gctcw.persistent.entity.IeoKlinedata;
import com.gctcw.strategy.KlineStrategy;
import com.gctcw.utils.BeansUtil;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class ApplicationKlineGenerateService implements ApplicationContextAware {
    private Map<KlineType, KlineStrategy> klineStrategyMap = new HashMap<>();

    public void resolveKlineData(IeoKlinedata ieoKlinedata) {
        klineStrategyMap.forEach(
                (klineType, klineStrategy) -> {
                    IeoKlinedata tmp = BeansUtil.copySelf(ieoKlinedata);
                    tmp.setTypes(klineType.getType());
                    klineStrategy.generateData(tmp);
                }
        );
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        Map<String, KlineStrategy> beans = applicationContext.getBeansOfType(KlineStrategy.class);
        beans.values().forEach(klineStrategy -> {
            klineStrategyMap.put(klineStrategy.getType(), klineStrategy);
        });
    }
}
