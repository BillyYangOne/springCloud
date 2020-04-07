package com.billy.vo;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @description 城市 vo
 * @author BillyYang
 */
@Data
public class City {

    private String cityId;
    private String cityName;
    private String cityCode;
    private String province;


}
