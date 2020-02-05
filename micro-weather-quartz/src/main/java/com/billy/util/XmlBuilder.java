package com.billy.util;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.StringReader;

/**
 * @description xml工具类，用于读取xml 文件
 * @author BillyYang
 */
public class XmlBuilder {

    /**
     * 将 xml 字符串转换成 POJO
     * @param clazz
     * @param xmlStr
     * @return
     */
    public static Object xmlStr2Object(Class<?> clazz, String xmlStr) throws JAXBException {

        Object result = null;
        StringReader stringReader = null;
        JAXBContext context = JAXBContext.newInstance(clazz);
        Unmarshaller unmarshaller = context.createUnmarshaller();
        stringReader = new StringReader(xmlStr);
        result = unmarshaller.unmarshal(stringReader);
        if (null != stringReader) {
            stringReader.close();
        }
        return result;
    }
}
