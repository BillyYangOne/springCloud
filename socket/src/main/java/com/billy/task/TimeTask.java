package com.billy.task;

import com.billy.controller.MyWebSocket;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Date;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 * 定时任务，用于socket 发送信息
 */
@Component
@EnableScheduling
public class TimeTask {

    private static Logger logger = LoggerFactory.getLogger(TimeTask.class);

    @Scheduled(cron = "0/1 * * * * ?")
    public void test() {

        System.out.println("--------------------  定时任务 开始  -----------------------");
        CopyOnWriteArraySet<MyWebSocket> webSockets = MyWebSocket.getWebSockets();

        webSockets.forEach(myWebSocket -> {
            try {
                myWebSocket.sendMessage(" 定时任务发送：" + new Date().toString());
            } catch (IOException e) {
                logger.error("定时发送消息异常", e);
                e.printStackTrace();
            }
        });
        System.out.println("--------------------  定时任务 结束  -----------------------");


    }
}
