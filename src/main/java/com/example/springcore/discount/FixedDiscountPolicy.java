package com.example.springcore.discount;

import com.example.springcore.member.Grade;
import com.example.springcore.member.Member;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("FixedDiscountPolicy")
public class FixedDiscountPolicy implements DiscountPolicy {
    private int fixedDiscount = 1000;  // 1000원 할인

    @Override
    public int discount(Member member, int price) {
        if (member.getGrade() == Grade.VIP) {
            return fixedDiscount;
        } else {
            return 0;
        }
    }
}
