package com.example.springcore.lifecycle;

// 스프링 빈 생명주기 콜백 - 1. 인터페이스
// @Override afterPropertiesSet(), destroy(): 매우 초창기 방법
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class NetworkClient {    // implements InitializingBean, DisposableBean

    private String url;

    public NetworkClient() {
        System.out.println("생성자 호출, url = " + url);
//        connect();
//        call("초기화 연결 메시지");
    }

    public void setUrl(String url) {
        this.url = url;
    }

    // 서비스 시작시 호출
    private void connect() {
        System.out.println("connect: " + url);
    }

    public void call(String message) {
        System.out.println("call: " + url + " message = " + message);
    }

    // 서비스 종료시 호출
    public void disconnect() {
        System.out.println("close: " + url);
    }


    // 스프링 빈 생명주기 콜백 - 3. 어노테이션 @PostConstruct, @PreDestroy
    // 가장 권장, 자바 표준 기술
    // 외부 라이브러리에서 사용 못함

    // 의존관계 주입이 끝나면 초기화 작업 실행
    @PostConstruct
    public void init() {
        connect();
        call("초기화 연결 메시지");
    }

    // 빈이 소멸되기 전 실행
    @PreDestroy
    public void close() {
        disconnect();
    }

}
