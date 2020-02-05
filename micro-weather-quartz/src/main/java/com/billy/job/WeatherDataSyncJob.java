package com.billy.job;

import com.billy.service.CityDataService;
import com.billy.service.WeatherService;
import com.billy.vo.City;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.QuartzJobBean;

import java.util.List;

/**
 * @description 同步数据定时任务
 * @author Billy
 */
public class WeatherDataSyncJob extends QuartzJobBean {

    private final static Logger logger = LoggerFactory.getLogger(WeatherDataSyncJob.class);

    @Autowired
    private CityDataService cityDataService;

    @Autowired
    private WeatherService weatherService;

    @Override
    protected void executeInternal(JobExecutionContext jobExecutionContext) throws JobExecutionException {

        logger.info("天气数据同步·····");
        try {
            List<City> cities = cityDataService.listCity();
            if (cities != null && cities.size() > 0) {

                for (City city : cities) {

                    logger.info("开始同步数据,cityId:" + city.getCityId());

                    weatherService.syncDataByCityId(city.getCityId());
                    logger.info("同步数据完成,cityId:" + city.getCityId());
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
            logger.error("获取城市信息异常", e);
        }


    }
}
