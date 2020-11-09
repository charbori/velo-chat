package couhensoft.velochat.repository;

import couhensoft.velochat.domain.Member;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {
    Member save(Member member);
    Optional<Member> findById(Long id);
    Optional<Member> findByName(String name);
    boolean checkLogin(String name, String pw);
    List<Member> findAll();
    void clear();
}
