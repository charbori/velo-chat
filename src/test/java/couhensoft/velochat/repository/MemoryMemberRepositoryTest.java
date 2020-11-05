package couhensoft.velochat.repository;

import couhensoft.velochat.domain.Member;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class MemoryMemberRepositoryTest {

    MemberRepository repository = new MemoryMemberRepository();

    @AfterEach
    public void afterEach(){
        repository.clear();
    }

    @Test
    public void save(){

        Member member = Member.builder()
                .mem_name("spring")
                .mem_password("hash")
                .mem_email("email")
                .build();

        repository.save(member);

        Member result = repository.findById(member.getMem_id()).get();

        Assertions.assertEquals(member,result);
    }

    @Test
    public void findByName(){
        Member member1 = Member.builder()
                .mem_name("spring")
                .mem_password("hash")
                .mem_email("email")
                .build();
        repository.save(member1);

        Member member2 = Member.builder()
                .mem_name("spring")
                .mem_password("hash")
                .mem_email("email")
                .build();
        repository.save(member2);

        Member result = repository.findByName("spring1").get();

        Assertions.assertEquals(member1, result);
    }

    @Test
    public void findAll(){
        Member member1 = Member.builder()
                .mem_name("spring")
                .mem_password("hash")
                .mem_email("email")
                .build();
        repository.save(member1);

        Member member2 = Member.builder()
                .mem_name("spring")
                .mem_password("hash")
                .mem_email("email")
                .build();
        repository.save(member2);

        List<Member> result = repository.findAll();
        Assertions.assertEquals(2, result.size());
    }
}