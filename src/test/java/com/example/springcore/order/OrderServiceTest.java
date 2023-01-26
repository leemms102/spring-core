package com.example.springcore.order;

import com.example.springcore.AppConfig;
import com.example.springcore.discount.DiscountPolicy;
import com.example.springcore.discount.FixedDiscountPolicy;
import com.example.springcore.member.*;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class OrderServiceTest {
    MemberService memberService;
    OrderService orderService;

    @BeforeEach
    public void beforeEach() {
        AppConfig appConfig = new AppConfig();
        memberService = appConfig.memberService();
        orderService = appConfig.orderService();
//
//        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
//
//        memberService = applicationContext.getBean("memberService", MemberService.class);
//        orderService = applicationContext.getBean("orderService", OrderService.class);
    }

    //    MemberService memberService = new MemberServiceImpl(memberRepository);
    @Test
    void createOrder() {
        Long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId, "itemA", 10000);
        Assertions.assertThat(order.getDiscountPrice()).isEqualTo(1000);
    }

//    @Test
//    void fieldInjectionTest() {
//        OrderServiceImpl orderService = new OrderServiceImpl(new MemoryMemberRepository(), new FixedDiscountPolicy());
//
//        // 필드 주입했지만 객체가 없으므로 set 안하면 NPE 발생
//        orderService.setMemberRepository(new MemoryMemberRepository());
//        orderService.setDiscountPolicy(new FixedDiscountPolicy());
//
//        orderService.createOrder(1L, "itemA", 10000);
//    }
}
