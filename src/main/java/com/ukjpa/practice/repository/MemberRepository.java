package com.ukjpa.practice.repository;

import com.ukjpa.practice.DTO.MemberDTO;
import com.ukjpa.practice.entity.MemberEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<MemberEntity,Long> {
    Optional<MemberEntity> findByMemberEmail(String memberEmail);
}
