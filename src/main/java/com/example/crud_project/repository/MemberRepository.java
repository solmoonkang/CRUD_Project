package com.example.crud_project.repository;

import com.example.crud_project.domain.entity.Member;
import com.example.crud_project.domain.memberDto.ReadDto;
import org.springframework.boot.autoconfigure.data.jpa.JpaRepositoriesAutoConfiguration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.security.Identity;
import java.util.List;
import java.util.Optional;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {

    // TODO OPTIONAL 사용
    // Optional이란 - NULL일 수도 있는 객체를 감싸는 일종의 Wrapper 클래스
    // 형식 - Optional<T> optional
    // optional 변수 내부에는 null이 아닌 T객체가 있을 수도 있고 null이 있을 수도 있으므로
    // Optional 클래스는 여러가지 API를 제공하여 null일 수도 있는 객체를 다룰 수 있도록 도움

    Optional<Member> findByIdentity(String identity);
    Optional<Member> findByName(String name);
    Member save(Member member);
    List<Member> findAll();

    // 중복 여부 확인
    // 아이디 중복 여부 확인
    boolean existsByIdentity(String identity);
    // 이메일 중복 여부 확인
    boolean existsByEmail(String email);
    // 전화번호 중복 여부 확인
    boolean existsByCellphone(String cellphone);

}
