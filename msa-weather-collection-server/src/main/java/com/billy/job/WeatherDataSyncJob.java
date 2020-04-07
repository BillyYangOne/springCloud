package com.billy.job;

import com.billy.service.WeatherDataCollectionService;
import com.billy.vo.City;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.QuartzJobBean;

import java.util.ArrayList;
import java.util.List;

/**
 * @description 同步数据定时任务
 * @author Billy
 */
public class WeatherDataSyncJob extends QuartzJobBean {

    private final static Logger logger = LoggerFactory.getLogger(WeatherDataSyncJob.class);

    @Autowired
    private WeatherDataCollectionService dataCollectionService;

    @Override
    protected void executeInternal(JobExecutionContext jobExecutionContext) throws JobExecutionException {

        logger.info("天气数据同步·····");

        //TODO 修改为由城市数据API微服务来提供数据
        List<City> cityList = null;

        try {
            cityList = new ArrayList<>();
            City city = new City();
            city.setCityId("101280601");
            cityList.add(city);
        } catch (Exception e) {
            logger.error("获取城市信息异常！" , e);
            throw new RuntimeException("获取城市信息服务异常", e);
        }

        if (cityList != null && cityList.size() > 0) {

            for (City city : cityList) {

                logger.info("开始同步数据,cityId:" + city.getCityId());
                dataCollectionService.syncDataByCityId(city.getCityId());
                logger.info("同步数据完成,cityId:" + city.getCityId());
            }
        }


    }
}
