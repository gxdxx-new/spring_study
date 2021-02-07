package hello.studyspring.repository;

import hello.studyspring.domain.Member;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {
    Member save(Member member);
    Optional<Member> findById(Long id); //Optional<> : null이 반환되면 null을 감싸서 반환
    Optional<Member> findByName(String name);
    List<Member> findAll();
}
