package couhensoft.velochat.service;

import com.sun.istack.NotNull;
import couhensoft.velochat.controller.MemberForm;
import couhensoft.velochat.domain.Member;
import couhensoft.velochat.repository.MemberRepository;
import couhensoft.velochat.repository.MemoryMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

public class MemberService {

    private final MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository){
        this.memberRepository = memberRepository;
    }

    /**
     * 회원 가입
     */
    public Long join(@NotNull Member member){
        //같은 이름이 있는 중복 회원 X
        validataDuplicateMember(member);

        memberRepository.save(member);

        return member.getMem_id();
    }

    private void validataDuplicateMember(Member member) {
        memberRepository.findByName(member.getMem_name())
                .ifPresent(m ->{
                    throw new IllegalStateException("이미 존재하는 회원입니다.");
                });
    }

    /**
     * 전체 회원 조회
     */
    public List<Member> findMember(){
        return memberRepository.findAll();
    }

    public Optional<Member> findOne(Long memberId){
        return memberRepository.findById(memberId);
    }
}
