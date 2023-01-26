package com.example.springcore;

import com.example.springcore.discount.DiscountPolicy;
import com.example.springcore.discount.FixedDiscountPolicy;
import com.example.springcore.member.MemberRepository;
import com.example.springcore.member.MemberService;
import com.example.springcore.member.MemberServiceImpl;
import com.example.springcore.member.MemoryMemberRepository;
import com.example.springcore.order.OrderService;
import com.example.springcore.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 애플리케이션의 실제 동작에 필요한 구현 객체 생성
 * 생성한 인스턴스의 참조를 생성자를 통해서 주입해줌
 */
// @Configuration을 빼면 스프링 컨테이너가 관리하지 않아 싱글톤 보장하지 않음 (Method annotated with @Bean is called directly. Use dependency injection instead.)
@Configuration
public class AppConfig {

    // Configuration SingletonTest
    // Expected:
//    call AppConfig.memberService
//    call AppConfig.memberRepository
//    call AppConfig.memberRepository
//    call AppConfig.orderService
//    call AppConfig.memberRepository
    // Actual:
//    call AppConfig.memberService
//    call AppConfig.memberRepository
//    call AppConfig.orderService

    @Bean
    public MemberService memberService() {
        System.out.println("call AppConfig.memberService");
        return new MemberServiceImpl(memberRepository());  // 생성자 주입
    }

    @Bean
    public MemberRepository memberRepository() {
        System.out.println("call AppConfig.memberRepository");
        return new MemoryMemberRepository();
    }

    @Bean
    public OrderService orderService() {
        System.out.println("call AppConfig.orderService");
        return new OrderServiceImpl(memberRepository(), discountPolicy());
//        return null;
    }

    @Bean
    public DiscountPolicy discountPolicy() {
        return new FixedDiscountPolicy();
    }
}
