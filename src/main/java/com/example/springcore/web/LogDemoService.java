package com.example.springcore.web;

import com.example.springcore.common.MyLogger;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LogDemoService {

//    private final ObjectProvider<MyLogger> myLoggerProvider;
    private final MyLogger myLogger;

    public void logic(String id) {
//        MyLogger myLogger = myLoggerProvider.getObject();
        myLogger.log("serviceID = " + id);
        // requestURL, uuid 안넘기는 이유: 웹 정보는 컨트롤러까지만 사용하고 서비스 계층은 순수하게 유지
        // 대신 MyLogger의 멤버변수에 저장
    }
}
