package hello2.hello_spring2.repository;

import hello2.hello_spring2.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

//인터페이스가 인터페이스 받을 땐 extends 사용
public interface SpringDataJpaMemberRepository extends JpaRepository<Member,Long>, MemberRepository {

    //select m from Member m where m.name=?
    @Override
    Optional<Member> findByname(String name);
}
