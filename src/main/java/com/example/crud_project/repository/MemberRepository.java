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

    // TODO
    Member findByIdentity(String identity);
    Member findByName(String name);
    Member save(Member member);

}
