package com.ftrako.demo.controller.api;

import com.ftrako.demo.service.MyService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 主页
 *
 * @author ftrako
 * @version 1.0 2022-10-26 15:27
 **/
@RestController
public class IndexController {
    private static final Logger logger = LogManager.getLogger(IndexController.class);

    @Resource
    private MyService myService;

    @GetMapping("/hello")
    public String index() {
        logger.debug("hello调用的线程名字："+Thread.currentThread().getName());
        myService.doWork();             // 异步
        myService.doWork();             // 异步
        myService.what();               // 同步
        String what = myService.what(); // 同步
        logger.debug("finished!!!" + what);
        return "hello";
    }
}
