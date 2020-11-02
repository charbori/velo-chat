package couhensoft.velochat;

import couhensoft.velochat.repository.JpaMemberRepository;
import couhensoft.velochat.repository.MemberRepository;
import couhensoft.velochat.repository.MemoryMemberRepository;
import couhensoft.velochat.service.MemberService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.persistence.EntityManager;

@Configuration
public class SpringConfig{

    private EntityManager em;

    public SpringConfig(EntityManager em){
        this.em = em;
    }

    @Bean
    public MemberService memberService(){
        return new MemberService(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository(){
        return new JpaMemberRepository(em);
    }

}