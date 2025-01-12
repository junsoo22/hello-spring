package hello2.hello_spring2;

import hello2.hello_spring2.repository.JdbcTemplateMemberRepository;
import hello2.hello_spring2.repository.JpaMemberRepository;
import hello2.hello_spring2.repository.MemberRepository;
import hello2.hello_spring2.repository.MemoryMemberRepository;
import hello2.hello_spring2.service.MemberService;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class SpringConfig {

    //private final EntityManager em;
    private final MemberRepository memberRepository;

    public SpringConfig(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

//    @Autowired
//    public SpringConfig(EntityManager em) {
//
//        this.em = em;
//    }

    @Bean    //빈 등록하겠다.
    public MemberService memberService(){
        return new MemberService(memberRepository);
        // return new MemberService(memberRepository());   //스프링 빈에 등록하라는 뜻이므로 이 logic 호출해서 bean에 등록해줌
    }

//    @Bean
//    public MemberRepository memberRepository(){
//        //return new MemoryMemberRepository();
//        //return new JdbcTemplateMemberRepository(dataSource);
//        return new JpaMemberRepository(em);
//    }

}
