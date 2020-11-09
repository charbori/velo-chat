package couhensoft.velochat.repository;

import couhensoft.velochat.domain.Member;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class MemoryMemberRepositoryTest {

    MemberRepository repository = new MemoryMemberRepository();

    @AfterEach
    public void afterEach(){
        repository.clear();
    }

    @Test
    public void save(){

        Member member = new Member();
        member.setMem_name("spring");
        member.setMem_password("spring");
        member.setMem_email("spring");

        repository.save(member);

        Member result = repository.findById(member.getMem_id()).get();

        Assertions.assertEquals(member,result);
    }

    @Test
    public void findByName(){
        Member member1 = new Member();
        member1.setMem_name("spring");
        member1.setMem_password("spring");
        member1.setMem_email("spring");

        Member member2 = new Member();
        member1.setMem_name("spring");
        member1.setMem_password("spring");
        member1.setMem_email("spring");

        repository.save(member1);
        repository.save(member2);

        Member result = repository.findByName("spring").get();

        Assertions.assertEquals(member1, result);
    }

    @Test
    public void findAll(){
        Member member1 = new Member();
        member1.setMem_name("spring");
        member1.setMem_password("spring");
        member1.setMem_email("spring");

        Member member2 = new Member();
        member1.setMem_name("spring");
        member1.setMem_password("spring");
        member1.setMem_email("spring");

        repository.save(member1);
        repository.save(member2);

        //List<Member> result = repository.findAll();
        //Assertions.assertEquals(2, result.size());
    }
}