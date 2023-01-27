package com.example.springcore.discount;

import com.example.springcore.annotation.MainDiscountPolicy;
import com.example.springcore.member.Grade;
import com.example.springcore.member.Member;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Qualifier("mainDiscountPolicy")    // 2. @Qualifier 이름으로 의존관계 명시
// @MainDiscountPolicy 4. custom annotation
@Primary    // 3. @Primary는 가정 우선적으로 의존관계 주입
public class RateDiscountPolicy implements DiscountPolicy {
    private int discountPercent = 10;

    @Override
    public int discount(Member member, int price) {
        if(member.getGrade() == Grade.VIP) {
            return price * discountPercent / 100;
        } else {
            return 0;
        }
    }
}
