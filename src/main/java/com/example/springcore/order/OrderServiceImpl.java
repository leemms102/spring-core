package com.example.springcore.order;

import com.example.springcore.discount.DiscountPolicy;
import com.example.springcore.member.Member;
import com.example.springcore.member.MemberRepository;
import com.example.springcore.member.MemberService;
import com.example.springcore.member.MemberServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
// @RequiredArgsConstructor  // final 변수 생성자 자동 생성해줌
public class OrderServiceImpl implements OrderService {
    private final MemberRepository memberRepository;
    private final DiscountPolicy discountPolicy;  // Client가 인터페이스에만 의존
    // private final이면 여기서나 생성자에서만 넣어줄 수 있음
    // final로 불변을 지키고 생성자 의존관계 누락을 막아줌

//      1. 필드 이름을 빈 이름과 일치시켜 선택
//    @Autowired
//    private DiscountPolicy rateDiscountPolicy;


    @Autowired  // 생성자 하나만 있으면 생략 가능
    public OrderServiceImpl(MemberRepository memberRepository, @Qualifier("mainDiscountPolicy") DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
        System.out.println(this);
        System.out.println(this.memberRepository);
        System.out.println(this.discountPolicy );
    }

//    @Autowired
//    public void setMemberRepository(MemberRepository memberRepository) {
//        System.out.println("memberRepository = " + memberRepository);
//        this.memberRepository = memberRepository;
//    }
//
//    @Autowired
//    public void setDiscountPolicy(DiscountPolicy discountPolicy) {
//        System.out.println("discountPolicy = " + discountPolicy);
//        this.discountPolicy = discountPolicy;
//    }


//    @Autowired // 수정자와 동일
//    public void init(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
//        this.memberRepository = memberRepository;
//        this.discountPolicy = discountPolicy;
//    }

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }

    // 싱글톤 테스트
    public MemberRepository getMemberRepository() {
        return memberRepository;
    }
}