package com.example.springcore.scan;

import com.example.springcore.AutoAppConfig;
import com.example.springcore.member.MemberService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.lang.annotation.Annotation;

import static org.assertj.core.api.Assertions.*;

public class AutoAppConfigTest {
    @Test
    void basicScan() {
        // 설정 정보로 AutoAppConfig 넘겨줌: ClassPathBeanDefinitionScanner 호출 -> 싱글톤 빈 인스턴스 생성
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AutoAppConfig.class);

        MemberService memberService = ac.getBean(MemberService.class);
        assertThat(memberService).isInstanceOf(MemberService.class);
    }

}
