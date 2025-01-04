package hello2.hello_spring2.repository;

import hello2.hello_spring2.domain.Member;

import java.lang.management.MemoryManagerMXBean;
import java.util.List;
import java.util.Optional;

public interface MemberRepository {
    Member save(Member member);
    Optional<Member> findById(Long id);  //Optional=> null로 인해 발생할 수 있는 문제를 방지
    Optional<Member> findByname(String name);
    List<Member> findAll();   //지금까지 저장된 회원 리스트 반환
}
