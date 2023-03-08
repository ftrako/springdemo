package com.ftrako.demo.service.impl;

import com.ftrako.demo.service.MyService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
public class MyServiceImpl implements MyService {
    private static final Logger logger = LogManager.getLogger(MyServiceImpl.class);

    @Async
    @Override
    public void doWork() {
        logger.debug("service调用的线程名字："+Thread.currentThread().getName());
    }

    @Override
    public String what() {
        logger.debug("service调用的线程what名字："+Thread.currentThread().getName());
        return "say hello";
    }
}
