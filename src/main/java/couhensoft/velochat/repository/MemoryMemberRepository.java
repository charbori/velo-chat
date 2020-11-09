package couhensoft.velochat.repository;

import couhensoft.velochat.domain.Member;

import java.util.*;

public class MemoryMemberRepository implements MemberRepository {

    private static final Map<Long, Member> store = new HashMap<>();
    private static long sequence = 0L;

    @Override
    public Member save(Member member) {
        member.setMem_id(++sequence);
        store.put(member.getMem_id(), member);
        return member;
    }

    @Override
    public Optional<Member> findById(Long id) {
        return Optional.ofNullable(store.get(id));
    }

    @Override
    public Optional<Member> findByName(String name) {
        return store.values().stream()
                .filter(member -> member.getMem_name().equals(name))
                .findAny();
    }

    @Override
    public Optional<Member> checkLogin(String name, String pw){


        return null;

    }

    @Override
    public List<Member> findAll() {
        return new ArrayList<>(store.values());
    }

    @Override
    public void clear(){
        store.clear();
    }
}
