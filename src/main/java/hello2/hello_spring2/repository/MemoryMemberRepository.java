package hello2.hello_spring2.repository;

import hello2.hello_spring2.domain.Member;

import java.util.*;

public class MemoryMemberRepository implements MemberRepository {
    //Map-> 키-값 쌍으로 데이터를 저장하는 제너릭 컬렉션
    private static Map<Long, Member> store=new HashMap<>();
    private static long sequence=0L;
    @Override
    public Member save(Member member) {
        member.setId(++sequence);
        store.put(member.getId(),member);
        return member;
    }

    @Override
    public Optional<Member> findById(Long id) {
        return Optional.ofNullable( store.get(id));
    }

    @Override
    public Optional<Member> findByname(String name) {
        //파라미터로 넘어온 name과 같은지 확인.
        return store.values().stream()
                .filter(member->member.getName().equals(name)).findAny();
    }

    @Override
    public List<Member> findAll() {
        return new ArrayList<>(store.values());   //store에 있는 member들 쭉 반환
    }

    public void clearStore(){
        store.clear();
    }

}
