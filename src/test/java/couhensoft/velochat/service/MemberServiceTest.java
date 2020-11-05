package couhensoft.velochat.service;

import couhensoft.velochat.domain.Member;
import couhensoft.velochat.repository.MemoryMemberRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MemberServiceTest {

    MemberService memberService;
    MemoryMemberRepository memberRepository;

    @BeforeEach
    void beforeEach(){
        memberRepository = new MemoryMemberRepository();
        memberService = new MemberService(memberRepository);
    }

    @AfterEach
    void afterEach(){
        memberRepository.clear();
    }

    @Test
    void 회원가입() {
        //given
        Member member = Member.builder()
                .mem_id(12323)
                .mem_name("sdfs")
                .mem_email("sdfs")
                .mem_password("asfsa")
                .build();

        //when
        Long saveId = memberService.join(member);

        //then
        Member result = memberService.findOne(saveId).get();
        Assertions.assertEquals(member, result);

    }

    @Test
    public void 중복_회원_예외(){
        //given
        Member member1 = Member.builder()
                .mem_name("spring")
                .mem_password("hash")
                .mem_email("email")
                .build();

        Member member2 = Member.builder()
                .mem_name("spring")
                .mem_password("hash")
                .mem_email("email")
                .build();

        //when
        memberService.join(member1);
        IllegalStateException e = assertThrows(IllegalStateException.class, () -> memberService.join(member2));

        Assertions.assertEquals(e.getMessage(), "이미 존재하는 회원입니다.");

        /*
        memberService.join(member1);
        try{
            memberService.join(member2);
            fail();
        }catch(IllegalStateException e){
            Assertions.assertEquals("이미 존재하는 회원입니다.",e.getMessage());
        }
        */
        //then


    }

    @Test
    void 모든멤버조회() {

    }

    @Test
    void 멤버조회() {

    }

}