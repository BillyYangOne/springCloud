package com.billy.exception;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.PrintWriter;
import java.io.StringWriter;

/**
 * @author Billy
 * @description: 异常信息文件工具类
 *  日志信息往往伴随着异常信息的输出，因此，我们需要修改统一异常的处理器，将异常信息以流的方式写到日志文件中
 * @date 2020/5/11 18:04
 */
@Slf4j
public class ExceptionUtil {

    private static Logger logger = LoggerFactory.getLogger(ExceptionUtil.class);

    /**
     * 打印异常信息
     * @param e
     * @return
     */
    public static String getMessage(Exception e) {
        String swStr = null;

        try {
            StringWriter stringWriter = new StringWriter();
            PrintWriter pw = new PrintWriter(stringWriter);
            e.printStackTrace(pw);
            pw.flush();
            swStr = stringWriter.toString();
        } catch (Exception ex) {
            ex.printStackTrace();
            logger.error(ex.getMessage());
        }

        return swStr;
    }
}
