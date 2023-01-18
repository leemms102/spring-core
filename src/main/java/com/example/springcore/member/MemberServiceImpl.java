package com.example.springcore.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("memberServiceEx") // 빈 이름 지정
public class MemberServiceImpl implements MemberService {
    private final MemberRepository memberRepository;

    // AppConfig 대신 ComponentScan으로 스프링 빈 등록: @Autowired로 DI 필요함
    @Autowired  // 타입으로 찾음 = ac.getBean("memberRepository", MemberRepository.class)
    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }


    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }

    // 싱글톤 테스트
    public MemberRepository getMemberRepository() {
        return memberRepository;
    }
}
