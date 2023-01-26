package com.example.springcore;

import com.example.springcore.discount.DiscountPolicy;
import com.example.springcore.member.MemberRepository;
import com.example.springcore.member.MemoryMemberRepository;
import com.example.springcore.order.OrderService;
import com.example.springcore.order.OrderServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
// @Component가 붙은 모든 클래스를 스프링 빈에 등록
@ComponentScan(
        // 아래 패키지만 탐색
        basePackages = "com.example.springcore",
        // 제외할 클래스
        excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class)
)
public class AutoAppConfig {

    // ComponentScan으로 자동 등록되는 빈과 똑같은 이름으로 수동 등록
    // 수동 등록 되는 빈이 자동 등록되는 빈 override
    @Bean(name = "memoryMemberRepository")
    MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }
    // @SpringBootApplication에서는 오류 발생
    // application.properties에 allow-bean-definition-overriding=true로 하면 고쳐짐
}

