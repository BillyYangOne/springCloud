package com.billy.service.impl;

import com.billy.service.CityDataService;
import com.billy.util.XmlBuilder;
import com.billy.vo.City;
import com.billy.vo.CityList;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;

@Service
public class CityDataServiceImpl implements CityDataService {


    @Override
    public List<City> listCity() throws Exception {

        // 读取xml 文件中的城市信息
        Resource resource = new ClassPathResource("cityList.xml");
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(resource.getInputStream(), "UTF-8"));
        StringBuffer buffer = new StringBuffer();
        String line = "";

        while ((line = bufferedReader.readLine()) != null) {
            buffer.append(line);
        }
        bufferedReader.close();

        // xml字符串转换成 java 对象
        if (buffer.length() > 0) {

            CityList cityList = (CityList) XmlBuilder.xmlStr2Object(CityList.class, buffer.toString());
            return cityList.getCityList();
        }

        return null;
    }
}
