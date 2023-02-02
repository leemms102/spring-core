package com.example.springcore.web;

import com.example.springcore.common.MyLogger;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequiredArgsConstructor
public class LogDemoController {

    private final LogDemoService logDemoService;

    // http 요청이 오기 전에 request scope인 myLogger를 컨테이너에게 주입받아야함
    // request scope bean 부재 - 1. Provider로 myLogger 탐색
    private final MyLogger myLogger;
//    private final ObjectProvider<MyLogger> myLoggerProvider;

    // Http 요청이 들어오기 전까지는 가짜 객체를 만들어 사용하다가 진짜 메소드 호출해줌
    @RequestMapping("log-demo")
    @ResponseBody
    public String logDemo(HttpServletRequest request) throws InterruptedException {
        String requestURL = request.getRequestURL().toString();
//        MyLogger myLogger = myLoggerProvider.getObject();
        System.out.println("myLogger = " + myLogger.getClass());
        myLogger.setRequestUrl(requestURL);

        myLogger.log("controller test");
//        Thread.sleep(1000);
        logDemoService.logic("testID");
        return "OK";
    }
}
