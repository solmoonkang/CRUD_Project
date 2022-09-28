package com.example.crud_project.repository;

import com.example.crud_project.domain.entity.Member;
import com.example.crud_project.domain.memberDto.ReadDto;
import org.springframework.boot.autoconfigure.data.jpa.JpaRepositoriesAutoConfiguration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {

    // TODO OPTIONAL 사용
    Member findByIdentity(String identity);
    Member save(Member member);
    // 중복 여부 확인
    boolean existsByIdentity(String identity);
    boolean existsByEmail(String email);
    boolean existsByCellphone(String cellphone);

}
