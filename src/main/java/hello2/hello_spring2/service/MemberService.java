package hello2.hello_spring2.service;

import hello2.hello_spring2.domain.Member;
import hello2.hello_spring2.repository.MemberRepository;
import hello2.hello_spring2.repository.MemoryMemberRepository;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

public class MemberService {
    private final MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository) {//외부에서 넣어주도록 바꿔줌
        this.memberRepository = memberRepository;
    }

    //회원가입
    public Long join(Member member){
        //같은 이름이 있는 중복 회원X
        validateDuplicateMember(member);  //중복회원검증
        memberRepository.save(member);
        return member.getId();
    }

    private void validateDuplicateMember(Member member) {
        memberRepository.findByname(member.getName())
                .ifPresent(m->{
            throw new IllegalStateException("이미 존재하는 회원입니다.");
        });
    }

    //전체 회원 조회
    public List<Member>findMembers(){
        return memberRepository.findAll();
    }
    public Optional<Member>findOne(Long memberId){
        return memberRepository.findById(memberId);
    }
}
