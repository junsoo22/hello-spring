package hello2.hello_spring2.repository;

import hello2.hello_spring2.domain.Member;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityManager;

import java.util.List;
import java.util.Optional;

public class JpaMemberRepository implements MemberRepository{
    private final EntityManager em;   //jpa는 entitymanager라는 것으로 동작함

    public JpaMemberRepository(EntityManager em) {
        this.em = em;
    }

    @Override
    public Member save(Member member) {
        em.persist(member);
        return member;
    }

    @Override
    public Optional<Member> findById(Long id) {
        Member member= em.find(Member.class,id);
        return Optional.ofNullable(member);
    }

    @Override
    public Optional<Member> findByname(String name) {
        List<Member> result=em.createQuery("select m from Member m where m.name=:name",Member.class)
                .setParameter("name",name).getResultList();
        return result.stream().findAny();
    }

    @Override
    public List<Member> findAll() {
        return em.createQuery("select m from Member m",Member.class).getResultList();

    }
}
