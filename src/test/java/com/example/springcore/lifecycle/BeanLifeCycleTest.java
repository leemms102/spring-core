package com.example.springcore.lifecycle;

import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

public class BeanLifeCycleTest {
    @Test
    public void lifeCycleTest() {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(LifeCycleConfig.class);
        NetworkClient client = ac.getBean(NetworkClient.class);
        ac.close();
    }

    @Configuration
    static class LifeCycleConfig {

//        스프링 빈 생명주기 콜백 - 2. 빈 등록 초기화, 소멸 메소드
//        @Bean(initMethod = "init", destroyMethod = "close")
        // 설정 정보이기 때문에 외부 라이브러리에도 적용가능
        // initMethod, destroyMethod 명시 안해도 메소드 이름으로 추론해서 호출
        @Bean
        public NetworkClient networkClient() {
            NetworkClient networkClient = new NetworkClient();
            networkClient.setUrl("http://hello-spring.dev");

            return networkClient;
        }
    }
}
